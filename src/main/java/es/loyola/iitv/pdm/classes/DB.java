package es.loyola.iitv.pdm.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DB {
	
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
		res.add(new RestauranteImpl(0, 30, 654213789, open, close, days, "direccion1"));
		days= new int[] {1,1,1,0,0,0,0};
		try {
			open= f.parse("06-00");
			close= f.parse("21-30");
		}catch (ParseException e) { 
	         System.out.println("Unparseable using " + f); 
	    }
		res.add(new RestauranteImpl(1, 20, 987654312, open, close, days, "direccion2"));
		days= new int[] {1,1,1,1,1,1,0};
		try {
			open= f.parse("10-00");
			close= f.parse("22-00");
		}catch (ParseException e) { 
	         System.out.println("Unparseable using " + f); 
	    }
		res.add(new RestauranteImpl(2, 60, 123456789, open, close, days, "direccion3"));
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
		reservas.add(new ReservaImpl(0, 0, 2, date, 0, "direccion1"));
		return reservas;
	}
	
	static public List<Usuario> getUsuarios(){
		List<Usuario> usuarios= new LinkedList<Usuario>();
		usuarios.add(new UsuarioImpl(0, 1234, "Alan", "Clech", "aclech@gmail.com", "alicia"));
		usuarios.add(new UsuarioImpl(1, 2345, "Jabril", "", "jabril@gmail.com", "testing"));
		usuarios.add(new UsuarioImpl(2, 3456, "Alvaro", "Bersabe", "abersabe@gmail.com", "1234"));
		return usuarios;
	}
	
	static public List<Carta> getCartas(){
		List<Carta> cartas= new LinkedList<Carta>();
		Alergenos ale1= new AlergenosImpl(0, "Pescado");
		Alergenos ale2= new AlergenosImpl(1, "Frutos Secos");
		Alergenos ale3= new AlergenosImpl(2, "Lacteos");
		Alergenos ale4= new AlergenosImpl(3, "Huevos");
		Ingredientes ingre1= new IngredientesImpl(0, "Queso");
		Ingredientes ingre2= new IngredientesImpl(1, "Tomate");
		Ingredientes ingre3= new IngredientesImpl(2, "Huevo");
		Ingredientes ingre4= new IngredientesImpl(3, "4 Quesos");
		Ingredientes ingre5= new IngredientesImpl(4, "Jamon");
		Ingredientes ingre6= new IngredientesImpl(5, "Pollo");
		Ingredientes ingre7= new IngredientesImpl(6, "Bacon");
		List<Alergenos> alergenos= new LinkedList<Alergenos>();
		List<Ingredientes> ingredientes= new LinkedList<Ingredientes>();
		alergenos.add(ale3);
		ingredientes.add(ingre2);
		ingredientes.add(ingre4);
		Producto prod1= new ProductoImpl("4 Quesos", 10, ingredientes, alergenos);
		ingredientes.clear();
		ingredientes.add(ingre2);
		ingredientes.add(ingre1);
		ingredientes.add(ingre5);
		Producto prod2= new ProductoImpl("Clasica", 8, ingredientes, alergenos);
		ingredientes.clear();
		ingredientes.add(ingre2);
		ingredientes.add(ingre1);
		ingredientes.add(ingre5);
		ingredientes.add(ingre6);
		ingredientes.add(ingre7);
		ingredientes.add(ingre3);
		Producto prod3= new ProductoImpl("Sueño de carne", 12, ingredientes, alergenos);
		alergenos.clear();
		ingredientes.clear();
		Producto agua= new ProductoImpl("Agua", 1, ingredientes, alergenos);
		List<Producto> productos= new LinkedList<Producto>();
		productos.add(prod1);
		productos.add(prod2);
		Categoria clasicos= new CategoriaImpl("Clasicos", productos);
		productos.clear();
		productos.add(prod3);
		Categoria deluxe= new CategoriaImpl("Deluxe", productos);
		productos.clear();
		productos.add(agua);
		Categoria bebidas= new CategoriaImpl("Bebidas", productos);
		List<Categoria> categorias= new LinkedList<Categoria>();
		categorias.add(clasicos);
		categorias.add(deluxe);
		categorias.add(bebidas);
		Carta carta= new CartaImpl(0, categorias);
		cartas.add(carta);
		return cartas;
	}
}
