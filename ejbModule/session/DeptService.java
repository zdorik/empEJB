package session;
import java.util.List;
import javax.ejb.Local;
import entity.Department;

@Local
public interface DeptService {
	public List<Department> findAll();
	public Department findById(int deptId);
}
