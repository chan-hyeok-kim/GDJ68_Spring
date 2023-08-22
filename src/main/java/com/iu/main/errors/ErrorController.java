package com.iu.main.errors;


import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ErrorController {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String frontError() throws Exception{
		return "errors/front_error";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String error1(){
		System.out.println("Null Pointer Exception 발생");
		return "errors/front_error";
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	public void error2(){
		
	}
	
	@ExceptionHandler(Exception.class)
	public String error3(Exception ex){
		System.out.println(ex.getMessage());
		return "errors/front_error";
		
	}

}
