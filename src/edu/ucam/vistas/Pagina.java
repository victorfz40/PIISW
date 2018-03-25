package edu.ucam.vistas;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.User;

public class Pagina  {
	private static final long serialVersionUID = 1L;
    public Pagina() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println("doPost");
		User u=new User(request.getParameter("user"), request.getParameter("password"));
		if(u.validUser()){
			System.out.println("Siiii");
			request.setAttribute("user",u);
			request.getRequestDispatcher("/jsp/bienvenida.jsp").forward(request, response);
		}else{
			System.out.println("No");
			request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
		}*/
	}
	public void crearPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=new User("vic","123456");
		request.setAttribute("user", u);
		request.getRequestDispatcher("/pagina.jsp").forward(request, response);
		
	}

	
}
