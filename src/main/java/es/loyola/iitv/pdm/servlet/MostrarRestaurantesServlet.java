package es.loyola.iitv.pdm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import es.loyola.iitv.pdm.classes.DB;
import es.loyola.iitv.pdm.classes.Restaurante;


@WebServlet(urlPatterns="/mostrarRestaurantes")
public class MostrarRestaurantesServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		PrintWriter writer= resp.getWriter();
		
		JSONArray arrayRestaurantes = new JSONArray();
		
		for(Restaurante r: DB.getRestaurantes()) {
			JSONObject objetoJSON = new JSONObject(); 
			objetoJSON.put("id", r.getId());
			objetoJSON.put("aforo",r.getAforo());
			objetoJSON.put("telefono", r.getTelefono());
			objetoJSON.put("horario_Open", r.getHorario_Open());
			objetoJSON.put("horario_Close", r.getHorario_Close());
			objetoJSON.put("openDays", r.getOpenDays());
			
			arrayRestaurantes.put(objetoJSON);
			
			
			
		}
		
		if (!arrayRestaurantes.isEmpty()) {
			JSONObject respuesta = new JSONObject();
			respuesta.put("code", "ok");
			respuesta.put("message", "ok");
			respuesta.put("result", arrayRestaurantes);
			
			writer.write(respuesta.toString());
		} else {
			JSONObject respuesta = new JSONObject(); 
			respuesta.put("code", "Error");
			respuesta.put("message", "Empty List");
			respuesta.put("result", new JSONObject());
			
			writer.write(respuesta.toString());
		}
	}

}
