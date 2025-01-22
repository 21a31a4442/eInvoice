package pvs.admin.adminPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminPageController {
	
	@GetMapping("/admin")
	public ModelAndView adminhome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/admin-page");
		mav.addObject("page","/admin/admin-home-page");
		
		return mav;
	}

}
