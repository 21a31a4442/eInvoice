package pvs.admin.designation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepo extends JpaRepository<DesignationEntity, Integer> {
	
	public boolean existsByAllIgnoreCasedesnName(String desn_name);
	
	public boolean existsByAllIgnoreCasedesnCode(String desn_code);
	
	@Query(value = "SELECT COUNT(*) FROM tbl_designation WHERE id!= :id AND name = :desnName",nativeQuery = true)
	long updateIdAndDesnName(@Param("id") long id,@Param("desnName") String desnName);
	
	@Query(value = "SELECT COUNT(*) FROM tbl_designation WHERE id!= :id AND code = :desnCode",nativeQuery = true)
	long updateIdAndDesnCode(@Param("id") long id,@Param("desnCode") String desnCode);

}
