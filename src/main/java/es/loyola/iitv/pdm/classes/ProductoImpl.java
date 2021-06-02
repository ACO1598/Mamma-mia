package es.loyola.iitv.pdm.classes;

import java.util.List;

public class ProductoImpl implements Producto {

	private String name;
	private int precio;
	private List<Ingredientes> listIngredientes;
	private List<Alergenos> listAlergenos;
	
	public ProductoImpl(String name, int precio, List<Ingredientes> listIngredientes, List<Alergenos> listAlergenos) {
		super();
		this.name = name;
		this.precio = precio;
		this.listIngredientes = listIngredientes;
		this.listAlergenos = listAlergenos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public List<Ingredientes> getListIngredientes() {
		return listIngredientes;
	}

	public void setListIngredientes(List<Ingredientes> listIngredientes) {
		this.listIngredientes = listIngredientes;
	}

	public List<Alergenos> getListAlergenos() {
		return listAlergenos;
	}

	public void setListAlergenos(List<Alergenos> listAlergenos) {
		this.listAlergenos = listAlergenos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listAlergenos == null) ? 0 : listAlergenos.hashCode());
		result = prime * result + ((listIngredientes == null) ? 0 : listIngredientes.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + precio;
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
		ProductoImpl other = (ProductoImpl) obj;
		if (listAlergenos == null) {
			if (other.listAlergenos != null)
				return false;
		} else if (!listAlergenos.equals(other.listAlergenos))
			return false;
		if (listIngredientes == null) {
			if (other.listIngredientes != null)
				return false;
		} else if (!listIngredientes.equals(other.listIngredientes))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (precio != other.precio)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductoImpl [name=" + name + ", precio=" + precio + ", listIngredientes=" + listIngredientes
				+ ", listAlergenos=" + listAlergenos + "]";
	}
	
}
