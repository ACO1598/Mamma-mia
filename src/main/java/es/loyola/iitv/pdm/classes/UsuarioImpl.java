package es.loyola.iitv.pdm.classes;

public class UsuarioImpl implements Usuario {
	
	private int id, n_telefono;
	private String nombre, apellidos, correo, contrase�a;
	
	public UsuarioImpl() {
		
	}

	public UsuarioImpl(int id, int n_telefono, String nombre, String apellidos, String correo, String contrase�a) {
		this.id = id;
		this.n_telefono = n_telefono;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contrase�a = contrase�a;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getN_telefono() {
		return n_telefono;
	}

	public void setN_telefono(int n_telefono) {
		this.n_telefono = n_telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((contrase�a == null) ? 0 : contrase�a.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + id;
		result = prime * result + n_telefono;
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
		UsuarioImpl other = (UsuarioImpl) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (contrase�a == null) {
			if (other.contrase�a != null)
				return false;
		} else if (!contrase�a.equals(other.contrase�a))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (id != other.id)
			return false;
		if (n_telefono != other.n_telefono)
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
		return "UsuarioImpl [id=" + id + ", n_telefono=" + n_telefono + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", correo=" + correo + ", contrase�a=" + contrase�a + "]";
	}
	
}
