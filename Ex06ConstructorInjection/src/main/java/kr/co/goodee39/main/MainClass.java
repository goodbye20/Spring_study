package kr.co.goodee39.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.goodee39.beans.TestBean1;
import kr.co.goodee39.beans.TestBean2;

public class MainClass {
	public static void main(String[] args) {
//		non-primitive 타입을 생성자를 통해 메서드를 가져오는법과 그에 맞게 값을 넣어주는 법을 알아보자
//		불러오려하는 bean파일(TestBean1)에 설정된 메서드, 매개변수에 맞게 타입과 인덱스를 설정하여 값을 넣어보자
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext(
						"kr/co/goodee39/config/Beans.xml");
		
//		기본 출력 메서드 호출
		TestBean1 obj1 = ctx.getBean("obj1", TestBean1.class);
//		System.out.println("obj1 : "+obj1);
		obj1.printData();
		
		System.out.println("-------------");
		
		// 하나의 매개변수를 가진 메서드중 int타입으로 변수를 가진 메서드에 맞춰 type을 int로 준후 값 대입
		TestBean1 obj2 = ctx.getBean("obj2", TestBean1.class);
		obj2.printData();
		
		System.out.println("-------------");
		
		// 두 개의 매개변수를 가진 메서드 중 둘다 int타입으로 변수를 가진 메서드에 맞춰 type을 두개 모두 int로 준후 값 대입
		TestBean1 obj3= ctx.getBean("obj3", TestBean1.class);
		obj3.printData();
		
		System.out.println("-------------");
		
		// 하나의 매개변수를 가진 메서드중 double타입으로 변수를 가진 메서드에 맞춰 type을 double로 준후 값 대입
		TestBean1 obj4 = ctx.getBean("obj4", TestBean1.class);
		obj4.printData();
		
		System.out.println("-------------");
		
		// 하나의 매개변수를 가진 메서드중 String타입으로 변수를 가진 메서드에 맞춰 type을 String로 준후 값 대입
		// String타입은 타입을 설정해주지 않아도 기본으로 설정된다.
		TestBean1 obj5 = ctx.getBean("obj5", TestBean1.class);
		obj5.printData();
		
		System.out.println("-------------");
		
		// 다수의 매개변수를 가진 메서드에 맞게 수많큼 맞춰 type과 값을 준후 값 대입
		TestBean1 obj6 = ctx.getBean("obj6", TestBean1.class);
		obj6.printData();
		
		System.out.println("-------------");
		// 다수의 매개변수를 가진 메서드에 맞게 수많큼 맞춰 type과 값을 준후 값 대입
		// 하지만 순서를 엉망으로 준다면?
		// => 순서가 마음대로 들어가게되도 타입에 맞게 찾아 들어가며, 같은 타입일 경우 입력된 순서에 따라 순차적으로 들어감
		TestBean1 obj7 = ctx.getBean("obj7", TestBean1.class);
		obj7.printData();
		
		System.out.println("-------------");
		
		// 다수의 매개변수를 가진 메서드에 맞게 수많큼 맞춰 type과 값을 준후 값 대입
		// 하지만 순서를 엉망으로 준다면?
		// => 순서가 마음대로 들어가게되도 타입에 맞게 찾아 들어가며, 같은 타입일 경우 입력된 순서에 따라 순차적으로 들어감
		// => 타입이 같을 경우 순차적으로 값이 주입되는데 이를 무시하고 원하는 곳에 원하는 값을 넣기위해 index 라는 속성을 통해
		// 	  값을 넣어 줄 곳을 지정해줄 수 있다.
		TestBean1 obj8 = ctx.getBean("obj8", TestBean1.class);
		obj8.printData();
		
		System.out.println("===================");
		System.out.println("===================");
		
		// primite (객체) 타입 불러오기

		TestBean2 obj9 = ctx.getBean("obj9", TestBean2.class);
		obj9.printData();
		
		System.out.println("-------------");
		
		TestBean2 obj10 = ctx.getBean("obj10", TestBean2.class);
		obj10.printData();
		
		System.out.println("-------------");
		
		// data-bean에만 있는 데이터를 ref로 불러옴
		TestBean2 obj11 = ctx.getBean("obj11", TestBean2.class);
		obj10.printData();
		
		ctx.close();
	}
}
