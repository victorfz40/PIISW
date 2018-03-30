package edu.ucam.clases;

public class Enlace {
	private String texto="";
	private String vinculo="#";
	public Enlace(String texto, String vinculo) {
		super();
		this.texto = texto;
		this.vinculo = vinculo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getVinculo() {
		return vinculo;
	}
	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		result = prime * result + ((vinculo == null) ? 0 : vinculo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enlace other = (Enlace) obj;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (vinculo == null) {
			if (other.vinculo != null)
				return false;
		} else if (!vinculo.equals(other.vinculo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Enlace [texto=" + texto + ", vinculo=" + vinculo + "]";
	}

}
