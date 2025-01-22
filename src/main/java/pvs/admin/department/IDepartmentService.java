package pvs.admin.department;

import java.util.List;

public interface IDepartmentService{

	List<DepartmentEntity> getAllColumns();
	
	DepartmentEntity addDept(DepartmentEntity d);
	
	DepartmentEntity getDeptById(Integer id);
	
	void deleteDept(Integer id);
	
	boolean checkDeptName(String dept_name);
	
	boolean checkDeptCode(String dept_code);
	
	boolean checkDeptNameAndId(long id,String deptName);
	
	boolean checkDeptCodeAndId(long id, String deptCode);
	
}
