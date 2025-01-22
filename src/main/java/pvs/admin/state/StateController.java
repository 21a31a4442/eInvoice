package pvs.admin.state;

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


@Controller
@RequestMapping("/state")
public class StateController {

	
	@Autowired
	IStateService stateservice;

	@Autowired
	ICountryService countryservice;

	@GetMapping("")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView stateReport() {
		ModelAndView mav = new ModelAndView();
		List<StateEntity> list = stateservice.getAllColumns();
		mav.addObject("states", list);

		mav.addObject("page", "/admin/state/state-info");
		mav.setViewName("/admin/admin-page");

		return mav;
	}

	@GetMapping("/add-state")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView addState() {
		ModelAndView mav = new ModelAndView();

		List<CountryEntity> list = countryservice.getAllColumns();
		mav.addObject("countries", list);

		StateEntity state = new StateEntity();
		mav.addObject("state", state);

		mav.addObject("page", "/admin/state/add-state");
		mav.setViewName("/admin/admin-page");

		return mav;
	}

	@PostMapping("/save")
	public ModelAndView saveStateData(@ModelAttribute StateEntity state) {
		ModelAndView mav = new ModelAndView();

		boolean hasErrors = false;

		mav.addObject("state", state);
		if (stateservice.checkStateName(state.getStateName())) {
			hasErrors = true;
			mav.addObject("stateNameError", "Duplicate Record!");
		}

		if (hasErrors) {
			mav.addObject("page", "/admin/state/add-state");
			mav.setViewName("/admin/admin-page");
			return mav;
		}

		stateservice.addState(state);

		mav.setViewName("redirect:/state");
		return mav;
	}

	@GetMapping("/update-state")
	public ModelAndView showUpdatePage(@RequestParam int id) {

		ModelAndView mav = new ModelAndView();
		List<CountryEntity> list = countryservice.getAllColumns();

		StateEntity state = stateservice.getStateById(id);
		mav.addObject("state", state);
		
		mav.addObject("countries",list);

		mav.addObject("page", "/admin/state/update-state");
		mav.setViewName("/admin/admin-page");

		return mav;

	}

	@PostMapping("/update")
	public ModelAndView updateState(@ModelAttribute("state") StateEntity state) {

		ModelAndView mav = new ModelAndView();

		boolean hasErrors = false;

		if (stateservice.checkStateNameAndId(state.getId(), state.getStateName())) {
			hasErrors = true;
			mav.addObject("stateNameError", "Duplicate Record");
		}

		if (hasErrors) {
			mav.addObject("page", "/admin/state/update-state");
			mav.setViewName("/admin/admin-page");
			return mav;
		}

		stateservice.addState(state);
		mav.setViewName("redirect:/state");
		return mav;

	}
}
