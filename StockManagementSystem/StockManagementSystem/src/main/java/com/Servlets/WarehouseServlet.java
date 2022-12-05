package com.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.Product;
import com.Model.User;
import com.Model.UserDBUtil;
import com.Model.Warehouse;
import com.Model.productDBUtil;
import com.Model.warehouseDBUtil;

/**
 * Servlet implementation class WarehouseServlet
 */
@WebServlet("/WarehouseServlet")
public class WarehouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WarehouseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		User u=(User)session.getAttribute("userDetails");
		String username=u.getUsername();
		String password=u.getPassword();
		boolean  validity = false;
		//validate warehouse manager
		try {
			 validity = UserDBUtil.validate(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(validity==true) {
			Warehouse w=warehouseDBUtil.getWarehouse(u.getUserID());
			session.setAttribute("warehouseDetails",w);
			
			String var= request.getParameter("ShowProducts");
			String var2= request.getParameter("addProducts");
			String var3= request.getParameter("update");
			String var4= request.getParameter("delete");
			String var5= request.getParameter("logout");
			String var6= request.getParameter("request");
			
			if(var!=null) {
				List<Product> p= productDBUtil.getProductDetails(w.getWarehouseID());
				Product p1= p.get(0);
				System.out.print(p1.getPname());
				 RequestDispatcher dis=request.getRequestDispatcher("showProducts.jsp");
				 request.setAttribute("productList",p);
				 dis.forward(request, response);
				
			}
			else if(var2!=null) {
				RequestDispatcher dis=request.getRequestDispatcher("addproduct.jsp");
				dis.forward(request, response);
				
			}
			else if(var3!=null) {
				RequestDispatcher dis=request.getRequestDispatcher("update.jsp");
				dis.forward(request, response);
				
			}
			else if(var4!=null) {
				RequestDispatcher dis=request.getRequestDispatcher("delete.jsp");
				dis.forward(request, response);
				
			}
			else if(var5!=null) {
				session.invalidate();
				RequestDispatcher dis=request.getRequestDispatcher("userLogin.jsp");
				dis.forward(request, response);
				
			}
		
			
			
			
			
		}
		else {
			 RequestDispatcher dis=request.getRequestDispatcher("WarehouseManager.jsp");
			 dis.forward(request, response);
		}
	}

}
