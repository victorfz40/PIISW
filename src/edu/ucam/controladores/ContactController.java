package edu.ucam.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = { "/contact" })
public class ContactController extends MainController {
	private static final long serialVersionUID = 1933599531034509234L;
	
    public ContactController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Contacto");
		
		getBlocks(request, response, false);		
		request.setAttribute("titulo", prop.getProperty("Formulario de contacto"));		
		request.getRequestDispatcher("/contact.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("nombre");
		String email = request.getParameter("email");
		String comentario= request.getParameter("comentario");
		
		System.out.println(name +"-"+email+"-"+comentario);
		
		if(name != "" && comentario != "") {
			
		} else {
			
		}
	}
}
