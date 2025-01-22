package pvs.admin.ccType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CcTypeRepo extends JpaRepository<CostCenterTypeEntity, Integer> {

//	boolean existsByAllIgnoreCaseCcType(String cc_type);
	
//	@Query(value = "SELECT COUNT(*) > 0 FROM tbl_costcentertype WHERE REPLACE(cc_type , '-','') = :ccType",nativeQuery = true)
//	boolean existsByCcTypeIgnoreCase(@Param("ccType") String ccType); //normalise the parameter in the service layer 
	
	@Query(value = "SELECT COUNT(*) > 0 FROM tbl_costcentertype WHERE REPLACE(REPLACE(LOWER(cc_type), '-', ''), ' ', '') = LOWER(REPLACE(REPLACE(:ccType, '-', ''), ' ', ''))", nativeQuery = true)
	long existsByCcTypeIgnoreCase(@Param("ccType") String ccType); // normalise the parameter in the query itself (repo layer)
	
//	 @Query(value = "SELECT COUNT(*) > 0 FROM tbl_costcentertype WHERE REPLACE(REPLACE(REPLACE(LOWER(cc_type), '-', ''), ' ', ''), '[^a-zA-Z0-9]', '') = LOWER(REPLACE(REPLACE(REPLACE(:ccType, '-', ''), ' ', ''), '[^a-zA-Z0-9]', ''))", nativeQuery = true)
//	    long existsByCcTypeIgnoreCase(@Param("ccType") String ccType); //the	 query removes all the special characters between the words including spaces 

	
	@Query(value = "SELECT COUNT(*) FROM tbl_costcentertype WHERE id != :id AND cc_type = :cctype",nativeQuery = true)
	long updateDuplicateName(@Param("id") long id,@Param("cctype") String cctype);
}
