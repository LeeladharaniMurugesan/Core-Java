package com.chainsys.webapp.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionState
 */
public class SessionState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionState() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head><title>Attributes</title></head><body>");
		String submitValue = request.getParameter("submit");//Request Scope
		HttpSession session = request.getSession(true);//create session id(token)
		System.out.println(session.getId());
		if(submitValue.equals("result")) {
			// response.sendRedirect("Result");//navigating from one servlet to another within the same Website.
			// response.sendRedirect("http://www.google.com");//sendRedirect can also be used to navigate to another website
			RequestDispatcher rd =request.getRequestDispatcher("Result") ;//navigating from one servlet to another within the same Website.
			// cannot also be used to navigate to another website.
			rd.forward(request, response);//parsing the request and response object received by the current servlet to the forwarded servlet.
		}
		else if (submitValue.equals("set")) {
			String salaryInput = request.getParameter("salary");
			session.setAttribute("salary",salaryInput);// storing data in session scope for each user 
			//session.serAttribute() stores the data in the collection using the key and value.
			//salary =key,salaryInput = value
			out.println("<h1>Value Set</h1>" + salaryInput);
		} else if (submitValue.equals("fetch")) {
			String sessionSalary =(String) session.getAttribute("salary");//stateful
			if(sessionSalary == null) {
				out.println("<h1> SESSION NOT YET SET!!</h1>");
			}
//			String sessionSalary = (String)session.getAttribute("salary")
		
		
			else {
			out.println("<h1>Value fetched</h1>" +sessionSalary );//returning value from sessionAttribute
		}
	}
		out.println("</body></html>");
	}

		
	}

