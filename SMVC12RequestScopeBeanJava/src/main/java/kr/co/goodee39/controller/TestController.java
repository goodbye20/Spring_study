package kr.co.goodee39.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.goodee39.vo.DataVO1;
import kr.co.goodee39.vo.DataVO2;
import kr.co.goodee39.vo.DataVO3;
import kr.co.goodee39.vo.DataVO4;

@Controller
public class TestController {
	
	@Autowired
	// 이미 만들어져 있는 빈객체를
	// 자동으로 주입시켜주는 기능
	// 싱글톤으로 생성되어지기 때문에 new라던지 부가적인 다른 선언이 필요없어짐
	// 만약 이 방법이 아니라면 modelattribute를 통해서 커맨드객체 사용하던지
	// new를 통해 생성자를 만들어 사용해야 할 것임
	private DataVO1 requestVO1;
	
	@Autowired
	@Qualifier("requestBean2")
	private DataVO2 requestVO2;
	
	@Autowired
	private DataVO3 requestVO3;
	
	@Resource(name="requestBean4")
	private DataVO4 requestVO4;
	
	@GetMapping("/test1")
	public String test1() {
		requestVO1.setData1("문자열1");
		requestVO1.setData2("문자열2");
		
		return "forward://result1";
	}

	@GetMapping("/result1")
	public String result1(Model model) {
		System.out.println("requestVO1.data1 : "+requestVO1.getData1());
		System.out.println("requestVO1.data2 : "+requestVO1.getData2());
		
		System.out.println("requestVO2.data3 : "+requestVO2.getData3());
		System.out.println("requestVO2.data4 : "+requestVO2.getData4());
		
		System.out.println("requestVO3.data5 : "+requestVO3.getData5());
		System.out.println("requestVO3.data6 : "+requestVO3.getData6());
		
		System.out.println("requestVO4.data7 : "+requestVO4.getData7());
		System.out.println("requestVO4.data8 : "+requestVO4.getData8());
		
		model.addAttribute("requestVO1", requestVO1);
		model.addAttribute("requestVO2", requestVO2);
		model.addAttribute("requestVO3", requestVO3);
		
		return "result1";
	}
}