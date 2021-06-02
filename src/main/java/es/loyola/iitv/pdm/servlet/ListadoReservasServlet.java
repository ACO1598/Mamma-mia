package es.loyola.iitv.pdm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import es.loyola.iitv.pdm.classes.DB;
import es.loyola.iitv.pdm.classes.Reserva;



@WebServlet(urlPatterns="/listadoReservas")
public class ListadoReservasServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 79023983243172301L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		PrintWriter writer= resp.getWriter();
		JSONObject respuesta= new JSONObject();
		
		int id= Integer.parseInt(req.getParameter("id_usuario")) ;
		List<Reserva> reservas= new LinkedList<Reserva>();
		
		for(Reserva reserva : DB.getReservas()) {
			if(reserva.getId() == id) {
				reservas.add(reserva);
			}
		}
		if(reservas.isEmpty()) {
			respuesta.put("code", "ok");
			respuesta.put("message", "No hay ninguna reserva");
			respuesta.put("result", reservas);
		}else {
			respuesta.put("code", "ok");
			respuesta.put("message", "ok");
			respuesta.put("result", reservas);
		}
		
		writer.write(respuesta.toString());
	}
}
