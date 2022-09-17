package customLogin.controller;

import java.time.LocalDate;
import java.util.Date;

public class UserNotFoundException extends RuntimeException {


	public int errorNO;
	public String message;

	
	public int getErrorNO() {
		return errorNO;
	}
	public void setErrorNO(int errorNO) {
		this.errorNO = errorNO;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public UserNotFoundException(int errorNO, String message) {
		
		this.message = message;
		this.errorNO = errorNO;
		
	}
	public UserNotFoundException()
	{
		
	}
	@Override
	public String toString() {
		return "UserNotFoundException [errorNO=" + errorNO + ", message=" + message + "]";
	}
	
	
	
	
	
	
	
}
