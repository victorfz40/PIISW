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


@WebServlet(urlPatterns = { "/admin/comentarios" })
public class AdminComentariosController extends AdminController {
	private static final long serialVersionUID = 963924354958882227L;
	
    public AdminComentariosController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Detalle de un comentario");
		if(getBlocks(request, response, true)) {
			try {
				if(request.getParameter("edit") != null) {
					/*if (request.getParameter("edit") .equals("new")) {//Mostrar formulario para nuevo
						formularioNuevo(request, response);
					}else*/ if(request.getParameter("edit") != null) {//Mostrar formulario para editar
						formularioEditar(request, response);
					}
				}else if(request.getParameter("del") != null) {//Elimina un registro
					borrar(request,response);
				}else {//Muestra el listado
					List<Comentarios> comentarios = new ArrayList<Comentarios>();
					comentarios = service.search("Comentarios", "1=1", 0, 500);
					request.setAttribute("comentarios", comentarios);
					request.getRequestDispatcher("/admin/comentarios.jsp").forward(request, response);
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
				/*if(request.getParameter("edit").equals("new")) {
					guardarNuevo(request,response);
				}else*/ if(request.getParameter("edit")!=null){
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
	private void guardarEditado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//Actualiza los datos de comentarios
		try {

			Comentarios com=service.getRegistroById(Comentarios.class,Integer.parseInt(request.getParameter("edit")) );
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date fecha=new Date();
			try {
				fecha = formatter.parse(request.getParameter("fecha"));
			} catch (ParseException e) {
				System.out.println("Error convirtiendo fechas "+e.getMessage());
			}
			com.setFecha(fecha);
			/*Post p=service.getRegistroById(Post.class, Integer.parseInt(request.getParameter("idpost")));
			com.setPost(p); */
			com.setComentario(request.getParameter("comentario"));
			com.setEmail(request.getParameter("email"));
			com.setNombre(request.getParameter("nombre"));
			
			try {
				service.update(Comentarios.class, com);
			}catch (Exception e) {
				System.out.println("Error al actualizar "+e.getMessage());
			}
			
			response.sendRedirect(request.getContextPath()+"/admin/comentarios?edit="+request.getParameter("edit"));
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
			request.setAttribute("msg", "Error "+e.getMessage());
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}
	
	/*@SuppressWarnings("unchecked")
	private void guardarNuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Comentarios com=new Comentarios();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date fecha=new Date();
			try {
				fecha = formatter.parse(request.getParameter("fecha"));
			} catch (ParseException e) {
				System.out.println("Error convirtiendo fechas "+e.getMessage());
			}
			com.setFecha(fecha);
			Post p=service.getRegistroById(Post.class, Integer.parseInt(request.getParameter("idpost")));
			com.setPost(p); 
			com.setComentario(request.getParameter("comentario"));
			com.setEmail(request.getParameter("email"));
			com.setNombre(request.getParameter("nombre"));
			
			try {
				service.update(Comentarios.class, com);
			}catch (Exception e) {
				System.out.println("Error al actualizar "+e.getMessage());
			}
			
			response.sendRedirect(request.getContextPath()+"/admin/comentarios");
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
			request.setAttribute("msg", "Error "+e.getMessage());
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}*/
	
	/*@SuppressWarnings("unchecked")
	private void guardarNuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}*/
	
	/*@SuppressWarnings("unchecked")
	private void formularioNuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Comentarios comentarios=new Comentarios();
			comentarios.setComentario("");
			comentarios.setEmail("");
			comentarios.setNombre("");
			comentarios.setFecha(new Date());

			request.setAttribute("comentarios", comentarios);
			request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("/admin/comentariosedit.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
			request.setAttribute("msg", "Error "+e.getMessage());
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}*/
	@SuppressWarnings("unchecked")
	private void formularioEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Comentarios comentarios=(Comentarios) (service.getRegistroById(Comentarios.class,  Integer.parseInt(request.getParameter("edit"))));


			
			request.setAttribute("comentarios", comentarios);
			//request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("/admin/comentariosedit.jsp").forward(request, response);
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
				service.delete(Comentarios.class,Integer.parseInt(request.getParameter("del")));
				response.sendRedirect(request.getContextPath()+"/admin/comentarios");
			}catch(Exception e){
				System.out.println("No se ha borrado el registro "+e.getMessage());
			}
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
			request.setAttribute("msg", "Error "+e.getMessage());
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}
	
}
