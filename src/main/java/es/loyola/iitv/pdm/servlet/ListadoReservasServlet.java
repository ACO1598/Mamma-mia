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

import org.json.JSONArray;
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
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Cache-Contorl", "no-store");
		PrintWriter writer= resp.getWriter();
		JSONObject respuesta= new JSONObject();
		
		int id= Integer.parseInt(req.getParameter("id_usuario")) ;
		JSONArray array= new JSONArray();
		
		for(Reserva reserva : DB.getReservas()) {
			if(reserva.getId_user() == id) {
				JSONObject reserv= new JSONObject(); 
				reserv.put("id", reserva.getId_user());
				reserv.put("id_user", id);
				reserv.put("nPersonas", reserva.getnPersonas());
				reserv.put("fecha", reserva.getFecha());
				reserv.put("res", reserva.getRes());
				array.put(reserv);
			}
		}
		if(!array.isEmpty()) {
			respuesta.put("code", "ok");
			respuesta.put("message", "No hay ninguna reserva");
			respuesta.put("result", array);
		}else {
			respuesta.put("code", "ok");
			respuesta.put("message", "ok");
			respuesta.put("result", array);
		}
		
		writer.write(respuesta.toString());
	}
}
