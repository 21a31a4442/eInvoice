package pvs.admin.department;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	DepartmentRepo deptrepo;
	
	
	@Override
	public List<DepartmentEntity> getAllColumns() {
		List<DepartmentEntity> list = deptrepo.findAll();
		return list;
	}

	@Override
	public DepartmentEntity addDept(DepartmentEntity d) {
		DepartmentEntity department = deptrepo.save(d);
		return department;
	}

	@Override
	public DepartmentEntity getDeptById(Integer id) {
		Optional<DepartmentEntity> optional = deptrepo.findById(id);
		if(optional.isPresent()) {
			DepartmentEntity dept = optional.get();
			return dept;
		}
		return null;
	}

	@Override
	public void deleteDept(Integer id) {
		deptrepo.deleteById(id);
	}

	@Override
	public boolean checkDeptName(String dept_name) {
		boolean b = deptrepo.existsByAllIgnoreCaseDeptName(dept_name);
		return b;
	}

	@Override
	public boolean checkDeptCode(String dept_code) {
		boolean b = deptrepo.existsByAllIgnoreCaseDeptCode(dept_code);
		return b;
	}

	@Override
	public boolean checkDeptNameAndId(long id, String deptName) {
		long l = deptrepo.updateIdAndDeptName(id, deptName);
		if(l>0) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean checkDeptCodeAndId(long id, String deptCode) {
		long l = deptrepo.updateIdAndDeptCode(id, deptCode);
		if(l>0) {
			return true;
		}
		
		return false;
	}

	
}
