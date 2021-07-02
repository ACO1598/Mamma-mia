package es.loyola.iitv.pdm;

import static org.junit.Assert.assertTrue;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.mockito.Mockito;

import es.loyola.iitv.pdm.classes.Restaurante;
import es.loyola.iitv.pdm.servlet.MostrarRestaurantesServlet;

public class MostrarRestaurantesTest {

@Test
	
	public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException {
		
		HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse resp = Mockito.mock(HttpServletResponse.class);
		
		
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		
		try {
			
			Mockito.when(resp.getWriter()).thenReturn(writer);
			new MostrarRestaurantesServlet().doPost(req, resp);
			
			System.out.println(stringWriter.toString());
			
			JSONObject obj = new JSONObject(stringWriter.toString());
			String code = obj.getString("code");
			assertTrue("Codigo devuelto es ok", code.equalsIgnoreCase("ok"));
			
			String message = obj.getString("message");
			assertTrue("Mensaje devuelto es incorrecto", message.equalsIgnoreCase("ok"));
			
			JSONArray array = obj.getJSONArray("result");
			assertTrue("Tama�o array incorrecto: " + array.length(), array.length() == 3);
			
		}catch (IOException e) {
			//TODO Auto-generated
			e.printStackTrace();
			}
	}
}
