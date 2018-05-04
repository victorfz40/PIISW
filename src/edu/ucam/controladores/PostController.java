package edu.ucam.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.query.Query;

import edu.ucam.modelos.HibernateUtils;
import edu.ucam.modelos.Post;


@WebServlet(urlPatterns = { "/post" })
public class PostController extends MainController {
	private static final long serialVersionUID = 963924354958882757L;
	
    public PostController() {
        super();
    }

	@SuppressWarnings({ "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Detalle de un post");
		String id = request.getParameter("id");
		
		getBlocks(request, response);
		try {			
			Query<Post> qp = session.createQuery("from Post where id="+id);		
			Post post = qp.getSingleResult();		
			request.setAttribute("content", post);				
			request.setAttribute("titulo", post.getTitulo() + " - " + prop.getProperty("empresa"));		
		} catch (Exception e) {
			System.out.println(e.getMessage());			
		} 
		//session.close();
		request.getRequestDispatcher("/post.jsp").forward(request, response);
	}
}
