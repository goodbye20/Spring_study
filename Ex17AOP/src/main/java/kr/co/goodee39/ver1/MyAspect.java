package kr.co.goodee39.ver1;

import org.aspectj.lang.JoinPoint;
// 최신버전은 안되서 다운그레이드 해야 됨

public class MyAspect {
	public void before(JoinPoint jp) {
		// 핵심로직으로 호출한 메서드를 포함한 객체를 리턴
		System.out.println("getTarget : "+jp.getTarget());
		// 핵심로직 호출 시 넘겨준 인자 목록을 리턴
		System.out.println("getArgs : "+jp.getArgs());
		// 호출한 핵심로직 메서드의 시그니처(이름, 리턴타입, 매개변수)를 리턴
		System.out.println("getSignature : "+jp.getSignature());
		System.out.println("문을 열고 집에 들어간다.");	
	}
	
	public void after() {
		System.out.println("문을 열고 집에 나온다.");
	}
	
	public void afterReturning() {
		System.out.println("잠을 잔다.");
	}
	
	public void afterThrowing() {
		System.out.println("화재발생 : 119에 신고한다.");
	}
}
