package es.loyola.iitv.pdm.classes;

import java.util.List;

public interface Producto {

	String getName();

	void setName(String name);

	int getPrecio();

	void setPrecio(int precio);

	List<Ingredientes> getListIngredientes();

	void setListIngredientes(List<Ingredientes> listIngredientes);

	List<Alergenos> getListAlergenos();

	void setListAlergenos(List<Alergenos> listAlergenos);

	int hashCode();

	boolean equals(Object obj);

	String toString();

}