package es.loyola.iitv.pdm.classes;

import java.util.List;

public class CategoriaImpl implements Categoria {

	private String nombre;
	private List<Producto> listProductos;
	
	public CategoriaImpl(String nombre, List<Producto> listProductos) {
		super();
		this.nombre = nombre;
		this.listProductos = listProductos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Producto> getListProductos() {
		return listProductos;
	}

	public void setListProductos(List<Producto> listProductos) {
		this.listProductos = listProductos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listProductos == null) ? 0 : listProductos.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		CategoriaImpl other = (CategoriaImpl) obj;
		if (listProductos == null) {
			if (other.listProductos != null)
				return false;
		} else if (!listProductos.equals(other.listProductos))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoriaImpl [nombre=" + nombre + ", listProductos=" + listProductos + "]";
	}
	
}
