package kr.co.goodee39.ver1;

public class Girl implements Person{
	@Override
	public void doSomething() {
		System.out.println("드라마를 본다.");
//		System.out.println(1/0) // 에러 호출용;
	}
}
