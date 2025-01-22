package pvs.admin.contactType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactTypeRepo extends JpaRepository<ContactTypeEntity, Integer> {
	
	boolean existsByAllIgnoreCaseName(String name);
	
	@Query(value="SELECT COUNT(*) FROM tbl_contacttype where id != :id AND name = :ctypeName",nativeQuery = true)
	long updateDuplicateName(@Param("id") long id,@Param("ctypeName") String ctypeName);

}
