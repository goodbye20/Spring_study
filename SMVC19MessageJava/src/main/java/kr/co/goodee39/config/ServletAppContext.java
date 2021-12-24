package kr.co.goodee39.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
	
	// properties 파일을 등록
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res
			= new ReloadableResourceBundleMessageSource();
		
		// 단수개의 properties 파일을 등록
		// properties확장자 명은 없어도, 자동으로 맵핑해준다.
//		res.setBasename("/WEB-INF/properties/data1");
		
		// 복수개의 properties 파일을 등록
		res.setBasenames(
				"/WEB-INF/properties/data1",
				"/WEB-INF/properties/data2");
		
		
		return res;
	}
}