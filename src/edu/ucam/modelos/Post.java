package edu.ucam.modelos;
// Generated 26-abr-2018 17:38:56 by Hibernate Tools 5.1.0.Alpha1

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.text.StringEscapeUtils;

/**
 * Post generated by hbm2java
 */
public class Post implements java.io.Serializable {

	private static final long serialVersionUID = -6515519157589000543L;
	private Integer id;
	private Administradores administradores;
	private Categorias categorias;
	private String titulo;
	private String html;
	private String htmlCorto;
	private Date fecha;
	private Set<Comentarios> comentarioses = new HashSet<Comentarios>(0);

	public Post() {
	}

	public Post(Administradores administradores, Categorias categorias, String titulo, String html, String htmlCorto,
			Date fecha) {
		this.administradores = administradores;
		this.categorias = categorias;
		this.titulo = titulo;
		this.html = html;
		this.htmlCorto = htmlCorto;
		this.fecha = fecha;
	}

	public Post(Administradores administradores, Categorias categorias, String titulo, String html, String htmlCorto,
			Date fecha, Set<Comentarios> comentarioses) {
		this.administradores = administradores;
		this.categorias = categorias;
		this.titulo = titulo;
		this.html = html;
		this.htmlCorto = htmlCorto;
		this.fecha = fecha;
		this.comentarioses = comentarioses;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Administradores getAdministradores() {
		return this.administradores;
	}

	public void setAdministradores(Administradores administradores) {
		this.administradores = administradores;
	}

	public Categorias getCategorias() {
		return this.categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getHtml() {
		return this.html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getHtmlCorto() {
		return this.htmlCorto;
	}

	public void setHtmlCorto(String htmlCorto) {
		this.htmlCorto = htmlCorto;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Set<Comentarios> getComentarioses() {
		return this.comentarioses;
	}

	public void setComentarioses(Set<Comentarios> comentarioses) {
		this.comentarioses = comentarioses;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", administradores=" + administradores + ", categorias=" + categorias + ", titulo="
				+ titulo + ", html=" + html + ", htmlCorto=" + htmlCorto + ", fecha=" + fecha + ", comentarioses="
				+ comentarioses + "]";
	}
	
	public String toJson() {
		System.out.println("#"+StringEscapeUtils.escapeJava(html)+"##"+StringEscapeUtils.escapeJson(html)+"#");
		return "{\"id\":\""+ id +"\", \"administradores\": "+administradores.toJson()+", \"categorias\": "+categorias.toJson()+", \"titulo\": \""+titulo+"\", \"html\": \""+StringEscapeUtils.escapeJava(html)+"\", \"htmlCorto\": \""+StringEscapeUtils.escapeJava(htmlCorto)+"\",\"fecha\": \""+(new SimpleDateFormat("dd-MM-yyyy").format(fecha))+"\"}";
	}
}
