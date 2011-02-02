package session;
import java.util.List;
import javax.ejb.Local;

import entity.Employee;
import entity.Project;

@Local
public interface ProjService {
	public List<Project> projectsByEmp(int empId);
	public List<Project> findAll();
	public Project findById(int projectId);
	public void assignEmployeeProject(int projectId, int empId);
}
