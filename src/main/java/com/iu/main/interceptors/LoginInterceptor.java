package com.iu.main.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

	//qna의 모든 기능은 로그인한 사람만 가능
	//단, list는 제외하고
	//로그인이 X, 로그인 페이지로 이동
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		Object obj = request.getSession().getAttribute("login");
		if(obj!=null) {
			return true;
		}else {
//			response.sendRedirect("/member/login");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
			request.setAttribute("message","로그인이 필요합니다");
			request.setAttribute("url", "/member/login");
			view.forward(request, response);
			return false;
		}
	}
	
	
	
}
