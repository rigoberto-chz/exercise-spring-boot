package com.example.h2.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity(name = "teachers")
@Table(name = "TEACHERS")
public class Teachers implements Serializable {
	
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
	
	@ManyToMany(mappedBy="teachers", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Students> students;
	
	public Teachers() {
		super();
	}

	public Teachers(Long id) {
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Students> getStudents() {
		return students;
	}


	public void setStudents(List<Students> students) {
		this.students = students;
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teachers other = (Teachers) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(students, other.students);
	}

	@Override
	public String toString() {
		return "Teachers [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", students=" + students + "]";
	}

}
