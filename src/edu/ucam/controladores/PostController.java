package edu.ucam.controladores;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.query.Query;

import edu.ucam.modelos.Comentarios;
import edu.ucam.modelos.Post;
import edu.ucam.servicios.AdminService;
import edu.ucam.servicios.AdminServiceImpl;


@WebServlet(urlPatterns = { "/post" })
public class PostController extends MainController {
	private static final long serialVersionUID = 963924354958882757L;
	
    public PostController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Detalle de un post");		
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
			AdminService service = new AdminServiceImpl();
			Post post = service.getRegistroById(Post.class, new Integer(id));
			Comentarios ocomentario = new Comentarios(post, email, name, comentario, new Date());
			service.create(Comentarios.class, ocomentario);
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
		request.getRequestDispatcher("/post.jsp").forward(request, response);
	}
}
