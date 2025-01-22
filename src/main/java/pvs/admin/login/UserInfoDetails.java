package pvs.admin.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoDetails implements UserDetailsService {

	@Autowired
	 UserInfoRepo userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfoEntity> userInfo = userrepo.findByUsername(username); 
		return 	userInfo.map(UserInfoUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("User not found"));
	}
	
}
