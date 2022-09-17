package customLogin.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import customLogin.controller.UserNotFoundException;

@ControllerAdvice
public class GlobalException extends RuntimeException {
	
    @ResponseBody
	@ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handler( UserNotFoundException exception) {
		
		
        return new ResponseEntity<Object>(exception, HttpStatus.NOT_FOUND);
    }

}
