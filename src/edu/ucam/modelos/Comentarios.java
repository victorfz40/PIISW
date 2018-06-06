package edu.ucam.modelos;
// Generated 26-abr-2018 17:38:56 by Hibernate Tools 5.1.0.Alpha1

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.text.StringEscapeUtils;

public class Comentarios implements java.io.Serializable {

	private static final long serialVersionUID = 3329904833786810127L;
	private Integer id;
	private Post post;
	private String email;
	private String nombre;
	private String comentario;
	private Date fecha;

	public Comentarios() {
	}

	public Comentarios(Post post, String email, String nombre, String comentario, Date fecha) {
		this.post = post;
		this.email = email;
		this.nombre = nombre;
		this.comentario = comentario;
		this.fecha = fecha;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Comentarios [id=" + id + ", post=" + post + ", email=" + email + ", nombre=" + nombre + ", comentario="
				+ comentario + ", fecha=" + fecha + "]";
	}
	
	public String toJson() {		
		return "{\"id\":\""+ id +"\", \"post\": \""+post.getId()+"\", \"email\": \""+email+"\", \"nombre\": \""+nombre+"\", \"comentario\": \""+StringEscapeUtils.escapeJava(comentario)+"\", \"fecha\": \""+(new SimpleDateFormat("dd-MM-yyyy").format(fecha))+"\"}";
	}

}
