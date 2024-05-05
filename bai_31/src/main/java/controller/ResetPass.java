package controller;

import java.io.IOException;

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
 * Servlet implementation class ResetPass
 */
@WebServlet("/resetpass")
public class ResetPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		KhachHang currentKh = (KhachHang)session.getAttribute("vl_khachhang");
		
		
		String currentPassword = request.getParameter("currentpassword");
		String newPassword = request.getParameter("newpassword");
		
		String url = "";
		if(!MaHoa.encryptPass(currentPassword).equals(currentKh.getMatKhau())){
			String loikhongdung = "Mật khẩu không đúng !";
			request.setAttribute("loikhongdung", loikhongdung);
			url = "/changepass.jsp";
		}
		else if(MaHoa.encryptPass(newPassword).equals(currentKh.getMatKhau())) {
			String loitrung = "Mật khẩu đã từng được sử dụng ! Vui lòng chọn mật khẩu khác.";
			request.setAttribute("loitrung", loitrung);
			url = "/changepass.jsp";
		}
		
		else {
			currentKh.setMatKhau(MaHoa.encryptPass(newPassword));
			KhachHangDAO.getInstance().update(currentKh);
			url = "/changepassok.jsp";
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
