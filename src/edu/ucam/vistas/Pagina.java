package edu.ucam.vistas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.User;
import edu.ucam.clases.Enlace;

public class Pagina  {
	//private static final long serialVersionUID = 1L;
	private String titulo="";
	private String contenido="";
	private ArrayList<Enlace> menu=new ArrayList<>();
	
	
	
	
    public Pagina(String titulo, String contenido, ArrayList<Enlace> menu) {
		super();
		this.titulo = titulo;
		this.contenido = contenido;
		this.menu = menu;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public ArrayList<Enlace> getMenu() {
		return menu;
	}
	public void setMenu(ArrayList<Enlace> menu) {
		this.menu = menu;
	}
	public Pagina() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println("doPost");
		User u=new User(request.getParameter("user"), request.getParameter("password"));
		if(u.validUser()){
			System.out.println("Siiii");
			request.setAttribute("user",u);
			request.getRequestDispatcher("/jsp/bienvenida.jsp").forward(request, response);
		}else{
			System.out.println("No");
			request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
		}*/
	}
	public void crearPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=new User("vic","123456");
		request.setAttribute("user", u);
		request.setAttribute("pagina", this);
		request.getRequestDispatcher("/pagina.jsp").forward(request, response);
		
	}

	
}
