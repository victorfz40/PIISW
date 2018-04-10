package edu.ucam.clases;

public class Post {
	private int id;
	private String contenido="";
	private String contenidoComienzo="";
	private String titulo="";
	public Post(int id, String contenido, String contenidoComienzo, String titulo) {
		super();
		this.id = id;
		this.contenido = contenido;
		this.contenidoComienzo = contenidoComienzo;
		this.titulo = titulo;
	}
	public Post() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getContenidoComienzo() {
		return contenidoComienzo;
	}
	public void setContenidoComienzo(String contenidoComienzo) {
		this.contenidoComienzo = contenidoComienzo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	
	

}
