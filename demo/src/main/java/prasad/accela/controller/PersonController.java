package prasad.accela.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import prasad.accela.model.Person;
import prasad.accela.repository.PersonRepository;

@Controller
@ConditionalOnProperty(name = "demo.db.recreate", havingValue = "false")
public class PersonController implements CommandLineRunner {

	private PersonRepository personRepository;

	public PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		this.menu();
	}

	public void menu() {
		int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose from the menu "
				+ "\n 1. Add Person \n 2. Edit Person \n 3. Delete Person \n 4. Count of Persons "
				+ "\n 5. List of Persons \n 6. Exit"));

		switch (choice) {

		case 1:
			addPerson();
			menu();
			break;

		case 2:
			editPerson();
			menu();
			break;

		case 3:
			deletePerson();
			menu();
			break;
			
		case 4:
			showPersonCount();
			menu();
			break;
			
		case 5:
			viewAllPersons();
			menu();
			break;
			
		default:
			break;
		}
	}

	private void addPerson() {
		String firstName = JOptionPane.showInputDialog(null, "Enter first name");
		String surName = JOptionPane.showInputDialog(null, "Enter last name");
		Person person = new Person(firstName, surName);
		this.personRepository.save(person);
	}
	
	private void editPerson() {
		int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the ID of Person to edit"));
		String firstName = JOptionPane.showInputDialog(null, "Enter first name");
		String surName = JOptionPane.showInputDialog(null, "Enter last name");
		Person modifiedPerson = new Person(id,firstName, surName);
		this.personRepository.save(modifiedPerson);
	}
	
	private void deletePerson() {
		int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the ID of Person to delete"));
		this.personRepository.deleteById(id);
		JOptionPane.showMessageDialog(null, "Person with id:" + id + "has been deleted");
	}

	private void viewAllPersons() {
		List<Person> persons = this.personRepository.findAll();
		String message = "";
		for (Person person : persons) {
			message = message + person.getId() + "  ";
			message = message + person.getFirstName() + "  ";
			message = message + person.getSurname() + "  ";
			message = message + "\n";
		}
		JOptionPane.showMessageDialog(null, message);
	}

	private void showPersonCount() {
		List<Person> persons = this.personRepository.findAll();
		JOptionPane.showMessageDialog(null, "Person Count: " + persons.size());
	}
}
