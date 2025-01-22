package pvs.admin.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Integer> {

	
	public boolean existsByAllIgnoreCaseDeptName(String dept_name);
	
	public boolean existsByAllIgnoreCaseDeptCode(String dept_code);
	
	@Query(value = "SELECT COUNT(*) FROM tbl_department WHERE id!= :id AND name = :deptName",nativeQuery = true)
	long updateIdAndDeptName(@Param("id") long id,@Param("deptName") String deptName);
	
	@Query(value = "SELECT COUNT(*) FROM tbl_department WHERE id!= :id AND code = :deptCode",nativeQuery = true)
	long updateIdAndDeptCode(@Param("id") long id,@Param("deptCode") String deptCode);
	
	
}
