package edu.ucam.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import edu.ucam.modelos.Comentarios;
import edu.ucam.modelos.Post;


@WebServlet(urlPatterns = { "/admin/post" })
public class AdminPostController extends AdminController {
	private static final long serialVersionUID = 963924354958882227L;
	
    public AdminPostController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Detalle de un post");
		
		String search = (String) request.getAttribute("search");
		List<Post> posts = new ArrayList<Post>();
		if(search == null) {
			posts = service.getListado("Post");
		} else {
			posts = service.search("Post", "titulo like '%"+search+"%'");
		}
		request.setAttribute("entradas", posts);
		loadPage(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		HttpSession sesionHttp = request.getSession();
		String name = request.getParameter("nombre");
		String email = request.getParameter("email");
		String comentario= request.getParameter("comentario");
		String id= request.getParameter("id");
		
		System.out.println(name +"-"+email+"-"+comentario);
		
		if(name != "" && comentario != "" && id != "") {
			Transaction tx = session.beginTransaction();
			try {
				Post post = session.get(Post.class, new Integer(id));
				Comentarios ocomentario = new Comentarios(post, email, name, comentario, new Date());
				session.save(ocomentario);
				tx.commit();
				sesionHttp.setAttribute("msg", "Comentario guardado con éxito");
			} catch (Exception e) {
				System.out.println(e);			
				if (tx!=null) tx.rollback();
				sesionHttp.setAttribute("msg", "Hubo un problema al guardar el comentario.");	
			}
		} else {
			sesionHttp.setAttribute("msg", "Faltan campos obligatorios para poder guardar el comentario.");
		}
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
		request.getRequestDispatcher("/admin/post.jsp").forward(request, response);
	}
}
