package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Email;

public class EmailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmailListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/index.jsp";
		
		String action = request.getParameter("action");
		if (action == null || action.isEmpty()) {
			action = "join"; //default
		}
		
		if (action.equals("join")) {
			
			url = "/index.jsp"; //join page is /index.jsp
			
		} else if (action.equals("register")) {
		
			String firstName = request.getParameter("first-name");
			String lastName = request.getParameter("last-name");
			String emailAddress = request.getParameter("email");
			
			Email email = new Email(firstName, lastName, emailAddress);
			
		}
		
	}

}
