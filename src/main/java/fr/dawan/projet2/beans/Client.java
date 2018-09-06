package fr.dawan.projet2.beans;

import java.time.LocalDate;
import java.util.List;


import fr.dawan.projet2.beans.Event;

public class Client extends User {
	private String address;
	private LocalDate dateOfBirth;
	private List<Event> eventsagenda; //la liste d'evenements de l'agenda du client

	public Client() {
		super();
	}

	public Client(String address, LocalDate dateOfBirth) {
		super();
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	

	public List<Event> getEvents() {
		return eventsagenda;
	}

	public void setEvents(List<Event> events) {
		this.eventsagenda = events;
	}

	@Override
	public String toString() {
		return "Client [address=" + address + ", dateOfBirth=" + dateOfBirth + ", events=" + eventsagenda + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (eventsagenda == null) {
			if (other.eventsagenda != null)
				return false;
		} else if (!eventsagenda.equals(other.eventsagenda))
			return false;
		return true;
	}
	
}
