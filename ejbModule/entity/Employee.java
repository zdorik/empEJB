package entity;

import java.util.List;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Employee.findEmpForProject", 
			query = "SELECT e " +
					"FROM Employee e " +
					"WHERE NOT EXISTS (SELECT p FROM e.projects p WHERE p.id = :projectId)")	
})

public class Employee {

	@Id private int id;
	@ManyToOne
	@JoinColumn(name="DEPT_ID")
	private Department department;
	@ManyToMany
	@JoinTable(name="EMP_PROJ",
		joinColumns=@JoinColumn(name="EMP_ID"), 
		inverseJoinColumns=@JoinColumn(name="PROJ_ID"))
	private List<Project> projects;
	@OneToOne(mappedBy="employee")
	private ParkingSpace parkingSpace;
	private String name;
	private long salary;
	
	public Employee() {}
	public Employee(int id) { this.id = id; }
	
	public int getId() { 
		return id; 
	}
	public void setId(int id) { 
		this.id = id; 
	}
	public String getName() { 
		return name; 
	}
	public void setName(String name) { 
		this.name = name; 
	}
	public long getSalary() { 
		return salary; 
	}
	public void setSalary (long salary) { 
		this.salary = salary; 
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Department getDepartment() {
		return department;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}
	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}	

}
