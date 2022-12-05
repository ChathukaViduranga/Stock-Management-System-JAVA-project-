package com.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.Warehouse;
import com.Model.productDBUtil;

/**
 * Servlet implementation class addproductServlet
 */
@WebServlet("/addproductServlet")
public class addproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addproductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		Warehouse w= (Warehouse) session.getAttribute("warehouseDetails");
		System.out.print("warehouse id is"+ w.getWarehouseID());
		
		int pid=Integer.parseInt(request.getParameter("pid"));
		System.out.println("pid is"+pid);
		String name=request.getParameter("pname");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		boolean valid=productDBUtil.addProduct(pid, name, w.getWarehouseID(), quantity);
		if(valid=true) {
			System.out.println("Product Created Successfully");
			 RequestDispatcher dis=request.getRequestDispatcher("WarehouseManager.jsp");
			 dis.forward(request, response);
		}
		
		
	}

}
