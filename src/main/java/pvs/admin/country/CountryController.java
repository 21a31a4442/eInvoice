package pvs.admin.country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/country")
public class CountryController {

	@Autowired
	ICountryService countryservice;

	@GetMapping("")
	public ModelAndView countryReport() {
		ModelAndView mav = new ModelAndView();

		List<CountryEntity> list = countryservice.getAllColumns();

		mav.addObject("countries", list);

		mav.addObject("page", "/admin/country/country-info");
		mav.setViewName("/admin/admin-page");

		return mav;
	}

	@GetMapping("/add-country")
	public ModelAndView addCountry() {
		ModelAndView mav = new ModelAndView();

		CountryEntity entity = new CountryEntity();
		mav.addObject("country", entity);

		mav.addObject("page", "/admin/country/add-country");
		mav.setViewName("/admin/admin-page");

		return mav;
	}

	@PostMapping("/save")
	public ModelAndView saveData(@ModelAttribute CountryEntity country) {

		ModelAndView mav = new ModelAndView();

		boolean hasErrors = false;

		mav.addObject("country", country);
		
		if (countryservice.checkCountryName(country.getCountryName())) {
			hasErrors = true;
			mav.addObject("CountryNameError", "Duplicate Record!");
		}if (countryservice.checkCountryCode(country.getCountryCode())) {
			hasErrors = true;
			mav.addObject("CountryCodeError", "Duplicate Record!");
		}if (countryservice.checkCountryCurrency(country.getCountryCurrency())) {
			hasErrors = true;
			mav.addObject("CountryCurrencyError", "Duplicate Record!");
		}
		

		if (hasErrors) {
			mav.addObject("page", "/admin/country/add-country");
			mav.setViewName("/admin/admin-page");
			return mav;
		}

		countryservice.addCountry(country);

		mav.setViewName("redirect:/country");
		return mav;
	}

	@GetMapping("/update-country")
	public ModelAndView editCountry(@RequestParam int id) {
		ModelAndView mav = new ModelAndView();

		CountryEntity country = countryservice.getCountryById(id);
		mav.addObject("country", country);

		mav.addObject("page", "/admin/country/update-country");
		mav.setViewName("/admin/admin-page");

		return mav;
	}
	
	@PostMapping("/update")
	public ModelAndView updateCountry(@ModelAttribute("country") CountryEntity country) {
		
		ModelAndView mav = new ModelAndView();
		
		 System.out.println("Country ID: " + country.getId());
//		    System.out.println("Country Name: " + country.getCountry());
		    System.out.println("Country Code: " + country.getCountryCode());
		    System.out.println("Country Currency: " + country.getCountryCurrency());
		
		boolean hasErrors = false;
		
		if(countryservice.checkIdAndCountry(country.getId(), country.getCountryName())) {
			hasErrors = true;
			mav.addObject("CountryNameError","Duplicate record!");
		}if(countryservice.checkIdAndCode(country.getId(), country.getCountryCode())) {
			hasErrors = true;
			mav.addObject("CountryCodeError","Duplicate record!");
		}if(countryservice.checkIdAndCurrency(country.getId(), country.getCountryCurrency())) {
			hasErrors = true;
			mav.addObject("CountryCurrencyError","Duplicate record!");
		}
		
		if(hasErrors) {
			mav.addObject("page", "/admin/country/update-country");
			mav.setViewName("/admin/admin-page");
			return mav;
		}
		
		countryservice.addCountry(country);
		
		mav.setViewName("redirect:/country");
		return mav;
	}

	
}
