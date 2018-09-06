package fr.dawan.projet2.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;

import fr.dawan.projet2.beans.Event;
import fr.dawan.projet2.dao.JsonTools;

@WebServlet("/OpenDataController")
public class OpenDataController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<Event> events = JsonTools.importAllEventsFromJson();
			req.setAttribute("events", events);
			req.getRequestDispatcher("events.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}




	}

	
	
	
}
