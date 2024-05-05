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

/**
 * Servlet implementation class ChangeInfo
 */
@WebServlet("/changeinfo")
public class ChangeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/changeinfook.jsp");
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
