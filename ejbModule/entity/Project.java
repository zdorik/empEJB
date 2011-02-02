package entity;

import java.util.List;
import javax.persistence.*;

@Entity
public class Project {
	
	@Id
	private int id;
	private String name;
	@ManyToMany(mappedBy="projects")
	private List<Employee> employees;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

}
