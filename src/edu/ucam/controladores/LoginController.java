package edu.ucam.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ucam.modelos.Administradores;
import edu.ucam.servicios.AdminService;
import edu.ucam.servicios.AdminServiceImpl;


@WebServlet(urlPatterns = { "/login" })
public class LoginController extends MainController {
	private static final long serialVersionUID = 1933599531034509234L;
	
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login de usuario");		
		getBlocks(request, response, false);		
		request.setAttribute("titulo", prop.getProperty("Autenticación de usuarios"));		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String passwd = request.getParameter("password");
		
		System.out.println("Comprobando de usuario " + user + ":" + passwd);
		AdminService service = new AdminServiceImpl();
		List<Administradores> admin = service.search("Administradores", "usuario like '"+user+"' and password like MD5('"+passwd+"')");
		HttpSession sesion = request.getSession();
		
		if(admin.size() > 0) {
			System.out.println("Concedido...");			
			sesion.setAttribute("user", admin.get(0));
			getBlocks(request, response, true);
			response.sendRedirect(request.getContextPath() +"/admin/index");
		} else {
			sesion.setAttribute("msg", "USuario o contraña incorrecto.");
			response.sendRedirect(request.getContextPath() +"/login");
		}
	}	
}
