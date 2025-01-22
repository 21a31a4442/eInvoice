package pvs.admin.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserInfoRepo extends JpaRepository<UserInfoEntity,Integer> {

	
	Optional<UserInfoEntity> findByUsername(String username);
	
	
}
