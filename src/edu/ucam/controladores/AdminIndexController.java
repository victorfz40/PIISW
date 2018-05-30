package edu.ucam.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		List<Post> posts = new ArrayList<Post>();
		List<Comentarios> comentarios = new ArrayList<Comentarios>();		
		posts = service.search("Post", "1=1", 0, 5);
		comentarios = service.search("Comentarios", "1=1",0,5);		
		request.setAttribute("entradas", posts);
		request.setAttribute("comentarios",comentarios);
		getBlocks(request, response, true);
		request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
	}
}
