package edu.ucam.vistas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import edu.ucam.clases.Enlace;
import edu.ucam.clases.Post;

public class PaginaContenido  {
	//private static final long serialVersionUID = 1L;
	private String titulo="";
	private ArrayList<Enlace> menu=new ArrayList<>();
	private Post contenido=new Post();
	private ArrayList<Enlace> menuLateral=new ArrayList<>();

	
	
	
	






	public PaginaContenido() {
		super();
	}

	public PaginaContenido(String titulo, ArrayList<Enlace> menu, Post contenido, ArrayList<Enlace> menuLateral) {
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
	public Post getContenido() {
		return contenido;
	}
	public void setContenido(Post contenido) {
		this.contenido = contenido;
	}
	public ArrayList<Enlace> getMenuLateral() {
		return menuLateral;
	}
	public void setMenuLateral(ArrayList<Enlace> menuLateral) {
		this.menuLateral = menuLateral;
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	public void crearPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pagina", this);
		request.getRequestDispatcher("/pagina_contenido.jsp").forward(request, response);
		
	}

	
}
