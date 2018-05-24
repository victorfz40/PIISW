package edu.ucam.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.query.Query;

import com.google.gson.Gson;

import edu.ucam.modelos.Comentarios;
import edu.ucam.modelos.Post;


@WebServlet(urlPatterns = { "/admin_index" })
public class AdminIndexController extends AdminController {
	private static final long serialVersionUID = 963924354958882227L;
	
    public AdminIndexController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Admin index");
		
		List<Post> posts = new ArrayList<Post>();
		List<Comentarios> comentarios = new ArrayList<Comentarios>();		
		posts = service.search("Post", "1=1 limit 0,5");
		comentarios = service.search("Comentarios", "1=1 limit 0,5");
		request.setAttribute("entradas", new Gson().toJson(posts));
		request.setAttribute("comentarios", new Gson().toJson(comentarios));
		loadPage(request, response);
	}
	
	@SuppressWarnings("unchecked")
	private void loadPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		getBlocks(request, response, false);
		try {			
			Query<Post> qp = session.createQuery("from Post where id="+id);		
			Post post = qp.getSingleResult();		
			request.setAttribute("content", post);				
			request.setAttribute("titulo", post.getTitulo() + " - " + prop.getProperty("empresa"));		
		} catch (Exception e) {
			System.out.println(e.getMessage());			
		} 
		request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
	}
}
