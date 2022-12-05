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

import com.Model.User;
import com.Model.UserDBUtil;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//gets user credintials
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		boolean valid = false;
		
		
			try {
				valid=UserDBUtil.validate(username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (valid==true) {
				 System.out.println("true");
				 
				 //get user
				 
				 List<User>use = UserDBUtil.getUser(username);
				 
				 User u= use.get(0);
				HttpSession session= request.getSession();
				session.setAttribute("userDetails", u);
				session.setAttribute("fname", u.getFname());
				session.setAttribute("lname", u.getLname());
				 String type=u.getType();
				 
				 //check user type
				 if(type.equals("WM")) {
					 System.out.println("Warehouse Manager");
					 RequestDispatcher dis=request.getRequestDispatcher("WarehouseManager.jsp");
					 request.setAttribute("user",use);
					 dis.forward(request, response);
				 }
				 else  if(type.equals("ST")) {
					 System.out.println("Stock Manager");
					 
				 }
				 else  if(type.equals("SP")) {
					 System.out.println("Supplier");
					 
					 
				 }
				 
				
			}
			else {
				System.out.println("false");
                RequestDispatcher dis=request.getRequestDispatcher("error.jsp");
				dis.forward(request, response);
			}
		
	}

}
