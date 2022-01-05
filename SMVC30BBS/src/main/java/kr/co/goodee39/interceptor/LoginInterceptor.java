package kr.co.goodee39.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor{
//	servlet-context에 interceptor설정을 /bbs/** 로 해뒀디에 bbs/를 거치는 경로는
//  모두 인터셉터를 거치도록 해둔 것 
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 세션을 조회해보고서
		HttpSession session = request.getSession();
		// 만약 세션에 account가 없다면(null)이라면
		if(session.getAttribute("account")==null) {
			// 세션 한번 초기화 = 어떠한 힌트를 주지 않기위해 정보 말소
			session.invalidate();
			// 초기창으로 넘겨줘버림
			response.sendRedirect(request.getContextPath()); // getContextPath() = /SMVC30BBS/  
															 //	localhost://8080 뒤의 homecontroller설정상의 경로를 뜻함 생각하면됨.
															 // 좀더 심화하자면 request.getContextPath()+path 를 붙여준다면 원하는 path로 보낼수도 있다.
			return false;
		}
		return true;
	}
}
