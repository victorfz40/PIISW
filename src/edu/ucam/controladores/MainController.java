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

import org.hibernate.Session;
import org.hibernate.query.Query;

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
	protected void getBlocks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "Inicio");		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			
			Query<Categorias> qc = session.createQuery("from Categorias");		
			List<Categorias> cats = qc.getResultList();
			request.setAttribute("categorias", cats);
									
			ArrayList<Enlace> menu=new ArrayList<>();
			menu.add(new Enlace(prop.getProperty("menu.opt1.text"),prop.getProperty("menu.opt1.href")));
			menu.add(new Enlace(prop.getProperty("menu.opt2.text"),prop.getProperty("menu.opt2.href")));
			request.setAttribute("menu", menu);
		} catch (Exception e) {
			System.out.println(e.getMessage());			
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }

}
