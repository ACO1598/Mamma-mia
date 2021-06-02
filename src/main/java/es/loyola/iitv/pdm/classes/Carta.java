package es.loyola.iitv.pdm.classes;

import java.util.List;

public interface Carta {

	int getId_restaurante();

	void setId_restaurante(int id_restaurante);

	List<Categoria> getCategorias();

	void setCategorias(List<Categoria> categorias);

	int hashCode();

	boolean equals(Object obj);

	String toString();

}