package es.loyola.iitv.pdm.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DB {
	//TODO Puesto que no tenemos base de datos despreciamos los datos nuevos que se introduzcan en el sistema?
//	private List<Restaurante> restaurantes;
//	private List<Reserva> reservas;
//	private List<Usuario> usuarios;
//	
//	public DB() {
//		
//	}
	
	static public List<Restaurante> getRestaurantes(){
		List<Restaurante> res= new LinkedList<Restaurante>();
		int[] days= new int[] {0,1,1,1,1,0,0};
		SimpleDateFormat f= new SimpleDateFormat("HH-mm");
		Date open= null, close= null;
		try {
			open= f.parse("08-00");
			close= f.parse("20-00");
		}catch (ParseException e) { 
	         System.out.println("Unparseable using " + f); 
	    }
		res.add(new RestauranteImpl(0, 30, 654213789, open, close, days));
		days= new int[] {1,1,1,0,0,0,0};
		try {
			open= f.parse("06-00");
			close= f.parse("21-30");
		}catch (ParseException e) { 
	         System.out.println("Unparseable using " + f); 
	    }
		res.add(new RestauranteImpl(1, 20, 987654312, open, close, days));
		days= new int[] {1,1,1,1,1,1,0};
		try {
			open= f.parse("10-00");
			close= f.parse("22-00");
		}catch (ParseException e) { 
	         System.out.println("Unparseable using " + f); 
	    }
		res.add(new RestauranteImpl(2, 60, 123456789, open, close, days));
		return res;
	}
	
	static public List<Reserva> getReservas() {
		List<Reserva> reservas= new LinkedList<Reserva>();
		SimpleDateFormat f= new SimpleDateFormat("HH-mm");
		Date date= null;
		try {
			date= f.parse("08-00");
		}catch (ParseException e) { 
	         System.out.println("Unparseable using " + f); 
	    }
		reservas.add(new ReservaImpl(0, 2, date, 0));
		return reservas;
	}
	
	static public List<Usuario> getUsuarios(){
		List<Usuario> usuarios= new LinkedList<Usuario>();
		usuarios.add(new UsuarioImpl(0, 1234, "Alan", "Clech", "aclech@gmail.com", "alicia"));
		usuarios.add(new UsuarioImpl(1, 2345, "Jabril", "", "jabril@gmail.com", "testing"));
		usuarios.add(new UsuarioImpl(2, 3456, "Alvaro", "Bersabe", "abersabe@gmail.com", "1234"));
		return usuarios;
	}
}
