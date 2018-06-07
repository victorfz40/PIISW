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

import edu.ucam.modelos.Categorias;
import edu.ucam.modelos.Categorias;
import edu.ucam.modelos.Comentarios;
import edu.ucam.modelos.Post;
import javafx.geometry.Pos;

import java.text.ParseException;


@WebServlet(urlPatterns = { "/admin/categorias" })
public class AdminCategoriasController extends AdminController {
	//private static final long serialVersionUID = ;
	
    public AdminCategoriasController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Detalle de una categoria");
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
					List<Categorias> categorias = new ArrayList<Categorias>();
					categorias = service.search("Categorias", "1=1", 0, 500);
					request.setAttribute("categorias", categorias);
					request.getRequestDispatcher("/admin/categorias.jsp").forward(request, response);
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
	private void guardarEditado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			Categorias categorias=service.getRegistroById(Categorias.class,Integer.parseInt(request.getParameter("edit")) );
			categorias.setNombre(request.getParameter("nombre"));
			try {
				service.update(Categorias.class, categorias);
			}catch (Exception e) {
				System.out.println("Error al actualizar "+e.getMessage());
			}
			
			response.sendRedirect(request.getContextPath()+"/admin/categorias?edit="+request.getParameter("edit"));
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
			request.setAttribute("msg", "Error "+e.getMessage());
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void guardarNuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Categorias categorias=new Categorias();
			categorias.setNombre(request.getParameter("nombre"));
			
			try {
				service.create(Categorias.class, categorias);
			}catch (Exception e) {
				System.out.println("Error al actualizar "+e.getMessage());
			}
			response.sendRedirect(request.getContextPath()+"/admin/categorias");
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
			request.setAttribute("msg", "Error "+e.getMessage());
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	private void formularioNuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Categorias categorias=new Categorias();
			categorias.setNombre("");
			
			request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("/admin/categoriasedit.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
			request.setAttribute("msg", "Error "+e.getMessage());
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}
	@SuppressWarnings("unchecked")
	private void formularioEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Categorias categorias=(Categorias) (service.getRegistroById(Categorias.class,  Integer.parseInt(request.getParameter("edit"))));
			
			request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("/admin/categoriasedit.jsp").forward(request, response);
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
				service.delete(Categorias.class,Integer.parseInt(request.getParameter("del")));
				response.sendRedirect(request.getContextPath()+"/admin/categorias");
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
