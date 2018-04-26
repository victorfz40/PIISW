package edu.ucam.modelos;
// Generated 26-abr-2018 17:38:56 by Hibernate Tools 5.1.0.Alpha1

import java.util.HashSet;
import java.util.Set;

/**
 * Categorias generated by hbm2java
 */
public class Categorias implements java.io.Serializable {

	private Integer id;
	private String nombre;
	private Set posts = new HashSet(0);

	public Categorias() {
	}

	public Categorias(String nombre) {
		this.nombre = nombre;
	}

	public Categorias(String nombre, Set posts) {
		this.nombre = nombre;
		this.posts = posts;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set getPosts() {
		return this.posts;
	}

	public void setPosts(Set posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Categorias [id=" + id + ", nombre=" + nombre + ", posts=" + posts + "]";
	}

}
