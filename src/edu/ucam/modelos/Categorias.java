package edu.ucam.modelos;
// Generated 04-abr-2018 17:06:38 by Hibernate Tools 5.2.8.Final

/**
 * Categorias generated by hbm2java
 */
public class Categorias implements java.io.Serializable {

	private Integer id;
	private String nombre;

	public Categorias() {
	}

	public Categorias(String nombre) {
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "Categorias [id=" + id + ", nombre=" + nombre + "]";
	}

	
}
