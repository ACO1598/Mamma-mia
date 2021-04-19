package es.loyola.iitv.pdm.classes;

import java.util.Calendar;
import java.util.Date;

public class RestauranteImpl {
	private int id, aforo, telefono;
	private Date horario1, horario2;
	private int[] openDays;
	
	public RestauranteImpl(int id, int aforo, int telefono, Date horario1, Date horario2, int[] openDays) {
		super();
		this.id = id;
		this.aforo = aforo;
		this.telefono = telefono;
		this.horario1 = horario1;
		this.horario2 = horario2;
		this.openDays = openDays;
	}
	
	public boolean comprobarHorario(Date fecha) {
		
		Calendar cal= Calendar.getInstance();
		cal.setTime(fecha);
		int day= cal.get(Calendar.DAY_OF_WEEK);
		boolean checkDay= false;
		
		for (int i : this.getOpenDays()) {
			if(day== i) {
				checkDay= true;
			}
		}
		
		if(checkDay == true) {
			
		}else {
			return false;
		}
		
		return false;
	}
	
	public boolean comprobarFecha(Date fecha) {
		return false;
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

	public Date getHorario1() {
		return horario1;
	}

	public void setHorario1(Date horario1) {
		this.horario1 = horario1;
	}

	public Date getHorario2() {
		return horario2;
	}

	public void setHorario2(Date horario2) {
		this.horario2 = horario2;
	}

	public int[] getOpenDays() {
		return openDays;
	}

	public void setOpenDays(int[] openDays) {
		this.openDays = openDays;
	}

	@Override
	public String toString() {
		return "RestauranteImpl [id=" + id + ", aforo=" + aforo + ", telefono=" + telefono + ", horario1=" + horario1
				+ ", horario2=" + horario2 + "]";
	}
	
	
}
