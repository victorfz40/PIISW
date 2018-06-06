package edu.ucam.modelos;
// Generated 26-abr-2018 17:38:56 by Hibernate Tools 5.1.0.Alpha1

import java.util.HashSet;
import java.util.Set;

public class Administradores implements java.io.Serializable {

	private static final long serialVersionUID = -7910670502519109079L;
	private Integer id;
	private String usuario;
	private String password;
	private String email;
	private Set<Post> posts = new HashSet<Post>(0);

	public Administradores() {
	}

	public Administradores(String usuario, String password, String email) {
		this.usuario = usuario;
		this.password = password;
		this.email = email;
	}

	public Administradores(String usuario, String password, String email, Set<Post> posts) {
		this.usuario = usuario;
		this.password = password;
		this.email = email;
		this.posts = posts;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Administradores [id=" + id + ", usuario=" + usuario + ", password=" + password + ", email=" + email
				+ ", posts=" + posts + "]";
	}
	
	public String toJson() {
		return "{\"id\": \""+ id +"\", \"usuario\": \""+usuario+"\", \"email\": \""+email+"\"}";
	}

}
