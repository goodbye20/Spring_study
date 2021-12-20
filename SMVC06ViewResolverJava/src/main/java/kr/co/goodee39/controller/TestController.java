package kr.co.goodee39.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.goodee39.vo.DataVO;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1() {
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(HttpServletRequest request) {
		request.setAttribute("data1", 100);
		request.setAttribute("data2", 200);
		return "test2";
	}
	
	@GetMapping("/test3")
	// model
	// 데이터 값을 보낼때 spring에서 가장 많이 사용
	public String test3(Model model) {
		model.addAttribute("data1", 300);
		model.addAttribute("data2", 400);
		return "test3";
	}
	
	@GetMapping("/test4")
	// modelandview
	// 모델과 비슷하나 가는 값과 경로까지 같이 지정
	public ModelAndView test4(ModelAndView mv) {
		mv.addObject("data1", 500);
		mv.addObject("data1", 600);
		
		// 가는 경로 지정
		mv.setViewName("test4");
		return mv;
	}
	
	@PostMapping("/test5")
//	public String test5(@ModelAttribute DataVO vo) {
//	@ModelAttribute 는 생략가능
		public String test5(DataVO vo) {
//		vo.setData1("400");
//		vo.setData2("500");
		
		return "test5";
	}
	
	
		@PostMapping("/test6")
		public String test6(@ModelAttribute("testNameVO") DataVO vo) {
			vo.setData1("123");
			vo.setData2("456");
			
			return "test6";
		}
}
