package kr.co.goodee39.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.goodee39.vo.DataVO1;
import kr.co.goodee39.vo.DataVO2;

// 프로젝트 작업 시 사용할 bean을 정의하는 클래스
@Configuration
public class RootAppContext {
	
	@Bean
	@SessionScope
	public DataVO1 datavo1() {
		return new DataVO1();
	}
	
	@Bean("dataVO2")
	@SessionScope
	public DataVO2 dataVO2() {
		return new DataVO2();
	}
	
}
