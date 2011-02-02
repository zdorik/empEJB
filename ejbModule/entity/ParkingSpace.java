package entity;

import javax.persistence.*;

@Entity
@Table(name="PARKING_SPACE")
public class ParkingSpace {
	
	@Id private int id;
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="EMP_ID")
	private Employee employee;
	private int lot;
	private String location;
	

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setLot(int lot) {
		this.lot = lot;
	}

	public int getLot() {
		return lot;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

}
