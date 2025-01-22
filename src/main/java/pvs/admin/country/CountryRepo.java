package pvs.admin.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<CountryEntity, Integer> {

	public boolean existsByAllIgnoreCaseCountryName(String country);
	
	public boolean existsByAllIgnoreCaseCountryCode(String code);
	
	public boolean existsByAllIgnoreCaseCountryCurrency(String currency);
	
	@Query(value = "SELECT COUNT(*) FROM tbl_country WHERE id != :id and country = :country", nativeQuery = true)
	long updateIdAndCountry(@Param("id") long id,@Param("country") String country);
	
	@Query(value = "SELECT COUNT(*) FROM tbl_country WHERE id != :id and code= :code", nativeQuery = true)
	long updateIdAndCode(@Param("id") long id,@Param("code") String code);
	
	@Query(value = "SELECT COUNT(*) FROM tbl_country WHERE id != :id and currency = :currency", nativeQuery = true)
	long updateIdAndCurrency(@Param("id") long id,@Param("currency") String currency);
	
	
	
}
