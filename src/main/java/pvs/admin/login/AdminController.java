package pvs.admin.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	AccessRequestService accessreqservice;
	
	@PostMapping("/{id}/approve")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String approveReq(@PathVariable Long id,RedirectAttributes redirectAttribute) {
		accessreqservice.approveReq(id);
//		List<AccessRequestEntity> pendingReq =  accessreqservice.showPendingReq("PENDING");
//		model.addAttribute("pendingReq",pendingReq);
		redirectAttribute.addFlashAttribute("message","Request Approved!!");
		return "redirect:/admin";
	}
	
	@PostMapping("/{id}/reject")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String rejectReq(@PathVariable Long id,RedirectAttributes redirectAttribute) {
		accessreqservice.rejectReq(id);
		redirectAttribute.addFlashAttribute("message","Request Rejected!!");
		return "redirect:/admin";
	}

	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String adminHome(Model model) {
		List<AccessRequestEntity> pendingReq =  accessreqservice.showPendingReq("PENDING");
		model.addAttribute("pendingReq",pendingReq);
//		model.addAttribute("message","");
		return "admin-home";
		
	}
	
	@GetMapping("/approved-req")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String approvedReq(Model model) {
		List<AccessRequestEntity> approvedReq =  accessreqservice.showPendingReq("approved");
		model.addAttribute("approvedReq",approvedReq);
		return "admin-home";
		
	}
	
	@GetMapping("/rejected-req")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String rejectedReq(Model model) {
		List<AccessRequestEntity> rejectedReq =  accessreqservice.showPendingReq("rejected");
		model.addAttribute("approvedReq",rejectedReq);
		
		return "admin-home";
		
	}
}
