package es.loyola.iitv.pdm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import es.loyola.iitv.pdm.classes.Reserva;
import es.loyola.iitv.pdm.classes.ReservaImpl;

@WebServlet(urlPatterns="/hacerReserva")
public class HacerReservaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1408882665997101571L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Cache-Contorl", "no-store");
		PrintWriter writer= resp.getWriter();
		JSONObject respuesta= new JSONObject();
		JSONObject JSONReserva= new JSONObject();
		
		int id_usuario= Integer.parseInt(req.getParameter("id_usuario"));
		int id_restaurante= Integer.parseInt(req.getParameter("res"));
		int nPersonas= Integer.parseInt(req.getParameter("nPersonas"));
		String strfecha= req.getParameter("fecha");
		SimpleDateFormat formatdate= new SimpleDateFormat("HH-mm");
		Date fecha= null;
		try {
			fecha= formatdate.parse(strfecha);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Reserva reserva= null;
		if(fecha != null) {
			reserva= new ReservaImpl(0, id_usuario, nPersonas, fecha,  id_restaurante);
		}
		
		if(reserva != null) {
			respuesta.put("code", "ok");
			respuesta.put("message", "ok");
			JSONReserva.put("id", reserva.getId());
			JSONReserva.put("id_usuario", id_usuario);
			JSONReserva.put("nPersonas", nPersonas);
			JSONReserva.put("fecha", fecha);
			JSONReserva.put("id_restaurante", id_restaurante);
			respuesta.put("result", JSONReserva);
		}else {
			respuesta.put("code", "ERROR");
			respuesta.put("message", "error haciendo la reserva");
			respuesta.put("result", reserva);
		}
		
		writer.write(respuesta.toString());
	}
}
