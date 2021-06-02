package es.loyola.iitv.pdm.classes;

import java.util.List;

public interface Categoria {

	String getNombre();

	void setNombre(String nombre);

	List<Producto> getListProductos();

	void setListProductos(List<Producto> listProductos);

	int hashCode();

	boolean equals(Object obj);

	String toString();

}