package es.loyola.iitv.pdm.classes;

public interface Usuario {

	int getId();

	void setId(int id);

	int getN_telefono();

	void setN_telefono(int n_telefono);

	String getNombre();

	void setNombre(String nombre);

	String getApellidos();

	void setApellidos(String apellidos);

	String getCorreo();

	void setCorreo(String correo);

	String getContrase�a();

	void setContrase�a(String contrase�a);

	int hashCode();

	boolean equals(Object obj);

	String toString();

}