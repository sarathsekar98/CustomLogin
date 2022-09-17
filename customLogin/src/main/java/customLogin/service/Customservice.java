package customLogin.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import customLogin.module.Registration;

@Service
public class Customservice implements UserDetailsService {

	@Autowired
	public SessionFactory sessionFactory;
	
    public Session getSession(SessionFactory sessionFactory)
    {
    	return sessionFactory.openSession();
    }
    
    public Registration getuser(String username)
    {
    	Registration res = (Registration) getSession(sessionFactory).createQuery("from registration where email = : email").setParameter("email", username).uniqueResult();
    	
    	System.out.println(res.toString());
    	
    	return res;
    }
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Registration res = getuser(username);
		
		if(res==null)
		{
			throw new UsernameNotFoundException(username);
		}
		
		UserDetails user = User.withUsername(res.getEmail()).password(res.getPassword()).roles("USER").build();
		
		return user;
	}
    
    
    
}
