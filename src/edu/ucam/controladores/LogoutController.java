package edu.ucam.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = { "/admin/logout" })
public class LogoutController extends AdminController {
	private static final long serialVersionUID = 1933599531034509234L;
	
    public LogoutController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login de usuario");
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		response.sendRedirect(request.getContextPath()+"/inicio");		
	}	
}
