package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Employee;
import entity.ParkingSpace;

@Stateless
public class ParkingServiceBean implements ParkingService {
	
	@PersistenceContext(unitName="personnelDepartment")
	private EntityManager em;
	
	public List<ParkingSpace> findAll() {
		return em.createQuery("SELECT ps FROM ParkingSpace ps").getResultList();
	}
	
	public ParkingSpace findById(int parkingSpaceId) {
		return em.find(ParkingSpace.class, parkingSpaceId); 
	}

	public void updateParkingSpace(ParkingSpace ps) {
		if (findById(ps.getId()) == null) {
			throw new IllegalArgumentException("Unknown parking space" + ps.getId());
		}
		em.merge(ps);
	}	

}
