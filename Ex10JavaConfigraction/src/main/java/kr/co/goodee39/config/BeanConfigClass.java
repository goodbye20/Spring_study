package kr.co.goodee39.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import kr.co.goodee39.beans.TestBean1;
import kr.co.goodee39.beans.TestBean2;
import kr.co.goodee39.beans.TestBean3;

@Configuration
public class BeanConfigClass {
	
// <bean id="java1" class="kr.co.goodee39.beans.TestBean1"/>	와 같음
	@Bean
	public TestBean1 java1() {
		return new TestBean1();
	}
	
	
//	<bean id="java22" class="kr.co.goodee39.beans.TestBean1"/>	와 같음
	@Bean(name="java112")
	public TestBean1 java1111() {
		return new TestBean1();
	}
	
	
//	<bean id="java22" class="kr.co.goodee39.beans.TestBean2" lazy-init="true"/>	와 같음
	@Bean
	@Lazy
	public TestBean2 java2() {
		return new TestBean2();
	}

//<bean id="java3" class="kr.co.goodee39.beans.TestBean3" scope="prototype"/>	와 같음
	@Bean
	@Scope("prototype")
	public TestBean3 java3() {
		return new TestBean3();
	}

}