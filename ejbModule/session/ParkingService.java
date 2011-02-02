package session;
import java.util.List;

import javax.ejb.Local;

import entity.Employee;
import entity.ParkingSpace;

@Local
public interface ParkingService {
	public List<ParkingSpace> findAll();
	public void updateParkingSpace (ParkingSpace ps);
	public ParkingSpace findById(int parkingSpaceId);
}
