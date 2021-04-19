package es.loyola.iitv.pdm.classes;

import java.util.Date;

public class ReservaImpl implements Reserva{

	private int id, nPersonas;
	private Date fecha= new Date();
	
	public ReservaImpl(int id, int nPersonas, Date fecha) {
		super();
		this.id = id;
		this.nPersonas = nPersonas;
		this.fecha = fecha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getnPersonas() {
		return nPersonas;
	}
	public void setnPersonas(int nPersonas) {
		this.nPersonas = nPersonas;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
		result = prime * result + nPersonas;
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
		ReservaImpl other = (ReservaImpl) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (nPersonas != other.nPersonas)
			return false;
		return true;
	}
}
