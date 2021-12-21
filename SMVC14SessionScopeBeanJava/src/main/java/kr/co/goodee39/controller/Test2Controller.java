package kr.co.goodee39.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.goodee39.vo.DataVO1;

@Controller
public class Test2Controller {
	
	@Autowired
	DataVO1 dataVO1;
	
	@GetMapping("/result2")
	public String result2() {
		// @Autowired를 통해 주입한것과 특성이 같다는 걸 확인하기 위해
		// 콘솔만 확인하기 위한 페이지
		System.out.println("dataVO1.data1 : "+dataVO1.getData1());
		System.out.println("dataVO1.data1 : "+dataVO1.getData2());
		
		return "result1";
	}
}
