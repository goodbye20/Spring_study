package kr.co.goodee39.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bbs")
public class BBSController {
	
	@GetMapping("/main")
	public String getBBSList() {
		
		return "bbs";
	}
	
}
