package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KhachHangDAO;
import model.KhachHang;
import util.MaHoa;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			url = "/register.jsp";
			request.setAttribute("val_loi", baoLoi);
		}
		else {
			matKhau = MaHoa.encryptPass(matKhau);
			String id = tenDangNhap + System.currentTimeMillis();
			KhachHang kh = new KhachHang(id, tenDangNhap, matKhau, hoten, diaChiKhachHang, diaChiMuaHang, diaChiNhanHang, ngaySinh, soDienThoai, gioiTinh, dongYNhanMail != null?true:false);
			KhachHangDAO.getInstance().insert(kh);
			url = "/success.jsp";
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
