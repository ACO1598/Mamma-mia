package es.loyola.iitv.pdm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import es.loyola.iitv.pdm.classes.DB;
import es.loyola.iitv.pdm.classes.Usuario;

@WebServlet(urlPatterns="/inicioSesion")
public class InicioSesionServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		PrintWriter writer= resp.getWriter();
		JSONObject respuesta= new JSONObject();
		
		String correo= req.getParameter("correo_usuario");
		String contraseña= req.getParameter("contraseña_usuario");
		Boolean check= false;
		List<Usuario> users= DB.getUsuarios();
		
		for (Usuario user: users) {
			if(user.getCorreo().equals(correo) && user.getContraseña().equals(contraseña)) {
				check= true;
			}
		}
		
		if(check== true) {
			respuesta.put("code", "ok");
			respuesta.put("message", "Inicio de sesion satisfactorio");
			respuesta.put("result", "");
		}else {
			respuesta.put("code", "ERROR");
			respuesta.put("message", "Error al iniciar sesion");
			respuesta.put("result", "");
		}
		writer.write(respuesta.toString());
	}
}
