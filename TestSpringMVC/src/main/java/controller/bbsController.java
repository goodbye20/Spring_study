package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import service.bbsService;
import vo.bbsVO;


@Controller
public class bbsController {
	
	@Autowired
	bbsService service;
	
	@GetMapping("/getlist_page")
	public String getListPage(Model model) {
		service.getList(model);
		
		return "getlist_page";
	}
	
	@GetMapping("/setlist_page")
	public String setList_page(bbsVO vo) {
		return "setlist_page";
	}
	
	@GetMapping("/addlist")
	public String addList(bbsVO vo, Model model) {
		service.addList(vo);
		service.getList(model);
		return "getlist_page";
	}
}
