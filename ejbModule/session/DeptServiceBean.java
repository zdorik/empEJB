package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entity.Department;
import entity.Employee;


@Stateless
public class DeptServiceBean implements DeptService {

	@PersistenceContext(unitName="personnelDepartment")
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Department> findAll() {
		return em.createQuery("SELECT d FROM Department d").getResultList();
	}
	
	public Department findById(int deptId) {
		return em.find(Department.class, deptId); 
	}	

}
