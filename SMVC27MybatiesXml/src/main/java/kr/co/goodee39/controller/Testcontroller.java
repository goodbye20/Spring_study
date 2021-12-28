package kr.co.goodee39.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.goodee39.service.testService;
import kr.co.goodee39.vo.DataVO1;

@Controller
public class Testcontroller {
	
	@Autowired
	testService service;
	
	@GetMapping("/input_data")
	public String input_data(DataVO1 vo1) {
		return "input_data";
	}
	
	@PostMapping("/input_pro")
	public String inputPro(DataVO1 vo1) {
		service.setData(vo1);
		return "input_pro";
	}
	
	@GetMapping("/read_data")
	public String readData(Model model) {
		service.getData(model);
		return "read_data"; 
	}
	
	@GetMapping("/tx_data1")
	public String txData1(Model model) {
		service.txData1(model);
		return "tx_data1";
	}
	
	@GetMapping("/tx_data2")
	public String txData2(Model model) {
		service.txData2(model);
		return "tx_data2";
	}
}