package customLogin;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@EnableTransactionManagement

@ComponentScan(basePackages = "customLogin")
public class democonfig extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		//super.addResourceHandlers(registry);
		registry
		.addResourceHandler("/images/**","/css/**","/js/**")
		.addResourceLocations("classpath:/images/","classpath:/css/","classpath:/js/");
		
	}
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
    }
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		//super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/view/", ".jsp");
	}
	
	@Bean
	public PasswordEncoder encoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	//@Bean 
//	@MultipartConfig\
//	public CommonsMultipartResolver fileResolver()
//	{
//		CommonsMultipartResolver cm = new CommonsMultipartResolver();
//		cm.setMaxUploadSize(1048*20);
//		return cm;
//	}
}
