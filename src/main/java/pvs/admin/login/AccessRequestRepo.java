package pvs.admin.login;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRequestRepo extends JpaRepository<AccessRequestEntity, Integer> {

	Optional<AccessRequestEntity> findById(Long id);
	
	List<AccessRequestEntity> findByStatus(String status);
	
}
