package pvs.admin.designation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/designation")
public class DesignationController {
	
	@Autowired
	IDesignationService desnservice;
	
	@Autowired
	IStatusService statusservice;

	@GetMapping("")
	public ModelAndView desnReport() {
		ModelAndView mav = new ModelAndView();

		List<DesignationEntity> list = desnservice.getAllColumns();

		mav.addObject("desns", list);

		mav.addObject("page", "/admin/designation/desn-info");
		mav.setViewName("/admin/admin-page");

		return mav;
	}

	@GetMapping("/add-desn")
	public ModelAndView addDesn() {
		ModelAndView mav = new ModelAndView();

		DesignationEntity entity = new DesignationEntity();
		mav.addObject("desn", entity);
		
		List<StatusEntity> list = statusservice.getAllColumns();
		mav.addObject("statuses",list);

		mav.addObject("page", "/admin/designation/add-desn");
		mav.setViewName("/admin/admin-page");

		return mav;
	}

	@PostMapping("/save")
	public ModelAndView saveData(@ModelAttribute DesignationEntity desn) {

		ModelAndView mav = new ModelAndView();

		boolean hasErrors = false;

		mav.addObject("desn", desn);
		if (desnservice.checkDesnName(desn.getDesnName())) {
			hasErrors = true;
			mav.addObject("DesnNameError", "Duplicate Record!");
		}if (desnservice.checkDesnCode(desn.getDesnCode())) {
			hasErrors = true;
			mav.addObject("DesnCodeError", "Duplicate Record!");
		}

		if (hasErrors) {
			List<StatusEntity> list = statusservice.getAllColumns();
			mav.addObject("statuses",list);
			
			mav.addObject("page", "/admin/designation/add-desn");
			mav.setViewName("/admin/admin-page");
			return mav;
		}

		desnservice.addDesn(desn);

		mav.setViewName("redirect:/designation");
		return mav;
	}

	@GetMapping("/update-desn")
	public ModelAndView editDesnType(@RequestParam int id) {
		ModelAndView mav = new ModelAndView();

		DesignationEntity desn = desnservice.getDesnById(id);
		mav.addObject("desn", desn);
		
		List<StatusEntity> list = statusservice.getAllColumns();
		mav.addObject("statuses",list);

		mav.addObject("page", "/admin/designation/update-desn");
		mav.setViewName("/admin/admin-page");

		return mav;
	}
	
	@PostMapping("/update")
	public ModelAndView updateDesn(@ModelAttribute("desn") DesignationEntity desn) {
		ModelAndView mav = new ModelAndView();
		
		boolean hasErrors = false;
		
		if(desnservice.checkDesnNameAndId(desn.getId(), desn.getDesnName())) {
			hasErrors = true;
			mav.addObject("desnNameError","Duplicate record!");
		}if(desnservice.checkDesnCodeAndId(desn.getId(), desn.getDesnCode())) {
			hasErrors = true;
			mav.addObject("desnCodeError","Duplicate record!");
		}
		if(hasErrors) {
			List<StatusEntity> list = statusservice.getAllColumns();
			mav.addObject("statuses",list);
			
			mav.addObject("page","/admin/designation/update-desn");
			mav.setViewName("/admin/admin-page");
			return mav;
		}
		
		desnservice.addDesn(desn);
		
		mav.setViewName("redirect:/designation");
		return mav;
	}

}
