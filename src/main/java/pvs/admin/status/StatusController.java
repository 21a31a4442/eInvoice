package pvs.admin.status;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/status")
public class StatusController {

	@Autowired
	IStatusService statusservice;
	
	
	@GetMapping("")
//	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView statusReport() {
		ModelAndView mav = new ModelAndView();

		List<StatusEntity> list = statusservice.getAllColumns();

		mav.addObject("status", list);
		mav.setViewName("/admin/admin-page");
		mav.addObject("page", "/admin/status/status-info");

		return mav;
	}

	@GetMapping("/add-status")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView addStatus() {
		ModelAndView mav = new ModelAndView();

		StatusEntity s1 = new StatusEntity();
		mav.addObject("s1", s1);
		mav.setViewName("/admin/admin-page");
	    mav.addObject("page", "/admin/status/add-status");

		 

		return mav;
	}
	

	@PostMapping("/save")
	public String saveStatusData(@Valid @ModelAttribute StatusEntity s, BindingResult result, Model model) {

		boolean hasErrors = false;
		
		model.addAttribute("s1",s);
		if(statusservice.checkStatusName(s.getStatusName())) {
			 model.addAttribute("statusNameError", "Duplicate Status!!");
			 hasErrors = true;
		}
		if(statusservice.checkStatusCode(s.getStatusCode())) {
			model.addAttribute("statusCodeError", "Duplicate Code!!");
			hasErrors = true;
		}

		if(hasErrors) {
			model.addAttribute("page", "/admin/status/add-status");
			return "/admin/admin-page";
		}
		
		statusservice.addStatus(s);
		
		return "redirect:/status";
	 }

	
	@GetMapping("/update-status")
	public String showUpdatepage(@RequestParam int id,Model model) {

		StatusEntity status = statusservice.getStatusbyId(id);
		model.addAttribute("s1",status);
		model.addAttribute("page","/admin/status/update-status");
		return "/admin/admin-page";
	}
	
	@PostMapping("/update")
	public String updateStatus(@ModelAttribute("s1") StatusEntity status,Model model) {
		
		boolean hasErrors = false;
		
		if(statusservice.checkStatusNameAndId(status.getId(),status.getStatusName())) {
			 model.addAttribute("statusNameError", "Status Name Exists!!");
			 hasErrors = true;
		}
		if(statusservice.checkStatusCodeAndId(status.getId(),status.getStatusCode())) {
			 model.addAttribute("statusCodeError", "Status Code Exists!!");
			 hasErrors = true;
		}
		
		if(hasErrors) {
			model.addAttribute("page","/admin/status/update-status");
			return "/admin/admin-page";
		}
		
		statusservice.addStatus(status);
		
		return "redirect:/status";
		
	}

	@GetMapping("/delete-status/{id}")
	public ModelAndView deleteStatus(@PathVariable int id) {
		ModelAndView mav = new ModelAndView();

		statusservice.deleteStatus(id);

		List<StatusEntity> list = statusservice.getAllColumns();
		mav.addObject("status", list);
		mav.addObject("page", "/admin/status/status-info");
		mav.setViewName("/admin/admin-page");

		return mav;
	}
	
	@GetMapping("/add-status/validatename")
	@ResponseBody
	public boolean checkDuplicateName(@RequestParam String statusname) {
		boolean b = statusservice.checkStatusName(statusname);
		return b;
	}

	@GetMapping("/add-status/validatecode")
	@ResponseBody
	public boolean checkDuplicateCode(@RequestParam String statuscode) {
		return statusservice.checkStatusCode(statuscode);
	}

	@GetMapping("/update-status/validatenameandid")
	@ResponseBody
	public boolean checkDuplicateNameAndId(@RequestParam String statusname,int id) {
		return statusservice.checkStatusNameAndId(id,statusname);
	}
	
	@GetMapping("/update-status/validatecodeandid")
	@ResponseBody
	public boolean checkDuplicateCodeAndId(@RequestParam String statuscode,int id) {
		return statusservice.checkStatusCodeAndId(id,statuscode);
	}
	

	
	
	
	
}
