package es.loyola.iitv.pdm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import es.loyola.iitv.pdm.classes.DB;
import es.loyola.iitv.pdm.classes.Restaurante;

@WebServlet(urlPatterns="/mostrarRestaurante")


public class MostrarRestauranteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Cache-Contorl", "no-store");
		PrintWriter writer= resp.getWriter();
		JSONObject respuesta= new JSONObject();
		
			int id= Integer.parseInt(req.getParameter("id"));
			Restaurante res= null;
			
			for (Restaurante r: DB.getRestaurantes()) {
				if(r.getId() == id) {
					res = r;
				}
			}
			
			if(res== null) {
				respuesta.put("code", "ERROR");
				respuesta.put("message", "No se ha encontrado ninguna carta");
				respuesta.put("result", res);
			}else {
				JSONObject result= new JSONObject();
				result.put("id", res.getId());
				result.put("aforo", res.getAforo());
				result.put("telefono", res.getTelefono());
				result.put("horario_Open", res.getHorario_Open());
				result.put("horario_Close", res.getHorario_Close());
				result.put("openDays", res.getOpenDays());
				result.put("direccion", res.getDireccion());
				respuesta.put("code", "ok");
				respuesta.put("message", "ok");
				respuesta.put("result", result);
			}
			
			writer.write(respuesta.toString());
		
	}
}
