package pvs.admin.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserInfoController {

	
	@Autowired
	UserInfoService userservice;
	
	@PostMapping("/save")
	public String saveUser(@RequestBody UserInfoEntity user) {
		
		userservice.saveuser(user);
		return "user saved!!";
	}
	
	
}
