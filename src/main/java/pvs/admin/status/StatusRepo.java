package pvs.admin.status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StatusRepo extends JpaRepository<StatusEntity,Integer > {

	public boolean existsByAllIgnoreCaseStatusName(String statusname);
	
	public boolean existsByAllIgnoreCaseStatusCode(String statuscode);
	
	public boolean existsByAllIgnoreCaseStatusModule(String statusModule);
	
	public boolean existsById(Integer id);
	
    @Query(value = "SELECT COUNT(*) FROM tbl_status WHERE id != :id AND status = :statusName", nativeQuery = true)
    long updateDuplicateName(@Param("id") long id, @Param("statusName") String statusName);

    @Query(value = "SELECT COUNT(*) FROM tbl_status WHERE id != :id AND code = :statusCode", nativeQuery = true)
    long updateDuplicateCode(@Param("id") long id, @Param("statusCode") String statusCode);

    @Query(value = "SELECT COUNT(*) FROM tbl_status WHERE id != :id AND module = :statusModule", nativeQuery = true)
    long updateDuplicateModule(@Param("id") long id, @Param("statusModule") String statusModule);
	
}
