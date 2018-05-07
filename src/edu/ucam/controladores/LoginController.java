package edu.ucam.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = { "/login" })
public class LoginController extends MainController {
	private static final long serialVersionUID = 1933599531034509234L;
	
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login de usuario");
		
		getBlocks(request, response, false);		
		request.setAttribute("title", prop.getProperty("Autenticación de usuarios"));		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String passwd = request.getParameter("passwd");
		
		if(passwd == "hola") {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("idUSuario", "1");
			request.getRequestDispatcher("/admin").forward(request, response);
		} else {
			//Mensaje de error			
		}
	}
}
