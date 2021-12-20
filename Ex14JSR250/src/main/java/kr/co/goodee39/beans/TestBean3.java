package kr.co.goodee39.beans;

import javax.annotation.Resource;

public class TestBean3 {
	
	// 멤버변수와 이름과 동일한 이름의 bean이 주입된다.
	// autowird와 유사
	@Resource
	private DataBean1 data1;
	@Resource
	private DataBean2 data2;
	public DataBean1 getData1() {
		return data1;
	}
	public DataBean2 getData2() {
		return data2;
	}
	
}
