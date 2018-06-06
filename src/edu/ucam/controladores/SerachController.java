package edu.ucam.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.query.Query;
import edu.ucam.modelos.HibernateUtils;
import edu.ucam.modelos.Post;


@WebServlet(urlPatterns = { "/buscar" })
public class SerachController extends MainController {
	private static final long serialVersionUID = 1933599531034509234L;
	//Comentario para ver problema con control de versiones
	
    public SerachController() {
        super();
    }
    //Problema clave privada/pblica
	@SuppressWarnings({ "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("recibido post en pagina de inicio");
		
		getBlocks(request, response, false);		
		request.setAttribute("titulo", prop.getProperty("empresa"));		
		try {			
			Query<Post> qp = session.createQuery("from Post");		
			List<Post> posts = qp.getResultList();		
			request.setAttribute("content", posts);		
			//System.out.println(posts.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());			
		} 
		
		request.getRequestDispatcher("/search.jsp").forward(request, response);
	}
}
