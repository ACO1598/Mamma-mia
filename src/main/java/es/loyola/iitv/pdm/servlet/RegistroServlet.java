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
import es.loyola.iitv.pdm.classes.Usuario;
import es.loyola.iitv.pdm.classes.UsuarioImpl;

@WebServlet(urlPatterns="/registro")
public class RegistroServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7096937370433213109L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		PrintWriter writer= resp.getWriter();
		JSONObject respuesta= new JSONObject();
		
		String nombre= req.getParameter("nombre_usuario");
		String apellidos= req.getParameter("apellidos_usuario");
		String correo= req.getParameter("correo_usuario");
		String contraseña= req.getParameter("contraseña_usuario");
		int telf= Integer.parseInt(req.getParameter("telefono_usuario"));
		int n_users= DB.getUsuarios().size();
		
		if(nombre.isEmpty() && apellidos.isEmpty() && correo.isEmpty() && contraseña.isEmpty() && telf != 0) {
			JSONObject result= new JSONObject();
			
			respuesta.put("code", "ok");
			respuesta.put("message", "Inicio de sesion satisfactorio");
			result.put("id", n_users);
			result.put("n_telefono", telf);
			result.put("nombre", nombre);
			result.put("apellidos", apellidos);
			result.put("correo", correo);
			result.put("contrasena", contraseña);
			respuesta.put("result", result);
		}else {
			respuesta.put("code", "ERROR");
			respuesta.put("message", "Ha habido un error en el registro");
			respuesta.put("result", "");
		}
		
		writer.write(respuesta.toString());
	}
}
