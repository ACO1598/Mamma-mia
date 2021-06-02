package es.loyola.iitv.pdm.classes;

import java.util.List;

public class CartaImpl implements Carta {

	private int id_restaurante;
	private List<Categoria> categorias;
	
	public CartaImpl(int id_restaurante, List<Categoria> categorias) {
		super();
		this.id_restaurante = id_restaurante;
		this.categorias = categorias;
	}

	public int getId_restaurante() {
		return id_restaurante;
	}

	public void setId_restaurante(int id_restaurante) {
		this.id_restaurante = id_restaurante;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorias == null) ? 0 : categorias.hashCode());
		result = prime * result + id_restaurante;
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
		CartaImpl other = (CartaImpl) obj;
		if (categorias == null) {
			if (other.categorias != null)
				return false;
		} else if (!categorias.equals(other.categorias))
			return false;
		if (id_restaurante != other.id_restaurante)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CartaImpl [id_restaurante=" + id_restaurante + ", categorias=" + categorias + "]";
	}
	
}
