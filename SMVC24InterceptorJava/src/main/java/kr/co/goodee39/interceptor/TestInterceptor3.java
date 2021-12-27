package kr.co.goodee39.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor3 implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("<controller 실행 전>");
		System.out.println("TestInterceptor3 - preHandle");
		System.out.println("============================");
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("<controller실행 후/ view실행 전>");
		System.out.println("TestInterceptor3 - postHandle");
		System.out.println("============================");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("<view 실행 후>");
		System.out.println("TestInterceptor3 - afterCompletion");
		System.out.println("============================");
	}
	
	
}
