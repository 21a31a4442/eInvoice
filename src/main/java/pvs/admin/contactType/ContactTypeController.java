package pvs.admin.contactType;

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

import pvs.admin.status.IStatusService;
import pvs.admin.status.StatusEntity;

@Controller
@RequestMapping("/contact-type")

public class ContactTypeController {

	@Autowired
	IContactTypeService ctypeservice;

	@Autowired
	IStatusService statusservice;

	@GetMapping("")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView ctypeReport() {
		ModelAndView mav = new ModelAndView();
		List<ContactTypeEntity> list = ctypeservice.getAllColumns();
		mav.addObject("ctypes", list);

		mav.addObject("page", "/admin/contact_type/ctype-info");
		mav.setViewName("/admin/admin-page");

		return mav;
	}

	@GetMapping("/add-ctype")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView addCtype() {
		ModelAndView mav = new ModelAndView();

		List<StatusEntity> list = statusservice.getAllColumns();
		mav.addObject("status", list);

		ContactTypeEntity ctype = new ContactTypeEntity();
		mav.addObject("ctype", ctype);

		mav.addObject("page", "/admin/contact_type/add-ctype");
		mav.setViewName("/admin/admin-page");

		return mav;
	}

	@PostMapping("/save")
	public ModelAndView saveCtypeData(@ModelAttribute ContactTypeEntity ctype) {
		ModelAndView mav = new ModelAndView();

		boolean hasErrors = false;

		mav.addObject("ctype", ctype);
		if (ctypeservice.checkCTypeName(ctype.getName())) {
			hasErrors = true;
			mav.addObject("ctypeNameError", "Duplicate Record!");
		}

		if (hasErrors) {
			mav.addObject("page", "/admin/contact_type/add-ctype");
			mav.setViewName("/admin/admin-page");
			return mav;
		}

		ctypeservice.addCType(ctype);

		mav.setViewName("redirect:/contact-type");
		return mav;
	}

	@GetMapping("/update-ctype")
	public ModelAndView showUpdatePage(@RequestParam int id) {

		ModelAndView mav = new ModelAndView();
		List<StatusEntity> list = statusservice.getAllColumns();

		ContactTypeEntity ctype = ctypeservice.getCTypeById(id);
		mav.addObject("ctype", ctype);
		
		mav.addObject("status",list);

		mav.addObject("page", "/admin/contact_type/update-ctype");
		mav.setViewName("/admin/admin-page");

		return mav;

	}

	@PostMapping("/update")
	public ModelAndView updateCtype(@ModelAttribute("ctype") ContactTypeEntity ctype) {

		ModelAndView mav = new ModelAndView();

		boolean hasErrors = false;

		if (ctypeservice.checkCtypeNameAndId(ctype.getId(), ctype.getName())) {
			hasErrors = true;
			mav.addObject("ctypeNameError", "Duplicate Record");
		}

		if (hasErrors) {
			mav.addObject("page", "/admin/contact_type/update-ctype");
			mav.setViewName("/admin/admin-page");
			return mav;
		}

		ctypeservice.addCType(ctype);
		mav.setViewName("redirect:/contact-type");
		return mav;

	}
}
