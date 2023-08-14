package com.iu.main.interceptors;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.main.member.MemberDTO;
import com.iu.main.member.RoleDTO;

@Component
public class AdminInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	      MemberDTO memberDTO = (MemberDTO) request.getSession().getAttribute("login");
	      List<RoleDTO> roles = memberDTO.getRoles();
	      for(RoleDTO roleDTO: roles) {
	    	  if(roleDTO.getRoleName().equals("ADMIN")) {
	    		 return true;  
	    	  }
	      }
	      
	      request.setAttribute("message", "관리자 권한이 없습니다");
	      request.setAttribute("url", "/");
	      RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
	      view.forward(request, response);
	      return false;
	}

}
