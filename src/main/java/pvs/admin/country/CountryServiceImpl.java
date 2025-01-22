package pvs.admin.country;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements ICountryService {

	@Autowired
	CountryRepo countryrepo;
	
	@Override
	public List<CountryEntity> getAllColumns() {
		List<CountryEntity> list = countryrepo.findAll();
		return list;
	}

	@Override
	public CountryEntity addCountry(CountryEntity c) {
		CountryEntity country = countryrepo.save(c);
		return country;
	}

	@Override
	public CountryEntity getCountryById(Integer id) {
		Optional<CountryEntity> optional = countryrepo.findById(id);
		if(optional.isPresent()){
			CountryEntity country = optional.get();
			return country;
		}
		return null;
	}

	@Override
	public void deleteCountry(Integer id) {
		countryrepo.deleteById(id);
	}

	@Override
	public boolean checkCountryName(String name) {
		boolean b = countryrepo.existsByAllIgnoreCaseCountryName(name);
		return b;
	}

	@Override
	public boolean checkCountryCode(String code) {
		boolean b = countryrepo.existsByAllIgnoreCaseCountryCode(code);
		return b;
	}

	@Override
	public boolean checkCountryCurrency(String currency) {
		boolean b = countryrepo.existsByAllIgnoreCaseCountryCurrency(currency);
		return b;
	}

	@Override
	public boolean checkIdAndCountry(long id, String name) {
		long l = countryrepo.updateIdAndCountry(id, name);
		if(l>0) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean checkIdAndCode(long id, String code) {
		long l = countryrepo.updateIdAndCode(id, code);
		if(l>0) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean checkIdAndCurrency(long id, String currency) {
		long l = countryrepo.updateIdAndCurrency(id, currency);
		if(l>0) {
			return true;
		}
		
		return false;
	}

}
