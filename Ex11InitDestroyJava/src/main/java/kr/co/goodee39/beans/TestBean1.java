package kr.co.goodee39.beans;

public class TestBean1 {
	public TestBean1() {
		System.out.println("TestBean1의 생성자 입니다.");
	}
	
	public void init() {
		System.out.println("TestBean1의 init메서드");
	}
	
	public void destroy() {
		System.out.println("TestBean1의 destroy메서드");
	}
	
}
