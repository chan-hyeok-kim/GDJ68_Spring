package com.iu.main.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//@Component
public class InterceptorTest1 extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		//return이 true면 Controller로 계속 진행
		//return이 false면 거절
		System.out.println("Controller 진입 전");
		
//		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/../*.jsp");
//		view.forward(request, response);
//		
//		response.sendRedirect(null);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Controller에서 DS 가기 전");
	
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Jsp를 렌더링 후");
		
	}
	
	
	

}
