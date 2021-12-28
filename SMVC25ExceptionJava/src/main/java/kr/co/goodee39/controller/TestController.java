package kr.co.goodee39.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	
	@GetMapping("/test1")
	public String test1(Model model) {
		int[] array1 = {10,20,30};
//		model.addAttribute("array1", array1[0]);
		model.addAttribute("array1", array1[10]);
		
		return "test1";
	}
	
	// @ExceptionHandler : 예외처리 핸들러
	// 해당 컨트롤러에만 작동
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public String exception1() {
		return "error1";
	}
}
