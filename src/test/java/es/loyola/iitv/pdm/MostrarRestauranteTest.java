package es.loyola.iitv.pdm;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
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
import es.loyola.iitv.pdm.classes.RestauranteImpl;
import es.loyola.iitv.pdm.servlet.MostrarRestauranteServlet;

public class MostrarRestauranteTest {
 
	@Test
	
	public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException {
		
		HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse resp = Mockito.mock(HttpServletResponse.class);
		
		when(req.getParameter("id")).thenReturn("0");
		
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		
		try {
			
			Mockito.when(resp.getWriter()).thenReturn(writer);
			new MostrarRestauranteServlet().doPost(req, resp);
			
			JSONObject obj = new JSONObject(stringWriter.toString());
			System.out.println(obj.getJSONObject("result"));
			String code = obj.getString("code");
			assertTrue("Codigo devuelto es ok", code.equalsIgnoreCase("ok"));
			
			String message = obj.getString("message");
			assertTrue("Mensaje devuelto es incorrecto", message.equalsIgnoreCase("ok"));
			
			JSONObject o1 = obj.getJSONObject("result");
			Integer id = o1.getInt("id");
			Integer aforo = o1.getInt("aforo");
			Integer telefono = o1.getInt("telefono");
			String shorario_Open = o1.getString("horario_Open");
			System.out.println(shorario_Open);
			SimpleDateFormat formatdate= new SimpleDateFormat("HH-mm");
			Date horario_Open= null;
			try {
				horario_Open= formatdate.parse(shorario_Open);
			}catch (Exception e) {
				e.printStackTrace();
			}
			String shorario_Close = o1.getString("horario_Close");
			Date horario_Close= null;
			try {
				horario_Close= formatdate.parse(shorario_Close);
			}catch (Exception e) {
				e.printStackTrace();
			}
			JSONArray jsonopenDays = o1.getJSONArray("openDays");
			int[] openDays= {0, 0, 0, 0, 0, 0, 0};
			for(int i=0; i<jsonopenDays.length(); i++) {
				openDays[i]= jsonopenDays.getInt(i);
			}
				
			System.out.print(horario_Close);
			
			Restaurante r = new RestauranteImpl(id, aforo, telefono, horario_Open, horario_Close,openDays);
				
			System.out.println(r);
			
		}catch (IOException e) {
			//TODO Auto-generated
			e.printStackTrace();
			}
		
	} 

}
