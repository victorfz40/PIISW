package edu.ucam.controladores;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.google.gson.Gson;

import edu.ucam.clases.Enlace;
import edu.ucam.modelos.Categorias;
import edu.ucam.modelos.HibernateUtils;

public abstract class MainController  extends HttpServlet {
	protected static Session session;	
	private static final long serialVersionUID = 1L;
	protected static Properties prop;
	
	public MainController() {
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
	}

	@SuppressWarnings({ "unchecked" })
	protected void getBlocks(HttpServletRequest request, HttpServletResponse response, Boolean isPrivate) throws ServletException, IOException {
		request.setAttribute("title", "Inicio");		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			HttpSession sesionUsuario = request.getSession();
			
			Query<Categorias> qc = session.createQuery("from Categorias");		
			List<Categorias> cats = qc.getResultList();
			request.setAttribute("categorias", cats);
			request.setAttribute("empresa", prop.getProperty("empresa"));
			
			String smenu = "";
			if(isPrivate && sesionUsuario.getAttribute("idUsuario") == null) {
				request.getRequestDispatcher("login").forward(request, response);
			}
			if(isPrivate) {
				smenu = prop.getProperty("menu.private");
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
