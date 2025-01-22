package pvs.admin.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@ResponseBody
@RequestMapping("/access-request")
public class AccessRequestController {

	@Autowired
	AccessRequestService accessreqservice;
	
	@GetMapping("/new-request")
	public String newRequest(Model model) {
		AccessRequestEntity req = new AccessRequestEntity();
		model.addAttribute("request",req);
		return "a-req";
	}
	
	@PostMapping("/save")
	public String saveRequest(@ModelAttribute("req") AccessRequestEntity req,RedirectAttributes redirectattributes,Model model) {
		model.addAttribute("request",req);
		accessreqservice.requestAccess(req);
		redirectattributes.addFlashAttribute("message","Request Sent. Kindly Wait for the approval!");
		
		return "redirect:/";
	}
	
}
