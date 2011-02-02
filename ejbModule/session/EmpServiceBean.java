package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Employee;
import entity.Project;


@Stateless
public class EmpServiceBean implements EmpService {

	@PersistenceContext(unitName="personnelDepartment")
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Employee> findAll() {
		return em.createQuery("SELECT e FROM Employee e").getResultList();
	}
	
	public Employee addEmployee(Employee emp) {
		em.persist(emp);
		return emp; 
	}
	
	public void deleteEmployee(int empId) {
		Employee emp = findById(empId);
		if (emp != null) {
			em.remove(emp);
		}
	}
	
	public void updateEmployee(Employee emp) {
		if (findById(emp.getId()) == null) {
			throw new IllegalArgumentException("Unknown employee" + emp.getId());
		}
		em.merge(emp);
	}
	
	public Employee findById(int empId) {
		return em.find(Employee.class, empId); 
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Employee>  findEmpWithoutParking() {
		return em.createQuery("SELECT e FROM Employee e WHERE e.parkingSpace IS EMPTY").getResultList();
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Employee>  findEmpForProject(int projectId) {
		return em.createNamedQuery("Employee.findEmpForProject")
				 .setParameter("projectId", projectId)
				 .getResultList();
	}	
}
