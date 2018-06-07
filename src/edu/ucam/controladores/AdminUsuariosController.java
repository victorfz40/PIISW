package edu.ucam.controladores;

import java.io.IOException;
import java.security.MessageDigest;
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


@WebServlet(urlPatterns = { "/admin/administradores" })
public class AdminUsuariosController extends AdminController {
	//private static final long serialVersionUID = ;
	
    public AdminUsuariosController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Detalle de un Administrador");
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
					List<Administradores> administradores = new ArrayList<Administradores>();
					administradores = service.search("Administradores", "1=1", 0, 500);
					request.setAttribute("administradores", administradores);
					request.getRequestDispatcher("/admin/administradores.jsp").forward(request, response);
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

			Administradores administradores=service.getRegistroById(Administradores.class,Integer.parseInt(request.getParameter("edit")) );
			administradores.setEmail(request.getParameter("email"));
			administradores.setUsuario(request.getParameter("usuario"));
			administradores.setPassword(md5(request.getParameter("password")));
			System.out.println(md5("123456"));
			try {
				service.update(Administradores.class, administradores);
			}catch (Exception e) {
				System.out.println("Error al actualizar "+e.getMessage());
			}
			
			response.sendRedirect(request.getContextPath()+"/admin/administradores?edit="+request.getParameter("edit"));
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
			request.setAttribute("msg", "Error "+e.getMessage());
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void guardarNuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Administradores administradores=new Administradores();
			administradores.setEmail(request.getParameter("email"));
			administradores.setUsuario(request.getParameter("usuario"));
			administradores.setPassword(md5(request.getParameter("password")));
			
			try {
				service.create(Administradores.class, administradores);
			}catch (Exception e) {
				System.out.println("Error al actualizar "+e.getMessage());
			}
			response.sendRedirect(request.getContextPath()+"/admin/administradores");
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
			request.setAttribute("msg", "Error "+e.getMessage());
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	private void formularioNuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Administradores administradores=new Administradores();
			administradores.setEmail("");
			administradores.setPassword("");
			administradores.setUsuario("");
			
			request.setAttribute("administradores", administradores);
			request.getRequestDispatcher("/admin/administradoresedit.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
			request.setAttribute("msg", "Error "+e.getMessage());
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}
	@SuppressWarnings("unchecked")
	private void formularioEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Administradores administradores=(Administradores) (service.getRegistroById(Administradores.class,  Integer.parseInt(request.getParameter("edit"))));
			
			request.setAttribute("administradores", administradores);
			request.getRequestDispatcher("/admin/administradoresedit.jsp").forward(request, response);
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
				service.delete(Administradores.class,Integer.parseInt(request.getParameter("del")));
				response.sendRedirect(request.getContextPath()+"/admin/administradores");
			}catch(Exception e){
				System.out.println("No se ha borrado el registro "+e.getMessage());
			}
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
			request.setAttribute("msg", "Error "+e.getMessage());
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}
	
    public String  md5(String password)throws Exception
    {
    	//String password = "123456";
    	
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	return hexString.toString();
    }
	
}
