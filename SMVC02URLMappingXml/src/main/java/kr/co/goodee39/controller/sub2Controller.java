package kr.co.goodee39.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sub2")
// RequestMapping을 통해 공통된 경로를 컨트롤 가능
public class sub2Controller {

	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String subTest5() {
		return "sub2/test5";
	}

	@RequestMapping(value = "/test6", method = RequestMethod.GET)
	public String subTest6() {
		return "sub2/test6";
	}
}
