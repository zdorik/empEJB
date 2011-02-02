package session;
import java.util.List;

import javax.ejb.Local;

import entity.Employee;
import entity.Project;

@Local
public interface EmpService {
	public List<Employee> findAll();
	public Employee addEmployee(Employee emp);
	public void deleteEmployee(int empId);
	public void updateEmployee(Employee emp);
	public Employee findById(int empId);
	public List<Employee> findEmpWithoutParking();
	public List<Employee> findEmpForProject(int projectId);
}
