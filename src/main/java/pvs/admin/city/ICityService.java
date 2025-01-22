package pvs.admin.city;

import java.util.List;

public interface ICityService {

	List<CityEntity> getAllColumns();
	
	CityEntity addCity(CityEntity c);
	
	CityEntity getCityById(Integer id);
	
	void deleteCity(Integer id);
	
	boolean checkCityName(String name);
	
	boolean checkCityAndId(long id,String city);
	
}
