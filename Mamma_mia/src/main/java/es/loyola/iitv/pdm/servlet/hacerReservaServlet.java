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

@WebServlet(urlPatterns="/hacerReserva")
public class hacerReservaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1408882665997101571L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		PrintWriter writer= resp.getWriter();
		
		int id_usuario= Integer.parseInt(req.getParameter("id_usuario"));
		int id_restaurante= Integer.parseInt(req.getParameter("id_restaurante"));
		int nPersonas= Integer.parseInt(req.getParameter("nPersonas"));
		String strfecha= req.getParameter("fecha");
		SimpleDateFormat formatdate= new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date fecha= formatdate.parse(strfecha);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
