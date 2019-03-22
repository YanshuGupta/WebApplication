package com.capgemini.billing;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.txw2.Document;

/**
 * Servlet implementation class CreateBill
 */
@WebServlet("/CreateBill")
public class CreateBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBill() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String title = request.getParameter("title");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		double grossSalary = Double.parseDouble((String)request.getParameter("grossSalary"));
		String address = request.getParameter("address");
		
		request.setAttribute("name", title+" "+firstName+" "+lastName);
		request.setAttribute("gross", grossSalary);
		request.setAttribute("address", address);
		
		RequestDispatcher rd = request.getRequestDispatcher("generated");
		rd.forward(request, response);
	}

}
