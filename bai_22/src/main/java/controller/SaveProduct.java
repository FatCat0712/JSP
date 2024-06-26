package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveProduct
 */
@WebServlet("/saveproduct")
public class SaveProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productId = request.getParameter("productid");
		String productName = request.getParameter("productname");
		String sellingPrice = request.getParameter("sellingprice");
		String purchasePrice = request.getParameter("purchaseprice");
		String expireDate = request.getParameter("expiredate");
		String vat = request.getParameter("vat");
		String description = request.getParameter("description");
		
		//check productId whether valid
		String e_productId = "";
		if(productId.equals("123")) {
			e_productId = "ProductId is exist. Try another one";
		}
		
		String e_sellingPrice = "";
		if(Double.parseDouble(sellingPrice) < Double.parseDouble(purchasePrice)) {
			e_sellingPrice = "Selling price must be equals or higher than Purchase price";
		}
		
		
		//create an attribute to send back to client if error exists
		request.setAttribute("e_productId", e_productId);
		request.setAttribute("e_sellingPrice", e_sellingPrice);
		
		// forward receive values
		request.setAttribute("value_productId", productId);
		request.setAttribute("value_productName", productName);
		request.setAttribute("value_sellingPrice", sellingPrice);
		request.setAttribute("value_purchasePrice", purchasePrice);
		request.setAttribute("value_expireDate", expireDate);
		request.setAttribute("value_vat", vat);
		request.setAttribute("value_description", description);
		
		
		
		//default destination page
		String url = "/success.jsp";

		//if there is an error redirect to product page
		if(e_productId.length() > 0) {
			url = "/product.jsp";
		}
		
		// forward the request
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
