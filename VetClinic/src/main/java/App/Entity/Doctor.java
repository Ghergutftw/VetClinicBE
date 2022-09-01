package App.Entity;

import javax.persistence.*;
@Entity
@Table(name="doctor")
public class Doctor {

	// define fields

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable = false)
	private int id;


	@Column(name="first_name")
	private String firstName;


	@Column(name="last_name")
	private String lastName;

	@OneToOne(cascade=CascadeType.ALL)
	private User user;

	@Column (name = "speciality")
	private String speciality;

	@Column (name = "age")
	private int age;

	@Column (name ="years_of_experience")
	private int yearsOfExperience;


	public Doctor(int id, String firstName, String lastName, User user, String speciality, int age, int yearsOfExperience) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.user = user;
		this.speciality = speciality;
		this.age = age;
		this.yearsOfExperience = yearsOfExperience;
	}

	public Doctor() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	@Override
	public String toString() {
		return "Doctor{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", user=" + user +
				", speciality='" + speciality + '\'' +
				", age=" + age +
				", yearsOfExperience=" + yearsOfExperience +
				'}';
	}
}











