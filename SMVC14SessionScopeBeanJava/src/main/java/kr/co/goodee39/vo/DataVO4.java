package kr.co.goodee39.vo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component(value="dataVO4")
// @SessionScope로 받기위해선 ServletAppContext에
// @ComponentScan으로 vo패키지 추가해줘야함
@SessionScope
public class DataVO4 {
	
	private String data7;
	private String data8;
	public String getData7() {
		return data7;
	}
	public void setData7(String data7) {
		this.data7 = data7;
	}
	public String getData8() {
		return data8;
	}
	public void setData8(String data8) {
		this.data8 = data8;
	}
	
}