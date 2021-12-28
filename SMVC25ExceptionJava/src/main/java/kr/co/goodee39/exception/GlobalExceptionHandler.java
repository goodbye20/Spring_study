package kr.co.goodee39.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 예외(오류)를 악의를 가진 해커에게 보여지는 것만으로도 공격경로를 줄 수 있다던지
// 보안상의 문제가 되기 때문에 예외 처리를 하는것이 좋다.
// 또한 controller 마다 핸들러를 두어 처리를 할 수 있지만
// 각각의 모든 controller마다 둘 수 없으니 모든 예외처리를 한 곳에서 다루기 위한 로직
@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{
	
	@ExceptionHandler(java.lang.NullPointerException.class)
	public String handleException() {
		
		return "error2";
	}
	
	// 모든 에러를 다 포함
	// 앞서 만약 특정 에러로 핸들링 해둔 것이 있다면 그것이 먼저 발동
	@ExceptionHandler(java.lang.Exception.class)
	public String GlobalException() {
		
		return "error3";
	}
	
}
