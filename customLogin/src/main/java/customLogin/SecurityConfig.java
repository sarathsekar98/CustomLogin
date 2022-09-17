package customLogin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import customLogin.service.Customservice;

@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	Customservice sCustomservice;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Bean
	public DaoAuthenticationProvider provider()
	{
		DaoAuthenticationProvider provide = new DaoAuthenticationProvider();
		provide.setPasswordEncoder(passwordEncoder);
		provide.setUserDetailsService(sCustomservice);
		return provide;
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(provider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);		
		String[] resource = {"/css/**","/js/**","/images/**"};
        String[] withoutauthenticateStrings = {"/","/login","/registration"};
		http
		.authorizeRequests()
		.antMatchers(resource).permitAll()
		.antMatchers(withoutauthenticateStrings).permitAll()
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.loginPage("/login")
		.failureUrl("/login?error=1")
		.and()
		.httpBasic()
		.and()
		.cors()	
		.and()
		.csrf().disable();
	}
	
	
	
	

}
