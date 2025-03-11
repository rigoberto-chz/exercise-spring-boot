package com.example.h2.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity(name="students")
@Table(name = "STUDENTS")
public class Students implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	@Column(name="FIRST_NAME", length=45)
    private String firstName;
    
	@Column(name="LAST_NAME", length=45)
    private String lastName;
	
	@Column(name="EMAIL", length=100)
	private String email;
	
	@ManyToMany
	@JoinTable(
		name = "STUDENTS_TEACHERS",
		joinColumns = @JoinColumn(name = "ID_STUDENTS", referencedColumnName="ID"),
		inverseJoinColumns = @JoinColumn(name = "ID_TEACHERS", referencedColumnName="ID")
	)
	private List<Teachers> teachers;
	
	
	public Students() {
		super();
	}

	public Students(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public List<Teachers> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teachers> teachers) {
		this.teachers = teachers;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, teachers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Students other = (Students) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(teachers, other.teachers);
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", teachers=" + teachers + "]";
	}
	
}
