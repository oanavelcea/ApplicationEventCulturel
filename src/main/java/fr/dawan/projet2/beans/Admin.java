package fr.dawan.projet2.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin extends User {
	
	public Admin() {
		super();
	}
	
	//les methodes de l'Admin : ex supprimer un User, modifier un event, etc, a faire apres 
}
