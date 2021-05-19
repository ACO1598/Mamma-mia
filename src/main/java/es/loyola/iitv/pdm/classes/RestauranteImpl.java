package es.loyola.iitv.pdm.classes;

import java.util.Calendar;
import java.util.Date;

public class RestauranteImpl implements Restaurante  {
	private int id, aforo, telefono;
	private Date horario_Open, horario_Close;
	private int[] openDays;
	
	public RestauranteImpl(int id, int aforo, int telefono, Date horario1, Date horario2, int[] openDays) {
		this.id = id;
		this.aforo = aforo;
		this.telefono = telefono;
		this.horario_Open = horario1;
		this.horario_Close = horario2;
		this.openDays = openDays;
	}
	
	public RestauranteImpl() {
		this.setId(0);
		this.setAforo(0);
		this.setTelefono(0);
		this.setHorario_Open(null);
		this.setHorario_Close(null);
		this.setOpenDays(null);
	}
	
	public boolean comprobarHorario(Date fecha) {
		
		Calendar cal= Calendar.getInstance();
		cal.setTime(fecha);
		int day= cal.get(Calendar.DAY_OF_WEEK);
		boolean checkDate= false;
		boolean checkHour= false;
		
		for (int i : this.getOpenDays()) {
			if(day== i) {
				checkDate= true;
			}
		}
		
		if(checkDate == true) {
			if(fecha.getHours() >= this.getHorario_Open().getHours()&& fecha.getHours() <= this.getHorario_Close().getHours()) {
				checkHour= true;
			}
		}
		
		return checkHour;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Date getHorario_Open() {
		return horario_Open;
	}

	public void setHorario_Open(Date horario1) {
		this.horario_Open = horario1;
	}

	public Date getHorario_Close() {
		return horario_Close;
	}

	public void setHorario_Close(Date horario2) {
		this.horario_Close = horario2;
	}

	public int[] getOpenDays() {
		return openDays;
	}

	public void setOpenDays(int[] openDays) {
		this.openDays = openDays;
	}

	@Override
	public String toString() {
		return "RestauranteImpl [id=" + id + ", aforo=" + aforo + ", telefono=" + telefono + ", horario1=" + horario_Open
				+ ", horario2=" + horario_Close + "]";
	}
	
	
}
