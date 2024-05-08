package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KhachHangDAO;
import model.KhachHang;
import util.Email;
import util.MaHoa;

/**
 * Servlet implementation class KhachHangController
 */
@WebServlet("/khachhang")
public class KhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("register")) {
			register(request, response);
		}
		else if(action.equals("login")){
			login(request, response);
		}
		else if(action.equals("changepass")) {
			changepass(request, response);
		}
		else if(action.equals("changeinfo")) {
			changeinfo(request, response);
		}
		else if(action.equals("logout")) {
			logout(request,response);
		}
		else if(action.equals("xacthuc")) {
			authen(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String hoten = request.getParameter("hoten");
		String tenDangNhap = request.getParameter("tendangnhap");
		String matKhau = request.getParameter("matkhau");
		String gioiTinh = request.getParameter("gioitinh");
		Date ngaySinh = Date.valueOf(request.getParameter("ngaysinh"));
		String diaChiKhachHang = request.getParameter("diachi");
		String diaChiMuaHang = request.getParameter("diachimuahang");
		String diaChiNhanHang = request.getParameter("diachinhanhang");
		String soDienThoai = request.getParameter("sodienthoai");
		String email = request.getParameter("email");
		String dongYNhanMail = request.getParameter("dongynhanmail");
		
		
		request.setAttribute("val_hoten", hoten);
		request.setAttribute("val_tendangnhap", tenDangNhap);
		request.setAttribute("val_gioitinh",gioiTinh);
		request.setAttribute("val_ngaysinh", ngaySinh);
		request.setAttribute("val_diachikhachhang", diaChiKhachHang);
		request.setAttribute("val_diachimuahang", diaChiMuaHang);
		request.setAttribute("val_diachinhanhang", diaChiNhanHang);
		request.setAttribute("val_sodienthoai", soDienThoai);
		request.setAttribute("val_email", email);
		request.setAttribute("val_dongynhanemail", dongYNhanMail);
		
		
		
		
		String baoLoi = "";
		boolean check = KhachHangDAO.getInstance().containUser(tenDangNhap);
		if(check==true) {
			baoLoi = "Tên đăng nhập đã tồn tại";
		}
		String url = "";
		if(baoLoi.length() > 0) {
			url = "/customer/register.jsp";
			request.setAttribute("val_loi", baoLoi);
		}
		else {
			matKhau = MaHoa.encryptPass(matKhau);
			String id = tenDangNhap + System.currentTimeMillis();
			KhachHang kh = new KhachHang(id, tenDangNhap, matKhau, hoten, diaChiKhachHang, diaChiMuaHang, diaChiNhanHang, ngaySinh, soDienThoai,email, gioiTinh, dongYNhanMail != null?true:false);
			boolean status = KhachHangDAO.getInstance().insert(kh);
			
			
			if(status) {
				//Tạo mã xác thực
				Random rd = new Random();
				String maXacThuc = "";
				for(int i = 0; i < 5; i++) {
					maXacThuc += rd.nextInt(10)+"";
				}
				
				//Tạo thời gian hiệu lực
				Date todaysDate = new Date(new java.util.Date().getTime());
				Calendar c = Calendar.getInstance();
				c.setTime(todaysDate);
				c.add(Calendar.DATE, 1);
				Date thoiGianHieuLuc = new Date(c.getTimeInMillis());
				
				//Tạo trạng thái xác thực
				int trangThaiXacThuc = 0;
				
				kh.setMaXacThuc(maXacThuc);
				kh.setThoiGianHieuLuc(thoiGianHieuLuc);
				kh.setTrangThaiXacThuc(trangThaiXacThuc);
				
				if(KhachHangDAO.getInstance().addVerifyInformation(kh)) {
					Email.sendEmail(kh.getEmail(), "Xác thực tài khoản", noiDungXacThuc(kh));
				}
				
				url = "/customer/success.jsp";
			}
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = MaHoa.encryptPass(request.getParameter("password"));
		
		
		KhachHang kh = KhachHangDAO.getInstance().validateUser(username, password);
		
		String url = "";
		if(kh != null && kh.getTrangThaiXacThuc() == 1) {
			HttpSession session = request.getSession();
			url = "/index.jsp";
			session.setAttribute("vl_khachhang", kh);
		}
		else {
			url = "/customer/login.jsp";
			String error = "Tên đăng nhập hoặc mật khẩu không đúng hoặc chưa được xác thực";
			request.setAttribute("error", error);
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	protected void changepass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		KhachHang currentKh = (KhachHang)session.getAttribute("vl_khachhang");
		
		
		String currentPassword = request.getParameter("currentpassword");
		String newPassword = request.getParameter("newpassword");
		
		String url = "";
		if(!MaHoa.encryptPass(currentPassword).equals(currentKh.getMatKhau())){
			String loikhongdung = "Mật khẩu không đúng !";
			request.setAttribute("loikhongdung", loikhongdung);
			url = "/customer/changepass.jsp";
		}
		else if(MaHoa.encryptPass(newPassword).equals(currentKh.getMatKhau())) {
			String loitrung = "Mật khẩu đã từng được sử dụng ! Vui lòng chọn mật khẩu khác.";
			request.setAttribute("loitrung", loitrung);
			url = "/customer/changepass.jsp";
		}
		
		else {
			currentKh.setMatKhau(MaHoa.encryptPass(newPassword));
			KhachHangDAO.getInstance().update(currentKh);
			url = "/customer/changepassok.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
			String url = "/index.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}
	
	protected void changeinfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String hoTen = request.getParameter("hoten");
		String gioiTinh = request.getParameter("gioitinh");
		String ngaySinh = request.getParameter("ngaysinh");
		String soDienThoai = request.getParameter("sodienthoai");
		String email = request.getParameter("email");
		String diaChi = request.getParameter("diachi");
		String diaChiMuaHang = request.getParameter("diachimuahang");
		String diaChiNhanHang = request.getParameter("diachinhanhang");
		String nhanBanTin = request.getParameter("dongynhanmail");
		
		HttpSession session = request.getSession();
		KhachHang currentKh = (KhachHang)session.getAttribute("vl_khachhang");
		
		
		
		KhachHang updateKh = new KhachHang(currentKh.getMaKhachHang(), currentKh.getTenDangNhap(), currentKh.getMatKhau(), hoTen, diaChi, diaChiMuaHang, diaChiNhanHang, Date.valueOf(ngaySinh), soDienThoai,email, gioiTinh, nhanBanTin!=null?true:false);
		
		KhachHangDAO.getInstance().update(updateKh);
		
		session.setAttribute("vl_khachhang", updateKh);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/customer/changeinfook.jsp");
		rd.forward(request, response);
	}
	
	private String noiDungXacThuc(KhachHang k) {
		String link = "http://localhost:8080/bai_39/khachhang?action=xacthuc&makhachhang="+k.getMaKhachHang()+"&maxacthuc="+k.getMaXacThuc();
		String content = "<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "    <p>Xin chào <strong>"+k.getHoTen()+"</strong></p>\r\n"
				+ "    <p>Vui lòng xác thực tài khoản bằng cách nhập mã <strong>"+k.getMaXacThuc()+"</strong>, hoặc click trực tiếp vào đường link sau đây</p>\r\n"
				+ "    <p><a href=\""+link+"\">"+link+"</a></p>\r\n"
				+ "    <p>Đây là email tự động. Vui lòng không phản hồi email này</p>\r\n"
				+ "    <p>Xin cảm ơn !</p>\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>";
		return content;
	}
	
	protected void authen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maKhachHang = request.getParameter("makhachhang");
		String maXacThuc = request.getParameter("maxacthuc");
		
		//System.out.println(maKhachHang);
		KhachHang kh = KhachHangDAO.getInstance().selectById(maKhachHang);
		String msg = "";
		if(kh != null) {
			
			//Kiểm tra mã xác thực
			if(kh.getMaXacThuc().equals(maXacThuc)) {
				kh.setTrangThaiXacThuc(1);
				KhachHangDAO.getInstance().addVerifyInformation(kh);
				msg = "Tài khoản đã được xác thực";
				KhachHang khData = KhachHangDAO.getInstance().selectById(maKhachHang);
				request.setAttribute("vl_khachhang", khData);
			}
			else {
				msg = "Xác t hực không thành công";
			}
		}
		String url = "/customer/thongbao.jsp";
		request.setAttribute("msg", msg);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
	}
	
}
