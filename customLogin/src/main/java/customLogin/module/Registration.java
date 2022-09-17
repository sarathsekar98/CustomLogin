package customLogin.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;



@Entity(name="registration")
@Table(name="user_login")
public class Registration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	public String firstname;
	
	public String lastname;
	
	public String email;
	
	public String password;
	
	@Transient
	public MultipartFile sample;
	
	@Transient
	public String name;
	
	public Registration() {
//		 TODO Auto-generated constructor stub
//		this.firstname="sarath";
//		this.lastname="sekar";
//		this.email="sarathsekar98@gmail.com";
//		this.password="sarath98";
	}
	


	
	public Registration(int id,String firstname, String lastname,String email, String password) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		setName();
		return name;
	}

	public void setName() {
		this.name = getFirstname()+" "+getLastname();
	}


	public MultipartFile getSample() {
		return sample;
	}




	public void setSample(MultipartFile sample) {
		this.sample = sample;
	}




	@Override
	public String toString() {
		return "Registration [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", name=" + name + "]";
	}




	
	
	
	
	
	
	

}
