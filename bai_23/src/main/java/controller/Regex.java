package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Regex
 */
@WebServlet("/regex")
public class Regex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String quantity = request.getParameter("quantity");
		String phoneNumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		boolean checkError = false;
		try {
			int q = Integer.parseInt(quantity);
			
			if(q<=0) {
				checkError = true;
				request.setAttribute("e_quantity", "Quantity must be positive");
			}
		}
		catch (NumberFormatException e) {
			checkError = true;
			request.setAttribute("e_quantity", "Quantity is not valid");
		}
		
		//write regex for phone number
		Pattern phoneNumberRegex = Pattern.compile("\\d{10}");
		Matcher m_phoneNumberRegex = phoneNumberRegex.matcher(phoneNumber);
		
		if(!m_phoneNumberRegex.find()) {
			checkError = true;
			request.setAttribute("e_phoneNumber","Phone Number is invalid");
		}
		
		//write regex for email
		Pattern emailRegex = Pattern.compile("\\w+(\\.\\w+)*@\\w+(\\.\\w+)+");
		Matcher m_emailRegex = emailRegex.matcher(email);
		
		if(!m_emailRegex.find()) {
			checkError = true;
			request.setAttribute("e_email", "Email is not valid");
		}
		
		request.setAttribute("value_quantity", quantity);
		request.setAttribute("value_phoneNumber", phoneNumber);
		request.setAttribute("value_email", email);
		
		
		
		
		
		String url = "/index.jsp";
		if(!checkError) {
			request.setAttribute("success", "!@@! Pass !@@!");
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
