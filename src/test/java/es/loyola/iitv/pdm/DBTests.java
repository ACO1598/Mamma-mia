package es.loyola.iitv.pdm;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import es.loyola.iitv.pdm.classes.Carta;
import es.loyola.iitv.pdm.classes.DB;
import es.loyola.iitv.pdm.classes.Reserva;
import es.loyola.iitv.pdm.classes.Restaurante;
import es.loyola.iitv.pdm.classes.Usuario;

public class DBTests {

	@Test
	public void testRestaurantes() {		
		List<Restaurante> restaurantes= DB.getRestaurantes();
		
		if(restaurantes.size() != 3) {
			fail("el tamaño deberia de ser 3, tamaño: " + restaurantes.size());
		}else {
			Restaurante res1= restaurantes.get(0);
			System.out.println("Apertura: " + res1.getHorario_Open());
			System.out.println("Cierre: " + res1.getHorario_Close());
			
			SimpleDateFormat f= new SimpleDateFormat("HH-mm");
			Date open= null, close= null;
			try {
				open= f.parse("08-00");
				close= f.parse("20-00");
			}catch (ParseException e) { 
		         System.out.println("Unparseable using " + f); 
		    }
			
			assertEquals("El horario no es igual", open, res1.getHorario_Open());
			assertEquals("El horario no es igual", close, res1.getHorario_Close());
		}
	}
	
	@Test
	public void testReserva() {
		List<Reserva> reservas= DB.getReservas();
		
		if(reservas.size() != 1) {
			fail("el tamaño deberia de ser 3, tamaño: " + reservas.size());
		}else {
			
			assertEquals("El id de usuario no concuerda", 0, reservas.get(0).getId_user());
		}
	}
	
	@Test
	public void testUsuarios() {
		List<Usuario> users= DB.getUsuarios();
		
		if(users.size()!= 3) {
			fail("El tamaño deberia de ser 3, tamaño: " + users.size());
		}else {
			assertEquals("El correo no concuerda", "aclech@gmail.com", users.get(0).getCorreo());
		}
	}

	@Test
	public void testCartas() {
		List<Carta> cartas= DB.getCartas();
		
		if(cartas.size()!= 1) {
			fail("El tamaño deberia de ser 1, tamaño: " + cartas.size());
		}else {
			assertEquals("Una de las categorias no es correcta", "Clasicos", cartas.get(0).getCategorias().get(0).getNombre());
			assertEquals("Una de las categorias no es correcta", "Deluxe", cartas.get(0).getCategorias().get(1).getNombre());
			assertEquals("Una de las categorias no es correcta", "Bebidas", cartas.get(0).getCategorias().get(2).getNombre());
		}
	}
}
