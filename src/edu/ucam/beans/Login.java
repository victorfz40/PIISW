package edu.ucam.beans;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User
 */
@WebServlet(
		urlPatterns = { "/user" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("doPost");
		User u=new User(request.getParameter("user"), request.getParameter("password"));
		if(u.validUser()){
			System.out.println("Siiii");
			request.setAttribute("user",u);
			request.getRequestDispatcher("/jsp/bienvenida.jsp").forward(request, response);
		}else{
			System.out.println("No");
			request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
		}
		
		//this.getServletContext().getRequestDispatcher("/Tarea3/jsp/bienvenida.jsp").forward(request,response);
		//request.setAttribute("parametro1", "valor1");
		//request.getRequestDispatcher("/jsp/bienvenida.jsp").forward(request, response);
		//this.getServletContext().getRequestDispatcher("/jsp/bienvenida.jsp").forward(request,response); //no me funciona
	}

}
