package pvs.admin.country;

import java.util.List;

public interface ICountryService {

	List<CountryEntity> getAllColumns();
	
	CountryEntity addCountry(CountryEntity c);
	
	CountryEntity getCountryById(Integer id);
	
	void deleteCountry(Integer id);
	
	boolean checkCountryName(String name);
	
	boolean checkCountryCode(String code);
	
	boolean checkCountryCurrency(String currency);
	
	boolean checkIdAndCountry(long id, String name);
	
	boolean checkIdAndCode(long id, String code);
	
	boolean checkIdAndCurrency(long id, String currency);
	
}
