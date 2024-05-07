package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KhachHangDAO;
import model.KhachHang;
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
		String dongYNhanMail = request.getParameter("dongynhanmail");
		
		
		request.setAttribute("val_hoten", hoten);
		request.setAttribute("val_tendangnhap", tenDangNhap);
		request.setAttribute("val_gioitinh",gioiTinh);
		request.setAttribute("val_ngaysinh", ngaySinh);
		request.setAttribute("val_diachikhachhang", diaChiKhachHang);
		request.setAttribute("val_diachimuahang", diaChiMuaHang);
		request.setAttribute("val_diachinhanhang", diaChiNhanHang);
		request.setAttribute("val_sodienthoai", soDienThoai);
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
			KhachHang kh = new KhachHang(id, tenDangNhap, matKhau, hoten, diaChiKhachHang, diaChiMuaHang, diaChiNhanHang, ngaySinh, soDienThoai, gioiTinh, dongYNhanMail != null?true:false);
			KhachHangDAO.getInstance().insert(kh);
			url = "/customer/success.jsp";
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = MaHoa.encryptPass(request.getParameter("password"));
		
		
		KhachHang kh = KhachHangDAO.getInstance().validateUser(username, password);
		
		String url = "";
		if(kh != null) {
			HttpSession session = request.getSession();
			url = "/index.jsp";
			session.setAttribute("vl_khachhang", kh);
		}
		else {
			url = "/customer/login.jsp";
			String error = "Tên đăng nhập hoặc mật khẩu không đúng";
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
		String diaChi = request.getParameter("diachi");
		String diaChiMuaHang = request.getParameter("diachimuahang");
		String diaChiNhanHang = request.getParameter("diachinhanhang");
		String nhanBanTin = request.getParameter("dongynhanmail");
		
		HttpSession session = request.getSession();
		KhachHang currentKh = (KhachHang)session.getAttribute("vl_khachhang");
		
		
		
		KhachHang updateKh = new KhachHang(currentKh.getMaKhachHang(), currentKh.getTenDangNhap(), currentKh.getMatKhau(), hoTen, diaChi, diaChiMuaHang, diaChiNhanHang, Date.valueOf(ngaySinh), soDienThoai, gioiTinh, nhanBanTin!=null?true:false);
		
		KhachHangDAO.getInstance().update(updateKh);
		
		session.setAttribute("vl_khachhang", updateKh);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/customer/changeinfook.jsp");
		rd.forward(request, response);
	}
}
