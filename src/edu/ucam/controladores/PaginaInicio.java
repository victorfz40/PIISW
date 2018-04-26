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
import edu.ucam.vistas.PaginaListado;


@WebServlet(urlPatterns = { "/inicio" })
public class PaginaInicio extends HttpServlet {

	private static Session session;
	
    public PaginaInicio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("recibido post en pagina de inicio");
		
		//Ejemplo Obtener datos de la BD con Hibernate
		session=HibernateUtils.getSessionFactory().openSession();
		Categorias c=new Categorias();
		c=session.byId(Categorias.class).load(8);//Cargamos un registro y lo impimimos
		System.out.println("Imprimimos una valor de la BD sacado con Hibernate " + c);
		
		
		PaginaListado p=new PaginaListado();
		p.setTitulo("Página de inicio Blog ");
		
		//
		ArrayList<Post> contenido=new ArrayList<>();
		Post post1=new Post();
		post1.setContenidoComienzo("<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc rutrum, enim eu elementum ornare, nulla odio vulputate magna, nec vehicula nisi tellus quis sapien. Etiam quis mattis diam, a accumsan quam. Morbi faucibus sem at cursus efficitur. Aenean quam ligula, ultricies sit amet odio non, ornare semper elit. Vestibulum porttitor feugiat magna, quis maximus mauris consequat tristique. Donec pellentesque porta egestas. Suspendisse condimentum ex quis lobortis porta.<p>");
		post1.setTitulo("Título blog uno");

		Post post2=new Post();
		post2.setContenidoComienzo("<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc rutrum, enim eu elementum ornare, nulla odio vulputate magna, nec vehicula nisi tellus quis sapien. Etiam quis mattis diam, a accumsan quam. Morbi faucibus sem at cursus efficitur. Aenean quam ligula, ultricies sit amet odio non, ornare semper elit. Vestibulum porttitor feugiat magna, quis maximus mauris consequat tristique. Donec pellentesque porta egestas. Suspendisse condimentum ex quis lobortis porta.<p>");
		post2.setTitulo("Título blog dos");		
		contenido.add(post1);
		contenido.add(post2);
		p.setContenido(contenido);


		
		ArrayList<Enlace> menu=new ArrayList<>();
		Enlace e1=new Enlace("texto1","#inicio");
		Enlace e2=new Enlace("texto2","#dos");
		menu.add(e1);
		menu.add(e2);
		p.setMenu(menu);
		
		ArrayList<Enlace> menuLateral=new ArrayList<>();
		Enlace e11=new Enlace("texto1Lateral","#inicio");
		Enlace e12=new Enlace("texto2Lateral","#dos");
		menuLateral.add(e11);
		menuLateral.add(e12);
		p.setMenuLateral(menuLateral);
		
		
		p.crearPagina(request, response);
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
