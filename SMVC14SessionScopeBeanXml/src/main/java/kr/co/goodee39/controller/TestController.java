package kr.co.goodee39.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	DataVO1 dataVO1;
	
	@Resource(name="dataVO2")
	@Lazy
	DataVO2 dataVO2;

	@Autowired
	@Lazy
	DataVO3 dataVO3;
	
	@Resource(name="dataVO4")
	@Lazy
	DataVO4 dataVO4;
	
	@GetMapping("/test1")
	public String test1() {
		dataVO1.setData1("문자열1");
		dataVO1.setData2("문자열2");
		
		dataVO2.setData3("문자열3");
		dataVO2.setData4("문자열4");
		
		dataVO3.setData5("문자열5");
		dataVO3.setData6("문자열6");
		
		dataVO4.setData7("문자열7");
		dataVO4.setData8("문자열8");
		
		return "test1";
	}
	
	@GetMapping("/result1")
//	public String result1(HttpSession session) {
	// @reqeustScope와 같이 @sessionScope 어노테이션의 특이점!!!(이런 특이한 경우가 있기때문에 왠만하면 그냥 @component쓰는게 좋을듯)
	// 이 경우는 자바는 어떠한 경우에도 안되며, xml세팅일 경우에만
	// resource=name, root.xml의 bean의 id, 해당 VO클래스를 불러오는 이름(아래에선=DataVO2)
	// ******** 중요한건 xml 의 id !!! **************
	// 모두 통일됬을 시에만 model에 실어주지 않아도 값이 자동으로 주입됨
	// 그러나 왠만하면 이런 경우를 제외하고 값을 주입하여 전달하려하면 예외없이 model에 담아 보내는게 정신건강에 좋을 것 같다.
	public String sesult1(Model model) {
		System.out.println("dataVO1.data1 : "+dataVO1.getData1());
		System.out.println("dataVO1.data1 : "+dataVO1.getData2());
		
		System.out.println("dataVO2.data3 : "+dataVO2.getData3());
		System.out.println("dataVO2.data4 : "+dataVO2.getData4());
		
		System.out.println("dataVO3.data5 : "+dataVO3.getData5());
		System.out.println("dataVO3.data6 : "+dataVO3.getData6());
		
		System.out.println("dataVO4.data7 : "+dataVO4.getData7());
		System.out.println("dataVO4.data8 : "+dataVO4.getData8());
		
		// 컨테이너상의(Spring) session영역과, 실제(웹) session(HttpSession)영역이랑은 별개이고
		// (스프링에서 제공하는 Spring SessionScope와, 웹의 sessionScope는 별개)
		// session에 setAttribute 해주기전에는 sessionScope에는 담기긴 했지만
		// 실제 데이터가 넘어갈 session에는 아직 담아주지 않았기 때문에 null이 출력됨 
//		System.out.println("session.dataVO1 : "+session.getAttribute("dataVO1"));
		
//		session.setAttribute("dataVO1", dataVO1);
		
		// 그렇다면 어쨌든간에 데이터를 전달을 해줘야 view단에 전달을 해주어야하는데(여태껏 예제로 전달해주지 않으면 무용지물이란걸 알아야함)
		// 부하가 계속 쌓이는 세션(HttpSession=sessionScope)을 통해 데이터를 전달하기보단
		// model(requestScope)를 통해 값을 전달해주는 것이 더 좋다.
		
//		model.addAttribute("dataVO1", dataVO1);
//		model.addAttribute("dataVO2", dataVO2);
//		model.addAttribute("dataVO3", dataVO3);
//		model.addAttribute("dataVO4", dataVO4);
		
		return "result1";
	}
}
