package edu.ucam.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.modelos.Administradores;
import edu.ucam.modelos.Comentarios;
import edu.ucam.modelos.Post;


@WebServlet(urlPatterns = { "/admin/index" })
public class AdminIndexController extends AdminController {
	private static final long serialVersionUID = 963924354958882227L;
	
    public AdminIndexController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Admin index");
		
		if(getBlocks(request, response, true)) {
			List<Post> posts = new ArrayList<Post>();
			List<Comentarios> comentarios = new ArrayList<Comentarios>();		
			List<Administradores> administradores = new ArrayList<Administradores>();	
			posts = service.search("Post", "1=1", 0, 50);
			comentarios = service.search("Comentarios", "1=1",0,50);
			administradores = service.search("Administradores", "1=1",0,50);
			
			request.setAttribute("entradas", service.toJson(posts));
			request.setAttribute("comentarios", service.toJson(comentarios));	
			//System.out.println("\n\n----"+(String)request.getAttribute("entradas")+"---\n\n");
			
			request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
		}
	}
}
