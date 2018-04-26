package edu.ucam.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.ucam.clases.Enlace;
import edu.ucam.clases.Post;
import edu.ucam.modelos.Categorias;
import edu.ucam.modelos.HibernateUtils;
import edu.ucam.vistas.PaginaContenido;
import edu.ucam.vistas.PaginaListado;


@WebServlet(urlPatterns = { "/post" })
public class PaginasContenido extends HttpServlet {

	private static Session session;
	
    public PaginasContenido() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("recibido post en pagina de inicio");
		
		//Ejemplo Obtener datos de la BD con Hibernate
		session=HibernateUtils.getSessionFactory().openSession();
		Categorias c=new Categorias();
		c=session.byId(Categorias.class).load(8);
		System.out.println("Imprimimos una valor de la BD sacado con Hibernate " + c);
		
		
		PaginaContenido p=new PaginaContenido();
		p.setTitulo("Página de inicio Blog ");
		
		//<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc rutrum, enim eu elementum ornare, nulla odio vulputate magna, nec vehicula nisi tellus quis sapien. Etiam quis mattis diam, a accumsan quam. Morbi faucibus sem at cursus efficitur. Aenean quam ligula, ultricies sit amet odio non, ornare semper elit. Vestibulum porttitor feugiat magna, quis maximus mauris consequat tristique. Donec pellentesque porta egestas. Suspendisse condimentum ex quis lobortis porta.<p>
		//ArrayList<Post> contenido=new ArrayList<>();
		Post post1=new Post();
		//post1.setContenidoComienzo("<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc rutrum, enim eu elementum ornare, nulla odio vulputate magna, nec vehicula nisi tellus quis sapien. Etiam quis mattis diam, a accumsan quam. Morbi faucibus sem at cursus efficitur. Aenean quam ligula, ultricies sit amet odio non, ornare semper elit. Vestibulum porttitor feugiat magna, quis maximus mauris consequat tristique. Donec pellentesque porta egestas. Suspendisse condimentum ex quis lobortis porta.<p>");
		post1.setContenido("<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc rutrum, enim eu elementum ornare, nulla odio vulputate magna, nec vehicula nisi tellus quis sapien. Etiam quis mattis diam, a accumsan quam. Morbi faucibus sem at cursus efficitur. Aenean quam ligula, ultricies sit amet odio non, ornare semper elit. Vestibulum porttitor feugiat magna, quis maximus mauris consequat tristique. Donec pellentesque porta egestas. Suspendisse condimentum ex quis lobortis porta.<p><p>Contenido completo</p>");
		post1.setTitulo("Título blog uno");
		p.setContenido(post1);


		ArrayList<Enlace> menuLateral=new ArrayList<>();
		Enlace e11=new Enlace("texto1Lateral","#inicio");
		Enlace e12=new Enlace("texto2Lateral","#dos");
		menuLateral.add(e11);
		menuLateral.add(e12);
		p.setMenuLateral(menuLateral);
		
		
		ArrayList<Enlace> menu=new ArrayList<>();
		Enlace e1=new Enlace("texto1","inicio");
		Enlace e2=new Enlace("texto2","dos");
		menu.add(e1);
		menu.add(e2);
		p.setMenu(menu);
		
		p.crearPagina(request, response);
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
