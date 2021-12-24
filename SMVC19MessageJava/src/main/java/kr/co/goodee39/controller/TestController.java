package kr.co.goodee39.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	//메세지 주입받기
	@Autowired
	ReloadableResourceBundleMessageSource res;
	
	@GetMapping("/test1")
	public String test1(Model model, Locale locale) {
	
		String a1 = (String)res.getMessage("aaa.a1", null, null);
		String b1 = (String)res.getMessage("bbb.b1", null, null);
		
		System.out.println("aaa.a1 : "+a1);
		System.out.println("bbb.b1 : "+b1);
		
		
		// {} 부분에 세팅할 값 배열
		Object[] args = {30, "홍길동"};
		String a2 = res.getMessage("aaa.a2", args, null);
		
		
		System.out.println("aaa.a2 : "+a2);
		model.addAttribute("args", args);
		
		// 지역에 따른 메시지 변경
		String a3 = res.getMessage("aaa.a3", null, locale);
		
		System.out.println("locale : "+locale);
		System.out.println("aaa.a3 : "+a3);
		
		
		return "test1";
	}
}
