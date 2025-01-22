package pvs.admin.city;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CityServiceImpl implements ICityService {

	@Autowired
	CityRepo cityrepo;
	
	@Override
	public List<CityEntity> getAllColumns() {
		List<CityEntity> list = cityrepo.findAll();
		return list;
	}

	@Override
	public CityEntity addCity(CityEntity c) {
		CityEntity city = cityrepo.save(c);    //upsert
		return city;
	}

	@Override
	public CityEntity getCityById(Integer id) {
		Optional<CityEntity> optional = cityrepo.findById(id);
		if(optional.isPresent()) {
			CityEntity city = optional.get();
			return city;
		}
		return null;
	}

	@Override
	public void deleteCity(Integer id) {
		cityrepo.deleteById(id);

	}

	@Override
	public boolean checkCityName(String name) {
		boolean b = cityrepo.existsByAllIgnoreCaseCityName(name);
		return b;
	}

	@Override
	public boolean checkCityAndId(long id, String city) {
		long l = cityrepo.updateIdAndCity(id, city);
		if(l>0) {
			return true;
		}
		return false;
	}

}
