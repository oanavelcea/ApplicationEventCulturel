package fr.dawan.projet2.dao;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;

import fr.dawan.projet2.beans.Event;

public class JsonTools {

	public static List<Event> importAllEventsFromJson() throws Exception{
		String link = "https://opendata.lillemetropole.fr/api/records/1.0/search/?dataset=evenements-publics-openagenda&facet=tags&facet=placename&facet=department&facet=region&facet=city&facet=date_start&facet=date_end&facet=pricing_info&facet=updated_at&facet=city_district";
	    
	    Client client = ClientBuilder.newClient().register(JacksonFeature.class);
		
	    Response res = client.target(link).request().get();
		
		if(res.getStatus()!=200 && res.getStatus()!=201) {
			throw new RuntimeException("Erreur : " + res.getStatus() + " " + res.getStatusInfo().toString());
		}
		
		
		String json = res.readEntity(String.class);
		
		InputStream is = new ByteArrayInputStream(json.getBytes());
		JsonReader reader = Json.createReader(is);
		is.close();
		client.close();//fermer la connexion
		
		JsonObject objGlobal = reader.readObject();
		
		JsonArray jsonRecords = objGlobal.getJsonArray("records");
		
		List<Event> evtList = new ArrayList<Event>();
		
		for(int i=0;i<jsonRecords.size();i++) {
			Event evt = new Event();
			
			JsonObject objRecord= jsonRecords.getJsonObject(i);
			
			//objR0Fields contient : 
			//{"latlon":[50.683548,3.153565],
			//"lang":"fr",
			//"city":"Croix","uid":"15363992","placename":"Centre Culturel Jacques Brel","pricing_info":"Gratuit","image":"http://cibul.s3.amazonaws.com/event_quartier-saint-pierre-les-fetes-estivales_366148.jpg","date_start":"2017-07-27","updated_at":"2017-09-28T08:49:46+00:00","space_time_info":"du jeudi 27 juillet au jeudi 17 août à Centre Culturel Jacques Brel","department":"Nord","link":"http://openagenda.com/event/quartier-saint-pierre-les-fetes-estivales","title":"Quartier Saint Pierre - Les fêtes estivales","address":"rue Jean Baptiste Delescluse Croix","timetable":"2017-07-27T14:00:00 2017-07-27T15:00:00;2017-08-17T21:30:00 2017-08-17T22:30:00","image_thumb":"http://cibul.s3.amazonaws.com/evtbevent_quartier-saint-pierre-les-fetes-estivales_366148.jpg","region":"Hauts-de-France","date_end":"2017-08-17","tags":"saint pierre,croix","description":"Fêtes estivales"}
			JsonObject objRFields = objRecord.getJsonObject("fields");
			
			JsonArray obj0LatLon = objRFields.getJsonArray("latlon");
			evt.setLatitude(Double.parseDouble(obj0LatLon.get(0).toString()));
			evt.setLongitude(Double.parseDouble(obj0LatLon.get(1).toString()));
			
			try {
			evt.setTitle(objRFields.getString("title"));
			}catch(Exception ex) {
				evt.setTitle("");
			}
			System.out.println("title = " + evt.getTitle());
			
			evt.setLang(objRFields.getString("lang"));
			evt.setCity(objRFields.getString("city"));
			
			SimpleDateFormat convertDates = new SimpleDateFormat("yyyy-MM-dd");
			evt.setDateStart(convertDates.parse(objRFields.getString("date_start")));
			evt.setDateEnd(convertDates.parse(objRFields.getString("date_end")));
			
			//TODO : récupérer les autres champs
			
			evtList.add(evt);
		}
		
		return evtList;
		
	}
}
