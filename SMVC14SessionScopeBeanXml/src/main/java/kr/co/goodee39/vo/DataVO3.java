package kr.co.goodee39.vo;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
//@SessionScope로 받기위해선 ServletAppContext에
//@ComponentScan으로 vo패키지 추가해줘야함
@SessionScope
public class DataVO3 {
	private String data5;
	private String data6;
	public String getData5() {
		return data5;
	}
	public void setData5(String data5) {
		this.data5 = data5;
	}
	public String getData6() {
		return data6;
	}
	public void setData6(String data6) {
		this.data6 = data6;
	}
	
	
}