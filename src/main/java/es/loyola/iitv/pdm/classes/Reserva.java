package es.loyola.iitv.pdm.classes;

import java.util.Date;

public interface Reserva {

	int getId();
	
	void setId(int id);
	
	int getnPersonas();
	
	void setnPersonas(int nPersonas);
	
	Date getFecha();
	
	void setFecha(Date fecha);
	
	int getId_user();
	
	void setId_user();
	
	int getRes();
	
	void setRes(int res);
}
