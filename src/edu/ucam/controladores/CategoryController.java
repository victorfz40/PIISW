package edu.ucam.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.query.Query;

import edu.ucam.modelos.Categorias;
import edu.ucam.modelos.Post;

@WebServlet(urlPatterns = { "/listadoCategoria" })
public class CategoryController extends MainController {
	private static final long serialVersionUID = 96392411158882757L;
	
    public CategoryController() {
        super();
    }

	@SuppressWarnings({ "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Detalle de un post");
		String id = request.getParameter("id");
		
		getBlocks(request, response, false);			
		try {		
			Query<Post> qp = session.createQuery("from Post where idCategoria="+id);
			List<Post> posts = qp.getResultList();
			request.setAttribute("content", posts);
			Query<Categorias> qc = session.createQuery("from Categorias where id="+id);
			Categorias cat = qc.getSingleResult();
			request.setAttribute("titulo", "Listado entradas de " + cat.getNombre());
		} catch (Exception e) {
			System.out.println(e.getMessage());			
		} 
		//session.close();
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
