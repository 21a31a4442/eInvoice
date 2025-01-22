package pvs.admin.ccType;

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
@RequestMapping("/costcentertype")
public class CcTypeController {

	@Autowired
	ICcTypeService cctypeservice;

	@GetMapping("")
	public ModelAndView ccTypeReport() {
		ModelAndView mav = new ModelAndView();

		List<CostCenterTypeEntity> list = cctypeservice.getAllColumns();

		mav.addObject("cctypes", list);

		mav.addObject("page", "/admin/costcenter_type/cctype-info");
		mav.setViewName("/admin/admin-page");

		return mav;
	}

	@GetMapping("/add-cctype")
	public ModelAndView addCcType() {
		ModelAndView mav = new ModelAndView();

		CostCenterTypeEntity entity = new CostCenterTypeEntity();
		mav.addObject("cctype", entity);

		mav.addObject("page", "/admin/costcenter_type/add-cctype");
		mav.setViewName("/admin/admin-page");

		return mav;
	}

	@PostMapping("/save")
	public ModelAndView saveData(@ModelAttribute CostCenterTypeEntity cctype) {

		ModelAndView mav = new ModelAndView();

		boolean hasErrors = false;

		mav.addObject("cctype", cctype);
		if (cctypeservice.checkCcTypeName(cctype.getCc_type())) {
			hasErrors = true;
			mav.addObject("CctypeNameError", "Duplicate Record!");

		}

		if (hasErrors) {
			mav.addObject("page", "/admin/costcenter_type/add-cctype");
			mav.setViewName("/admin/admin-page");
			return mav;
		}

		cctypeservice.addCcType(cctype);

		mav.setViewName("redirect:/costcentertype");
		return mav;
	}

	@GetMapping("/update-cctype")
	public ModelAndView editCcType(@RequestParam int id) {
		ModelAndView mav = new ModelAndView();

		CostCenterTypeEntity cctype = cctypeservice.getCcTypeById(id);
		mav.addObject("cctype", cctype);

		mav.addObject("page", "/admin/costcenter_type/update-cctype");
		mav.setViewName("/admin/admin-page");

		return mav;
	}
	
	@PostMapping("/update")
	public ModelAndView updateCctype(@ModelAttribute("cctype") CostCenterTypeEntity cctype) {
		
		ModelAndView mav = new ModelAndView();
		
		boolean hasErrors = false;
		
		if(cctypeservice.checkIdAndCctypeName(cctype.getId(), cctype.getCc_type())) {
			hasErrors = true;
			mav.addObject("CctypeNameError","Duplicate record!");
		}
		if(hasErrors) {
			mav.addObject("page","/admin/costcenter_type/update-cctype");
			mav.setViewName("/admin/admin-page");
			return mav;
		}
		
		cctypeservice.addCcType(cctype);
		
		mav.setViewName("redirect:/costcentertype");
		return mav;
	}

}
