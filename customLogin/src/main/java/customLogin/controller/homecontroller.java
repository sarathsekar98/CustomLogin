package customLogin.controller;



import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;

import com.mysql.cj.exceptions.RSAException;

import customLogin.module.Address;
import customLogin.module.Registration;
import customLogin.module.User;

@Controller
public class homecontroller {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
    public Session getsession()
    {
    	
    	return sessionFactory.openSession();
    }
	
	@RequestMapping("/")
	public String home(Authentication auth)
	{
	  // System.out.println(Paths.get("classpath:/images"));
		return "index";
	}
	
	@RequestMapping("/login")
	public String Login()
	{
		return "Login";
	}
	
	
	@RequestMapping(value="/registration")
	public Registration Registration(Model model)
	{
		model.addAttribute("user",new Registration());
		return new Registration();
	}
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/newuser",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String adduser(@RequestBody Registration reg,Model model)
	{
		System.out.println(reg.toString());
		Integer result = (Integer) sessionFactory.openSession().save(reg);
		if(result != 0)
		{
			return "pass";
		}
     	return "fail";
	}
	
	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping("/listuser")
	public List<Registration> list(Model model)
	{
	  
		List<Registration> sList =	getsession().createQuery("from registration").getResultList();
		
		sList.forEach(e->{
			System.out.println(e.toString());
		});
	
		return sList;	
	}
	
//	@RequestMapping("/update")
//	public String beforeUpdate(@RequestParam(name = "id") int id,Model model)
//	{
//		Registration reg = getsession().get(Registration.class, id);
//		if(reg==null)
//		{
//			return "redirect:userpage?error=2";
//		}
//		model.addAttribute("user", reg);
//		return "update";	
//	}
	@RequestMapping("/update")
	public String beforeUpdate1()
	{
		
		return "update";	
	}
	
	@ResponseBody
	@RequestMapping("/update1")
	public Registration beforeUpdate(@RequestParam(name = "id") int id,Model model)
	{
		Registration reg = getsession().get(Registration.class, id);
		if(reg==null)
		{
		 //	return "redirect:userpage?error=2";
		}
		// model.addAttribute("user", reg);
		return reg;	
	}
	
	@RequestMapping(value = "/userupdate",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Transactional
	public String update(Registration reg ,HttpServletRequest request) throws IOException
	{
		
		
		
		//BufferedOutputStream bStream = new  BufferedOutputStream(new FileOutputStream("C:\\Users\\Admin\\eclipse-workspace\\customLogin\\src\\main\\resources\\images\\"+reg.getSample().getOriginalFilename()));
	//	bStream.write(reg.getSample().getBytes());
		//bStream.flush();
	//	bStream.close();
//		 sessionFactory.getCurrentSession().merge(reg);
		 return "redirect:listuser";
	}
	@ResponseBody
	@RequestMapping("/random")
	public User newuser()
	{
		Address k = new Address();
		k.setAddress("adadada");
		User s = new User();
		s.setName("sarath");
		s.setAddress(k);	
		
	   // User g=	(User) sessionFactory.openSession().save(s);
		
		
		return s;
		
		
	}
	
	
}