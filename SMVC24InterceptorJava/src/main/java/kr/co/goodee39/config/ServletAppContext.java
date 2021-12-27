package kr.co.goodee39.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.goodee39.interceptor.TestInterceptor1;
import kr.co.goodee39.interceptor.TestInterceptor2;
import kr.co.goodee39.interceptor.TestInterceptor3;
import kr.co.goodee39.interceptor.TestInterceptor4;
import kr.co.goodee39.interceptor.TestInterceptor5;
import kr.co.goodee39.interceptor.TestInterceptor6;

// Spring MVC 프로젝트에 관련된 설정을 하는 클래스
@Configuration
// controller 어노테이션이 셋팅되어 있는 클래스를 controller로 등록한다.
@EnableWebMvc
//스캔할 패키지를 지정한다.
@ComponentScan("kr.co.goodee39.controller")
public class ServletAppContext implements WebMvcConfigurer{
	// controller의 메서드가 반환하는 jsp에 이름 앞뒤에 경로와 확장자를 붙여주도록 설정
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/",".jsp");
	};
	
	// 정적 파일의 경로를 맵핑
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	//interceptor 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addInterceptors(registry);
		
		TestInterceptor1 inter1 = new TestInterceptor1();
		TestInterceptor2 inter2 = new TestInterceptor2();
		TestInterceptor3 inter3 = new TestInterceptor3();
		TestInterceptor4 inter4 = new TestInterceptor4();
		TestInterceptor5 inter5 = new TestInterceptor5();
		TestInterceptor6 inter6 = new TestInterceptor6();
		
		InterceptorRegistration reg1 = registry.addInterceptor(inter1);
		InterceptorRegistration reg2 = registry.addInterceptor(inter2);
		InterceptorRegistration reg3 = registry.addInterceptor(inter3);
		InterceptorRegistration reg4 = registry.addInterceptor(inter4);
		InterceptorRegistration reg5 = registry.addInterceptor(inter5);
		InterceptorRegistration reg6 = registry.addInterceptor(inter6);
		
		// 인터셉터는 반복적으로 확인해야하는 부분이 있을때 해당 상황이 발생할때마다 
		// 인터셉터로 처리하여 중복된 코드를 줄이는 용도로 사용한다
		// (특히 로그인 관련 시 사용을 많이 한다고함)

		// 인터셉터는 경로 파악 및 구분을 잘해주여야함
		// ex) 로그인을 해야 볼수 있는 페이지, 로그인을 하지 않아도 볼 수 있는 페이지
		reg1.addPathPatterns("/test1");

		// 경로에 여러개의 인터셉터가 실행될 때
		// 먼저 실행된게 겉을 감싸고 그 다음 실행된게 안쪽이 실행되는 구조가 나타남
		reg2.addPathPatterns("/test1");
		reg3.addPathPatterns("/test2");
		
//		reg4.addPathPatterns("/test1");
//		reg4.addPathPatterns("/test2");
		
		reg4.addPathPatterns("/test1","/test2");
		
		reg5.addPathPatterns("/sub1/test3","/sub1/test4");
		
		// '/'를 기준으로 첫 path에 있는 모든 경로만 태우고 싶을 경우
		// 위에 경우들중 /test1, /test1 경로에는 발동하지만
		// /sub1/test3, /sub1/test4는 발동하지 않음(이들은 /*/*)
		reg6.addPathPatterns("/*");
	}
}