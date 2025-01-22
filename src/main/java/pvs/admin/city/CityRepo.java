package pvs.admin.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends JpaRepository<CityEntity, Integer> {

	boolean existsByAllIgnoreCaseCityName(String city); 
	
	@Query(value = "SELECT COUNT(*) FROM tbl_city WHERE id!= :id AND city = :city",nativeQuery = true)
	long updateIdAndCity(@Param("id") long id,@Param("city") String city);
	
	
}
