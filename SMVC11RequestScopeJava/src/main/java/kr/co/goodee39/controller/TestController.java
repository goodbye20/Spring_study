package kr.co.goodee39.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.goodee39.vo.DataBean1;

@Controller
public class TestController {

//	HttpServletRequest로 전송

	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		request.setAttribute("data1", "문자열1");

//		return "redirect://test1";
		return "forward://result1";
	}

	@GetMapping("/result1")
	public String result1(HttpServletRequest request) {
		String data1 = (String) request.getAttribute("data1");
		System.out.println("data1 : " + data1);

		return "result1";
	}

//	Model로 전송
//  Model은 request와 다르게 뷰리졸버로 값을 전달만 해주고서 초기화됨
//  view화면(result2)에는 정상적으로 데이터가 전달되지만
//  Model은 초기화 되기 때문에 sysout(콘솔)에 data2은 null로 출력됨
	@GetMapping("/test2")
	public String test2(Model model) {
		model.addAttribute("data2", "문자열2");

		return "forward://result2";
	}

	@GetMapping("/result2")
	public String result2(Model model) {
		String data2 = (String) model.getAttribute("data2");
		System.out.println("data2 : " + data2);

		return "result2";
	}

//	WebRequest로 전송
	@GetMapping("/test3")
	public String test3(Model model) {
		model.addAttribute("data3", "문자열3");

		return "forward://result3";
	}

	@GetMapping("/result3")
	public String result3(WebRequest request) {
		String data3 = (String)request.getAttribute("data3", WebRequest.SCOPE_REQUEST);
		// webRequest.getAttibute는 값을 받을때 뒤에 값을 어디서 받을지도 정해줘야함
		// 값을 WebRequest.SCOPE_REQUEST 에서 받기로 지정해준 것
		System.out.println("data3 : " + data3);

		return "result3";
	}

//	ModelAndView 로 전송
//  역시나 model과 같은 성격을 띄기 때문에 값을 전달해주고는 초기화 되기 때문에
//  값은 전달하여 결과 페이지에는 보여지지만, 콘솔에는 null이 출력된다.
	@GetMapping("/test4")
	public ModelAndView test4(ModelAndView mv) {
		mv.addObject("data4", "문자열4");
		mv.setViewName("forward://result4");

		return mv;
	}

	@GetMapping("/result4")
	public ModelAndView result4(ModelAndView mv, HttpServletRequest request) {
		String mv_data4 = (String) mv.getModel().get("data4");
		System.out.println("mv_data4 : " + mv_data4);

		// 없어도 되지만 비교를 위해 request 값도 매개변수로 받아 콘솔창에서 확인
		String request_data4 = (String) request.getAttribute("data4");
		System.out.println("request_data4 : " + request_data4);

		mv.setViewName("result4");
		return mv;
	}

//	커맨드 객체를 통한 전송
//  역시나 model과 같은 성격을 띄기 때문에 값을 전달해주고는 초기화 되기 때문에
//  값은 전달하여 결과 페이지에는 보여지지만, 콘솔에는 null이 출력된다.
	@GetMapping("/test5")
	public String test5(@ModelAttribute("bean1") DataBean1 bean1) {
		bean1.setData1("문자열6");
		bean1.setData2("문자열7");

		return "forward://result5";
	}

	@GetMapping("/result5")
//	public String result5(@ModelAttribute("bean1") DataBean1 bean1,
//	WebRequest request) {
//System.out.println("bean1.data1"+bean1.getData1());
//System.out.println("bean1.data2"+bean1.getData2());
	public String result5(WebRequest request) {
		DataBean1 data1 = (DataBean1) request.getAttribute("bean1", WebRequest.SCOPE_REQUEST);
		System.out.println("data1.data1 : " + data1.getData1());
		System.out.println("data1.data2 : " + data1.getData2());

		return "result5";
	}
}
