package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Employee;
import entity.Project;

@Stateless
public class ProjServiceBean implements ProjService {
	
	@PersistenceContext(unitName="personnelDepartment")
	private EntityManager em;	

	public List<Project> projectsByEmp(int empId) {
		Employee emp = em.find(Employee.class, empId);
		return emp.getProjects();
	}
	
	public List<Project> findAll() {
		return em.createQuery("SELECT p FROM Project p").getResultList();
	}
	
	public Project findById(int projectId) {
		return em.find(Project.class, projectId); 
	}
	
	public void assignEmployeeProject(int projectId, int empId) {
			Employee emp = em.find(Employee.class, empId);
			Project project = em.find(Project.class, projectId);
			project.getEmployees().add(emp);
			emp.getProjects().add(project);
			em.merge(emp);
	}	
}
