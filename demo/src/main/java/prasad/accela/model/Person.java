package prasad.accela.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue
	private Integer id;
	private String firstName;
	private String surname;

	public Person() {
	}

	public Person(Integer id, String firstName, String surname) {
		this.id = id;
		this.firstName = firstName;
		this.surname = surname;
	}

	public Person(String firstName, String surname) {
		this.firstName = firstName;
		this.surname = surname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
