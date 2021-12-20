package kr.co.goodee39.main;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import kr.co.goodee39.beans.SampleBean;

public class MainClass {
	// 스프링 컨테이너 접근 방법
	/*
	 * 스프링 컨테이너에 접근하는 방법을 Spring-context에서 다양하게 제공하고 있다.
	 * 스프링 컨테이너를 접근하는 방식은 옛날 방식과 현재 자주 사용되는 방식 두가지로 크게 분류할 수 있다.
	 * 
	 * 옛날 방식
	 * 	- ClassPathResource, FileSystemResource : 이 두개를 통해 스프링 컨테이너를 생성하며
	 *   생성된 스프링 컨테이너는 XmlBeanFactory를 통해 접근 가능하다.
	 *	 - 현재 XmlBeanFactory는 Deplicated 되었으며 잘 사용하지 않지만 구버전인 Spring에서는 아직도 이 방식으로 구동되는 것이 꽤 있다.
	 * 
	 * 현재 방식
	 * 	- ClassPathXmlApplicationContext, FileSystemXmlApplicationContext : 
	 * 	  이 두개를 통해 스프링 컨테이너를 생성하며 생성된 스프링 컨테이너의 빈의 접근이 가능하다.
	 * */
	public MainClass() {
//		test1();
//		test2();
//		test3();
		test4();
	}
	
	// Bean 팩토리에 접근하는 방법 - xml이 패키지 내부에 있을 때(옛 방식)
	public void test1() {
		ClassPathResource res = new ClassPathResource("kr/co/goodee39/config/Beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);
		
		SampleBean b1 = factory.getBean("b1", SampleBean.class);
		System.out.println("b1 : "+b1);
		
		SampleBean b2 = factory.getBean("b1", SampleBean.class);
		System.out.println("b2 : "+b2);
	}
	
	// Bean 팩토리에 접근하는 방법 - xml이 패키지 외부에 있을 때(옛 방식)
	public void test2() {
		FileSystemResource res = new FileSystemResource("Beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);
		
		SampleBean b1 = factory.getBean("b1", SampleBean.class);
		System.out.println("b1 : "+b1);
		
		SampleBean b2 = factory.getBean("b1", SampleBean.class);
		System.out.println("b2 : "+b2);
	}
	
	// Bean 팩토리에 접근하는 방법 - xml이 패키지 내부에 있을 때(현재 방식) 
	public void test3() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/goodee39/config/Beans.xml");
		
		SampleBean b1 = ctx.getBean("b1", SampleBean.class);
		System.out.println("b1 : "+b1);
		
		SampleBean b2 = ctx.getBean("b1", SampleBean.class);
		System.out.println("b2 : "+b2);
	}
	
	
	// Bean 팩토리에 접근하는 방법 - xml이 패키지 외부에 있을 때(현재 방식) 
	public void test4() {
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("Beans.xml");
		
		SampleBean b1 = ctx.getBean("b1", SampleBean.class);
		System.out.println("b1 : "+b1);
		
		SampleBean b2 = ctx.getBean("b1", SampleBean.class);
		System.out.println("b2 : "+b2);
	}
	
	
	public static void main(String[] args) {
			new MainClass();
	}

}
