package com.chainsys.webapp.second;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SigninServlet
 */
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SigninServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String id = session.getId();
        System.out.println("id : "+id);
        String option = request.getParameter("submit"); // name
        if(option.equals("logoff")){                   // value 
            session.invalidate();
            // the session terminated. 
            return;
        }
        String url = "UserServlet";       
        String encodedUrl = response.encodeURL(url);  //  This method is used when client donot accept cookies . 
                                                     //    So the session tracking is not possible with cookies.
                                                    //    This method adds session id to the end of URL.
        System.out.println(encodedUrl);
		
		 RequestDispatcher rd = request.getRequestDispatcher(encodedUrl); //The RequestDispatcher interface provides the facility of dispatching the request to another resource it may be html, servlet or jsp.
		 rd.forward(request, response);
		 
        
    }

}