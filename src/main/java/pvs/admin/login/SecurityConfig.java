package pvs.admin.login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	UserDetailsService userService() {
		return new UserInfoDetails();
	}

	@Bean
	public SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/admin/**").authenticated() 
//                		.requestMatchers("/status-info","/access/{id}/approve").authenticated())
				.requestMatchers("/admin/**").hasRole("ADMIN").requestMatchers("access-request/new-request", "/css/**")
				.permitAll().requestMatchers("/status/**").hasRole("ADMIN")
//                		.requestMatchers("/").authenticated()
				.anyRequest().authenticated())
				.exceptionHandling(exceptionHandling -> exceptionHandling.accessDeniedPage("/403"))
				.formLogin(formLogin -> formLogin.loginPage("/login").permitAll().defaultSuccessUrl("/", true)).build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}

}
