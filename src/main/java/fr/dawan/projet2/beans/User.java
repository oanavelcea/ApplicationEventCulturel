package fr.dawan.projet2.beans;

import static javax.persistence.EnumType.STRING;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user", uniqueConstraints=@UniqueConstraint(columnNames= {"lastName", "firstName", "sex", "email", "password"})) 
@Inheritance(strategy=InheritanceType.JOINED) //A voir si cést bien Joined !!!
public class User extends Record implements Serializable {
	
	@Column(name = "lastName", length = 55, nullable = false)
	private String lastName;
	@Column(name = "firstName", length = 55, nullable = false)
	private String firstName;	
	@Enumerated(STRING)
	private Genre genre;
	@Column(name = "email", length = 100, nullable = false)
	private String email;
	@Column(name = "password", length = 55, nullable = false)
	private String password;
	

	public User() {

	}

	public User(String lastName, String firstName, Genre genre, String email, String password) {
		// super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.genre = genre;
		this.email = email;
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(char sex) {
		this.genre = genre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [lastName=" + lastName + ", firstName=" + firstName + ", genre=" + genre + ", email=" + email
				+ ", password=" + password + "]";
	}

	//besoin equals et hashcode?
}
