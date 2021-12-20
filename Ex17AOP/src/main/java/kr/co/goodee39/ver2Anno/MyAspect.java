package kr.co.goodee39.ver2Anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
// 최신버전은 안되서 다운그레이드 해야 됨

@Aspect
@Component
public class MyAspect {
	
	@Pointcut("execution(* doSomething())")
	public void myPointcut() {
		
	}
	
	// JoinPoint
	/*
	 * - aop 대상이 되는 메서드 혹은 객체의 정보가 담겨있는 객체
	 * 
	 * */
	@Before("myPointcut()")
	public void before(JoinPoint jp) {
		// 핵심로직으로 호출한 메소드를 포함한 객체를 리턴
		System.out.println("getTarget : "+jp.getTarget());
		// 핵심로직 호출 시 넘겨준 인자 목록을 리턴
		System.out.println("getArgs : "+jp.getArgs());
		// 호출한 핵심로직 메서드의 시그니쳐(메서드이름, 리턴타입, 매개변수)를 리턴 
		System.out.println("getSignature : "+jp.getSignature());
		
		System.out.println("getThis : "+jp.getThis());
		System.out.println("문을 열고 집에 들어간다.");
	}
	
	@After("myPointcut()")
	public void after() {
		System.out.println("문을 열고 집에 나온다.");
	}
	// 타겟이 되는 메서드에 리턴 값을 str로 받아서 쓸 수가 있으며
	// 이때 beans.xml에는 반드시 after-returning 쪽에 returning 속성으로
	// 어느 파라미터에 받을 건지에 대한 명시가 이루어져야 한다.
	
	@AfterReturning(pointcut = "myPointcut()", returning = "str")
	public void afterReturning(JoinPoint jp, String str) {
		System.out.println(str+"이 잠을잔다.");
	}
	// 타겟이 되는 메서드에 에러가 발생했을 경우 throwable을 통해 값을 받아서 쓸 수가 있으며
	// 이때 beans.xml의 after-throwing 쪽에 throwable 속성으로
	// 어느 파라미터에 해당 값을 받을 건지에 대한 명시가 이루어져야 한다.
	@AfterThrowing(pointcut = "myPointcut()", throwing = "thr")
	public void afterThrowing(JoinPoint jp, Throwable thr) {
		System.out.println(thr+"화재발생 : 119에 신고한다.");
	}
}