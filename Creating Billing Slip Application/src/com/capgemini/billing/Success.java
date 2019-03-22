package com.capgemini.billing;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Success
 */
@WebServlet("/Success")
public class Success extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Success() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println(getServletConfig().getInitParameter("data"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = (String) request.getAttribute("name");
		double gross = (double) request.getAttribute("gross");
//		String address = (String) request.getAttribute("address");
		
		double incomeTax = 0;
		double netSalary = 0;
		
		if(gross < 3_00_000) {
			incomeTax = gross*.10;
		}
		else if(gross < 5_00_000) {
			incomeTax = gross*.20;
		}
		else {
			incomeTax = gross*.30;
		}
		PrintWriter out = response.getWriter();
		netSalary = gross - incomeTax;
		
		out.print("<h1><u>Hello "+name+"</u></h1><br>");
		out.print("<h3>Income Tax is: "+incomeTax+"</h3><br>");
		out.print("<h3>Net Salary is: "+netSalary+"</h3><br><br>");
		
		out.print("<h3>servlet config Example</h3><br>");
		ServletConfig sconfig = getServletConfig();
		String databaseName = sconfig.getInitParameter("data");
		out.print("<h3>----Database Name using Servlet Config: "+databaseName+"</h3><br>");
		
		out.print("<h3>servlet context Example</h3><br>");
		ServletContext scontext = getServletContext();
		String data = scontext.getInitParameter("data");
		out.print("<h3>Data using Servlet Context: "+data+"</h3><br>");
		
	}

}
