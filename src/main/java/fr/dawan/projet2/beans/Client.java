package fr.dawan.projet2.beans;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import fr.dawan.projet2.beans.Event;
@Entity
@Table(name = "client")
public class Client extends User {
	@Column(name = "address", length = 150, nullable = false)
	private String address;
	@Column(name = "dateOfBirth",nullable = false)
	private LocalDate dateOfBirth;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE }, fetch = FetchType.LAZY)
	private List<Event> eventsagenda; //la liste d'evenements de l'agenda du client

	public Client() {
		super();
	}

	public Client(String address, LocalDate dateOfBirth) {
		super();
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}
//methode pour ajouter un event a l'agenda de l'utilisateur
	public void addEvent(Event event) {
		if(eventsagenda.contains(event)) {
			eventsagenda.add(event);
		}		
		}

	//ici commentaire pour test git
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
