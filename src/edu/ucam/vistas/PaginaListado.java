package edu.ucam.vistas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import edu.ucam.clases.Enlace;
import edu.ucam.clases.Post;

public class PaginaListado  {
	//private static final long serialVersionUID = 1L;
	private String titulo="";
	private ArrayList<Enlace> menu=new ArrayList<>();
	private ArrayList<Post> contenido=new ArrayList<>();
	private ArrayList<Enlace> menuLateral=new ArrayList<>();

	
	
	
	
	
	public PaginaListado() {
		super();
	}



	public PaginaListado(String titulo, ArrayList<Enlace> menu, ArrayList<Post> contenido,
			ArrayList<Enlace> menuLateral) {
		super();
		this.titulo = titulo;
		this.menu = menu;
		this.contenido = contenido;
		this.menuLateral = menuLateral;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public ArrayList<Enlace> getMenu() {
		return menu;
	}

	public void setMenu(ArrayList<Enlace> menu) {
		this.menu = menu;
	}

	public ArrayList<Post> getContenido() {
		return contenido;
	}

	public void setContenido(ArrayList<Post> contenido) {
		this.contenido = contenido;
	}

	public ArrayList<Enlace> getMenuLateral() {
		return menuLateral;
	}

	public void setMenuLateral(ArrayList<Enlace> menuLateral) {
		this.menuLateral = menuLateral;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	public void crearPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("pagina", this);
		request.getRequestDispatcher("/pagina_listado.jsp").forward(request, response);
		
	}

	
}
