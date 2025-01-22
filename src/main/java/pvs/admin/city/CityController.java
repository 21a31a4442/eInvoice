package pvs.admin.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pvs.admin.country.CountryEntity;
import pvs.admin.country.ICountryService;
import pvs.admin.state.IStateService;
import pvs.admin.state.StateEntity;

@Controller
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	ICityService cityservice;
	
	@Autowired
	ICountryService countryservice;
	
	@Autowired
	IStateService stateservice;
	
	@GetMapping("")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView cityReport() {
		ModelAndView mav = new ModelAndView();
		
		List<CityEntity> list = cityservice.getAllColumns();
		mav.addObject("cities", list);
		
		mav.addObject("page", "/admin/city/city-info");
		mav.setViewName("/admin/admin-page");

		return mav;
	}

	@GetMapping("/add-city")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView addCity() {
		ModelAndView mav = new ModelAndView();

		List<CountryEntity> country_list = countryservice.getAllColumns();
		mav.addObject("countries", country_list);
		
		List<StateEntity> state_list = stateservice.getAllColumns();
		mav.addObject("states", state_list);		

		CityEntity city = new CityEntity();
		mav.addObject("city", city);

		mav.addObject("page", "/admin/city/add-city");
		mav.setViewName("/admin/admin-page");

		return mav;
	}

	@PostMapping("/save")
	public ModelAndView saveCityData(@ModelAttribute CityEntity city) {
		ModelAndView mav = new ModelAndView();

		boolean hasErrors = false;

		mav.addObject("city", city);
		if (cityservice.checkCityName(city.getCityName())) {
			hasErrors = true;
			mav.addObject("cityNameError", "Duplicate Record!");
		}

		if (hasErrors) {
			mav.addObject("page", "/admin/city/add-city");
			mav.setViewName("/admin/admin-page");
			return mav;
		}

		cityservice.addCity(city);

		mav.setViewName("redirect:/city");
		return mav;
	}

	@GetMapping("/update-city")
	public ModelAndView showUpdatePage(@RequestParam int id) {

		ModelAndView mav = new ModelAndView();

		List<CountryEntity> countries_list = countryservice.getAllColumns();
		mav.addObject("countries", countries_list);
		
		List<StateEntity> states_list = stateservice.getAllColumns();
		mav.addObject("states", states_list);
		
		CityEntity city = cityservice.getCityById(id);
		mav.addObject("city", city);

		mav.addObject("page", "/admin/city/update-city");
		mav.setViewName("/admin/admin-page");

		return mav;

	}

	@PostMapping("/update")
	public ModelAndView updateCity(@ModelAttribute("city") CityEntity city) {

		ModelAndView mav = new ModelAndView();

		boolean hasErrors = false;
		
		
		
		if (cityservice.checkCityAndId(city.getId(), city.getCityName())) {
			hasErrors = true;
			mav.addObject("cityNameError", "Duplicate Record");
		}

		if (hasErrors) {
			List<CountryEntity> countries_list = countryservice.getAllColumns();
			mav.addObject("countries", countries_list);
			
			List<StateEntity> states_list = stateservice.getAllColumns();
			mav.addObject("states", states_list);
			
			mav.addObject("page", "/admin/city/update-city");
			mav.setViewName("/admin/admin-page");
			return mav;
		}

		cityservice.addCity(city);
		
		mav.setViewName("redirect:/city");
		return mav;

	}
}
