package pvs.admin.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

	
	@Autowired
	UserInfoRepo userinforepo;
	
	@Autowired
	PasswordEncoder pwd_encode;
	
	public UserInfoEntity saveuser(UserInfoEntity user) {
		user.setPassword(pwd_encode.encode(user.getPassword()));
		return userinforepo.save(user);
	}
}
