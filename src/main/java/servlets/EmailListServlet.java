package servlets;

import java.io.IOException;

import data.EmailDB;
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
		
		String action = request.getParameter("action");
		String url = "/index.jsp";
		
		if (action == null || action.isEmpty()) {
			action = "join";
		}
		
		if (action == "join") {
			url = "/index.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/index.jsp";
		String message = "";
		
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
			request.setAttribute("email", email);
			
			if (EmailDB.emailExistsInDataBase(email)) {
				
				message = "O e-mail informado já está registrado em nossa lista.";
				url = "/index.jsp";
				
			} else {
				
				EmailDB.insertEmail(email);
				url = "/registered.jsp";
				
			}
			
		} else if (action.equals("see-registered")) {
			
			url = "/emails.jsp";
			
		}
		
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

}
