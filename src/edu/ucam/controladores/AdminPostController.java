package edu.ucam.controladores;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import edu.ucam.modelos.Administradores;
import edu.ucam.modelos.Categorias;
import edu.ucam.modelos.Comentarios;
import edu.ucam.modelos.Post;
import javafx.geometry.Pos;

import java.text.ParseException;


@WebServlet(urlPatterns = { "/admin/post" })
public class AdminPostController extends AdminController {
	private static final long serialVersionUID = 963924354958882227L;
	
    public AdminPostController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Detalle de un post");
		if(getBlocks(request, response, true)) {
			try {
				if(request.getParameter("edit") != null) {
					if (request.getParameter("edit") .equals("new")) {//Mostrar formulario para nuevo
						formularioNuevo(request, response);
					}else if(request.getParameter("edit") != null) {//Mostrar formulario para editar
						formularioEditar(request, response);
					}
				}else if(request.getParameter("del") != null) {//Elimina un registro
					borrar(request,response);
				}else {//Muestra el listado
					List<Post> posts = new ArrayList<Post>();
					posts = service.search("Post", "1=1", 0, 500);
					request.setAttribute("posts", posts);
					request.getRequestDispatcher("/admin/post.jsp").forward(request, response);
				}
			}catch(Exception e) {
				System.out.println("Error "+e.getMessage());
				request.setAttribute("msg", "Error "+e.getMessage());
				request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(getBlocks(request, response, true)) {
			HttpSession sesionHttp = request.getSession();
			try {
			
			 if(request.getParameter("edit")!=null){
				if(request.getParameter("edit").equals("new")) {
					guardarNuevo(request,response);
				}else if(request.getParameter("edit")!=null){
					guardarEditado(request, response);
				}
			 }
			}catch(Exception e) {
				System.out.println("Error "+e.getMessage());
				request.setAttribute("msg", "Error "+e.getMessage());
				request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void guardarEditado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//Actualiza los datos de post
		try {

			Post p=service.getRegistroById(Post.class,Integer.parseInt(request.getParameter("edit")) );
			Administradores a=(Administradores)service.getRegistroById(Administradores.class, Integer.parseInt(request.getParameter("idAdministrador")));
			p.setAdministradores(a);
			Categorias c=new Categorias(); 
			c=service.getRegistroById(Categorias.class, Integer.parseInt(request.getParameter("idCategoria")));
			p.setCategorias(c);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date fecha=new Date();
			try {
				fecha = formatter.parse(request.getParameter("fecha"));
			} catch (ParseException e) {
				System.out.println("Error convirtiendo fechas "+e.getMessage());
			}
			p.setFecha(fecha);
			p.setHtmlCorto(request.getParameter("htmlCorto"));
			p.setHtml(request.getParameter("html"));
			p.setTitulo(request.getParameter("titulo"));
			
			try {
				service.update(Post.class, p);
			}catch (Exception e) {
				System.out.println("Error al actualizar "+e.getMessage());
			}
			
			response.sendRedirect(request.getContextPath()+"/admin/post?edit="+request.getParameter("edit"));
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
			request.setAttribute("msg", "Error "+e.getMessage());
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void guardarNuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Post p=new Post();
			Administradores a=(Administradores)service.getRegistroById(Administradores.class, Integer.parseInt(request.getParameter("idAdministrador")));
			p.setAdministradores(a);
			Categorias c=new Categorias(); 
			c=service.getRegistroById(Categorias.class, Integer.parseInt(request.getParameter("idCategoria")));
			p.setCategorias(c);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date fecha=new Date();
			try {
				fecha = formatter.parse(request.getParameter("fecha"));
			} catch (ParseException e) {
				System.out.println("Error convirtiendo fechas "+e.getMessage());
			}
			p.setFecha(fecha);
			p.setHtmlCorto(request.getParameter("htmlCorto"));
			p.setHtml(request.getParameter("html"));
			p.setTitulo(request.getParameter("titulo"));
			
			try {
				service.create(Post.class, p);
			}catch (Exception e) {
				System.out.println("Error al actualizar "+e.getMessage());
			}
			response.sendRedirect(request.getContextPath()+"/admin/post");
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
			request.setAttribute("msg", "Error "+e.getMessage());
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}
	
	/*@SuppressWarnings("unchecked")
	private void guardarNuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}*/
	
	@SuppressWarnings("unchecked")
	private void formularioNuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Post post=new Post();
			post.setTitulo("");
			post.setHtml("");
			post.setHtmlCorto("");
	
			post.setFecha(new Date());
			
			System.out.println(post);
			List<Categorias> categorias = new ArrayList<Categorias>();
			categorias = service.search("Categorias", "1=1", 0, 500);
			List<Administradores> administradores = new ArrayList<Administradores>();
			administradores = service.search("Administradores", "1=1", 0, 500);
			
			
			request.setAttribute("post", post);
			request.setAttribute("categorias", categorias);
			request.setAttribute("administradores", administradores);
			request.getRequestDispatcher("/admin/postedit.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
			request.setAttribute("msg", "Error "+e.getMessage());
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}
	@SuppressWarnings("unchecked")
	private void formularioEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Post post=(Post) (service.getRegistroById(Post.class,  Integer.parseInt(request.getParameter("edit"))));
			List<Categorias> categorias = new ArrayList<Categorias>();
			categorias = service.search("Categorias", "1=1", 0, 500);
			List<Administradores> administradores = new ArrayList<Administradores>();
			administradores = service.search("Administradores", "1=1", 0, 500);
			
			request.setAttribute("post", post);
			request.setAttribute("categorias", categorias);
			request.setAttribute("administradores", administradores);
			request.getRequestDispatcher("/admin/postedit.jsp").forward(request, response);
	}catch(Exception e) {
		System.out.println("Error "+e.getMessage());
		request.setAttribute("msg", "Error "+e.getMessage());
		request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
	}
	}
	
	@SuppressWarnings("unchecked")
	private void borrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			System.out.println("Borrando el registro con id="+request.getParameter("del"));
			try{
				service.delete(Post.class,Integer.parseInt(request.getParameter("del")));
				response.sendRedirect(request.getContextPath()+"/admin/post");
			}catch(Exception e){
				System.out.println("No se ha borrado el registro "+e.getMessage());
			}
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
			request.setAttribute("msg", "Error "+e.getMessage());
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}
	
	/*@SuppressWarnings("unchecked")
	private void loadPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("Id="+id);
		id="2";
		
		try {			
			Query<Post> qp = session.createQuery("from Post where id="+id);		
			Post post = qp.getSingleResult();		
			request.setAttribute("content", post);				
			request.setAttribute("titulo", post.getTitulo() + " - " + prop.getProperty("empresa"));		
		} catch (Exception e) {

			System.out.println(e.getMessage());			
		} 
		request.getRequestDispatcher("/admin/post.jsp").forward(request, response);
	}*/
}
