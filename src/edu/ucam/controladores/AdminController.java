package edu.ucam.controladores;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.google.gson.Gson;

import edu.ucam.clases.Enlace;
import edu.ucam.servicios.AdminService;
import edu.ucam.servicios.AdminServiceImpl;

public abstract class AdminController  extends HttpServlet {
	protected static Session session;	
	private static final long serialVersionUID = 1L;
	protected static Properties prop;
	protected static AdminService service;
	
	
	public AdminController() {
		if(prop == null) {
			prop = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();           
			InputStream stream = loader.getResourceAsStream("/main.properties");
			try {
				prop.load(stream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(service == null) {
			service = new AdminServiceImpl();
		}
	}

	@SuppressWarnings({ "unchecked" })
	protected void getBlocks(HttpServletRequest request, HttpServletResponse response, Boolean isPrivate) throws ServletException, IOException {
		request.setAttribute("title", "Inicio");		
		try {			
			HttpSession sesionUsuario = request.getSession();			
			request.setAttribute("empresa", prop.getProperty("empresa"));			
			String smenu = "";

			if(isPrivate) {
				if(sesionUsuario.getAttribute("user") == null) {
					request.getRequestDispatcher("login").forward(request, response);
				}
				smenu = prop.getProperty("menu.private");
				Enlace[] enlaces = new Gson().fromJson(prop.getProperty("admin.links"), Enlace[].class);
				request.setAttribute("enlaces", enlaces);
			} else {
				smenu = prop.getProperty("menu.public");				
			}
			Enlace[] menus = new Gson().fromJson(smenu, Enlace[].class);			
			request.setAttribute("menu", menus);
		} catch (Exception e) {
			System.out.println(e.getMessage());			
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }

}
