package kr.co.goodee39.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.goodee39.vo.DataVO1;
import kr.co.goodee39.vo.DataVO2;
import kr.co.goodee39.vo.DataVO3;
import kr.co.goodee39.vo.DataVO4;

@Controller
public class TestController {
	
	// xml은 주입 타이밍의 문제로 인해 
	// 500에러가 나올 수 있는데 그럴때는
	// @Lazy 어노테이션들을 넣어줌으로써 해결가능
	
	@Autowired
	@Lazy
	private DataVO1 requestVO1;
	
	// @reqeustScope의 어노테이션의 특이점!!!(이런 특이한 경우가 있기때문에 왠만하면 그냥 @component쓰는게 좋을듯)
	// 이 경우는 자바는 어떠한 경우에도 안되며, xml세팅일 경우에만
	// resource=name, root.xml의 bean의 id, 해당 VO클래스를 불러오는 이름(아래에선=requestVO2)
	// ******** 중요한건 xml 의 id !!! **************
	// 모두 통일됬을 시에만 model에 실어주지 않아도 값이 자동으로 주입됨
	// 그러나 왠만하면 이런 경우를 제외하고 값을 주입하여 전달하려하면 예외없이 model에 담아 보내는게 정신건강에 좋을 것 같다.
	@Resource(name="requestVO2")
	@Lazy
	private DataVO2 requestVO2;
	
	@Autowired
	@Lazy
	private DataVO3 requestVO3;
	
	@Resource(name="requestBean4")
	@Lazy
	private DataVO4 requestVO4;
	
	@GetMapping("/test1")
	@Lazy
	public String test1() {
		requestVO1.setData1("문자열1");
		requestVO1.setData2("문자열2");
		
		requestVO2.setData3("문자열3");
		requestVO2.setData4("문자열4");
		
		requestVO3.setData5("문자열5");
		requestVO3.setData6("문자열6");
		
		requestVO4.setData7("문자열7");
		requestVO4.setData8("문자열8");
		
		return "forward:/result1";
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
		
//		model.addAttribute("requestVO1", requestVO1);
//		model.addAttribute("requestVO2", requestVO2);
//		model.addAttribute("requestVO3", requestVO3);
//		model.addAttribute("requestVO4", requestVO4);
		
		return "result1";
	}
	
}
