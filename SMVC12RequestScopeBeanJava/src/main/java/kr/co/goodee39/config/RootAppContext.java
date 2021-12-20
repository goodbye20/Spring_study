package kr.co.goodee39.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import kr.co.goodee39.vo.DataVO1;

// 프로젝트 작업 시 사용할 bean을 정의하는 클래스
@Configuration
public class RootAppContext {
	@Bean
	@RequestScope
	// 어노테이션으로 requestScope에 등록
	// 하지만 이 경우 requestScope는 requestScope라는 스코프에 등록을 해주기는 하지만(콘솔 출력에는 들어가있음)
	// 그 스코프라는 범위에만 들어가 있을뿐 (값을 어디인가에 전달하기위해서)request에 넣어주기위해서는
	// model이나 http,web request를 통해 수동으로 직접 값을 대입해줘야함
	public DataVO1 dataVO1() {
		return new DataVO1();
	}
}
