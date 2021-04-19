package es.loyola.iitv.pdm.classes;

import java.util.Date;

public interface Reserva {

	int getId();
	
	void setId(int id);
	
	int getnPersonas();
	
	void setnPersonas(int nPersonas);
	
	Date getFecha();
	
	void setFecha(Date fecha);
}
