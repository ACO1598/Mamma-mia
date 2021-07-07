package es.loyola.iitv.pdm.classes;

import java.util.Date;

public interface Restaurante {

	boolean comprobarHorario(Date fecha);

	int getId();

	void setId(int id);

	int getAforo();

	void setAforo(int aforo);

	int getTelefono();

	void setTelefono(int telefono);

	Date getHorario_Open();

	void setHorario_Open(Date horario1);

	Date getHorario_Close();

	void setHorario_Close(Date horario2);

	int[] getOpenDays();

	void setOpenDays(int[] openDays);
	
	String getDireccion();

	void setDireccion(String direccion);

	String toString();

}