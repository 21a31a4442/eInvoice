package pvs.admin.designation;

import java.util.List;

import pvs.admin.department.DepartmentEntity;

public interface IDesignationService {

	List<DesignationEntity> getAllColumns();
	
	DesignationEntity addDesn(DesignationEntity d);
	
	DesignationEntity getDesnById(Integer id);
	
	void deleteDesn(Integer id);
	
	boolean checkDesnName(String desn_name);
	
	boolean checkDesnCode(String desn_code);
	
	boolean checkDesnNameAndId(long id,String desnName);
	
	boolean checkDesnCodeAndId(long id,String desnCode);

	
}
