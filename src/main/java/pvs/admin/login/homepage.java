package pvs.admin.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homepage {

	@GetMapping("/") 
	public String homePage() {
		return "index2";
	}
	
}
