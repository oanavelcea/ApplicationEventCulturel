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

	//test commit
	public static List<Event> importAllEventsFromJson() throws Exception {
		String link = "https://opendata.lillemetropole.fr/api/records/1.0/search/?dataset=evenements-publics-openagenda&facet=tags&facet=placename&facet=department&facet=region&facet=city&facet=date_start&facet=date_end&facet=pricing_info&facet=updated_at&facet=city_district";

		Client client = ClientBuilder.newClient().register(JacksonFeature.class);

		Response res = client.target(link).request().get();

		if (res.getStatus() != 200 && res.getStatus() != 201) {
			throw new RuntimeException("Erreur : " + res.getStatus() + " " + res.getStatusInfo().toString());
		}

		String json = res.readEntity(String.class);

		InputStream is = new ByteArrayInputStream(json.getBytes());
		JsonReader reader = Json.createReader(is);
		is.close();
		client.close();// fermer la connexion

		JsonObject objGlobal = reader.readObject();

		JsonArray jsonRecords = objGlobal.getJsonArray("records");

		List<Event> evtList = new ArrayList<Event>();

		for (int i = 0; i < jsonRecords.size(); i++) {
			Event evt = new Event();

			JsonObject objRecord = jsonRecords.getJsonObject(i);

			JsonObject objRFields = objRecord.getJsonObject("fields");

			try {
				JsonArray obj0LatLon = objRFields.getJsonArray("latlon");
				evt.setLatitude(Double.parseDouble(obj0LatLon.get(0).toString()));
				evt.setLongitude(Double.parseDouble(obj0LatLon.get(1).toString()));
			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}

			try {
				evt.setTitle(objRFields.getString("title"));// "title":"Quartier Saint Pierre - Les fêtes estivales",
			} catch (Exception ex) {
				evt.setTitle("");
			}

			try {
				evt.setLang(objRFields.getString("lang"));
			} catch (Exception ex) {
				evt.setLang("");
			}

			try {
				evt.setCity(objRFields.getString("city"));
			} catch (Exception ex) {
				evt.setCity("");
			}

			try {
				SimpleDateFormat convertDates = new SimpleDateFormat("yyyy-MM-dd");
				evt.setDateStart(convertDates.parse(objRFields.getString("date_start")));
				evt.setDateEnd(convertDates.parse(objRFields.getString("date_end")));
			} catch (Exception ex) {

			}

			try {
				evt.setPlacename(objRFields.getString("placename"));
			} catch (Exception ex) {
				evt.setPlacename("");
			}

			try {
				evt.setUid(Integer.parseInt(objRFields.getString("uid")));
			} catch (Exception ex) {
				// uid = 0
			}

			try {
				evt.setImage(objRFields.getString("image"));// "image":"http://cibul.s3.amazonaws.com/event_quartier-saint-pierre-les-fetes-estivales_366148.jpg",
			} catch (Exception ex) {// absence d'image
				evt.setImage("");
			}

			try {
				evt.setSpaceTimeInfo(objRFields.getString("space_time_info"));// "space_time_info":"du jeudi 27 juillet
																				// au jeudi 17 août à Centre Culturel
																				// Jacques Brel",
			} catch (Exception ex) {
				evt.setSpaceTimeInfo("");
			}

			try {
				evt.setDepartment(objRFields.getString("department"));// "department":"Nord",
			} catch (Exception ex) {
				evt.setDepartment("");
			}

			try {
				evt.setLink(objRFields.getString("link"));// "link":"http://openagenda.com/event/quartier-saint-pierre-les-fetes-estivales",
			} catch (Exception ex) {
				evt.setLink("");
			}

			try {
				evt.setAddress(objRFields.getString("address"));// "address":"rue Jean Baptiste Delescluse Croix",
			} catch (Exception ex) {
				evt.setAddress("");
			}

			try {
				evt.setRegion(objRFields.getString("region"));// "region":"Hauts-de-France",
			} catch (Exception ex) {
				evt.setRegion("");
			}

			try {
				evt.setImageThumb(objRFields.getString("image_thumb"));// "image_thumb":"http://cibul.s3.amazonaws.com/evtbevent_quartier-saint-pierre-les-fetes-estivales_366148.jpg",
			} catch (Exception e) {// absence d'icone
				evt.setImageThumb("");
			}

			try {
				evt.setDescription(objRFields.getString("description"));// "description":"Fêtes estivales"}
			} catch (Exception e) {
				evt.setDescription("");
			}
			// "tags":"saint pierre,croix"
			try {
				String tags = objRFields.getString("tags");
				if (tags != null && !tags.equals("")) {
					String[] tagsArray = tags.split(",");
					for (String sT : tagsArray) {
						evt.getTags().add(sT);
					}
				}
			} catch (Exception ex) {
				// tags vides
			}

			// "updated_at":"2017-09-28T08:49:46+00:00",
			SimpleDateFormat sdfUpdated = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
			try {
				evt.setUpdatedAt(sdfUpdated.parse(objRFields.getString("updated_at")));
			} catch (Exception e) {
				evt.setUpdatedAt(null);
			}

			// "timetable":"2017-07-27T14:00:00 2017-07-27T15:00:00;2017-08-17T21:30:00
			// 2017-08-17T22:30:00",
			SimpleDateFormat sdfTimeTable = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			SimpleDateFormat sdfTimeTableNEW = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String timetable = objRFields.getString("timetable");
			if (timetable != null && !timetable.equals("")) {
				String[] timetableArray = timetable.split(";");
				for (String sT : timetableArray) {
					// sT = 2017-07-27T14:00:00 2017-07-27T15:00:00
					String[] oneTTArray = sT.split(" ");
					String startDateTT = "";
					String endDateTT = "";
					try {
						startDateTT = sdfTimeTableNEW.format(sdfTimeTable.parse(oneTTArray[0]));
					} catch (Exception e) {

					}
					try {
						endDateTT = sdfTimeTableNEW.format(sdfTimeTable.parse(oneTTArray[1]));
					} catch (Exception e) {

					}
					// 27/07/2017 14:00:00 - 27/07/2017 15:00:00
					evt.getTimeTable().add(startDateTT + " - " + endDateTT);
				}
			}

			evtList.add(evt);
		}

		return evtList;

	}
}
