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


@WebServlet(urlPatterns = { "/inicio" })
public class IndexController extends MainController {
	private static final long serialVersionUID = 1933599531034509234L;
	
    public IndexController() {
        super();
    }

	@SuppressWarnings({ "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("recibido post en pagina de inicio");
		
		getBlocks(request, response, false);		
		request.setAttribute("titulo", prop.getProperty("empresa"));		
		try {			
			Query<Post> qp = session.createQuery("from Post");		
			List<Post> posts = qp.getResultList();		
			request.setAttribute("content", posts);						
		} catch (Exception e) {
			System.out.println(e.getMessage());			
		} 
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
