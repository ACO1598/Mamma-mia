package es.loyola.iitv.pdm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import es.loyola.iitv.pdm.classes.Carta;
import es.loyola.iitv.pdm.classes.DB;

@WebServlet(urlPatterns="/mostrarCarta")
public class MostrarCartaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Cache-Contorl", "no-store");
		PrintWriter writer= resp.getWriter();
		JSONObject respuesta= new JSONObject();
		
		int id_restaurante= Integer.parseInt(req.getParameter("id_restaurante"));
		Carta res= null;
		
		for(Carta c: DB.getCartas()) {
			if(c.getId_restaurante() == id_restaurante) {
				res= c;
			}
		}
		
		if(res== null) {
			respuesta.put("code", "ERROR");
			respuesta.put("message", "No se ha encontrado ninguna carta");
			respuesta.put("result", res);
		}else {
			respuesta.put("code", "ok");
			respuesta.put("message", "ok");
			respuesta.put("result", res);
		}
		
		writer.write(respuesta.toString());
	}
}
