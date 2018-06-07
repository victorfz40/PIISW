package edu.ucam.controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.modelos.Administradores;
import edu.ucam.modelos.Comentarios;
import edu.ucam.modelos.Post;


@WebServlet(urlPatterns = { "/admin/indexAjax" })
public class ____________AdminIndexAjaxController extends AdminController {
	private static final long serialVersionUID = 963924354958882227L;
	
    public ____________AdminIndexAjaxController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Admin index Ajax");
		
		//if(getBlocks(request, response, true)) {
		
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();

		
		List<Post> posts = new ArrayList<Post>();
		List<Comentarios> comentarios = new ArrayList<Comentarios>();		
		//List<Administradores> administradores = new ArrayList<Administradores>();	
		
		posts = service.search("Post", "1=1", 0, 50);

		comentarios = service.search("Comentarios", "1=1",0,50);
		//administradores = service.search("Administradores", "1=1",0,50);
		
		/*String action=request.getParameter("action");
		String html="";
		switch (action) {
		case "Post": 
			for( Post p: posts) {
				html+="<a href=\"\">Eliminar</a>&nbsp;&nbsp;<a href=\"\">Editar</a>&nbsp;&nbsp;<a href=\""+p.getId()+"\">"+p.getTitulo()+"</a>";
			}
			break;
			
		}
		
		
		out.println(arg0);*/
		
		request.setAttribute("entradas", service.toJson(posts));
		request.setAttribute("comentarios", service.toJson(comentarios));	
		//System.out.println("\n\n----"+(String)request.getAttribute("entradas")+"---\n\n");
		
		request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
		//}
	}
}
