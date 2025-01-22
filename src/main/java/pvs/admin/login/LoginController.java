package pvs.admin.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String gotoLogin() {
		return "login";
	}
	
	 @GetMapping("/403")
	    public String error403() {
	        return "403";  // Return the name of the 403.html file in templates
	    }
}
	
	
