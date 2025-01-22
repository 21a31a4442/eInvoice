package pvs.admin.state;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StateRepo extends JpaRepository<StateEntity, Integer> {

	boolean existsByAllIgnoreCaseStateName(String state);
	
	@Query(value = "SELECT COUNT(*) FROM tbl_state WHERE id!= :id AND state = :state",nativeQuery = true)
	long updateIdAndState(@Param("id") long id,@Param("state") String state);
	
}
