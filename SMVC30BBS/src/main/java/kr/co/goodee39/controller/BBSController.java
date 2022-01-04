package kr.co.goodee39.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.goodee39.service.BBSService;
import kr.co.goodee39.vo.BBSVO;

@Controller
@RequestMapping("/bbs")
public class BBSController {
	
	@Autowired
	private BBSService service;
	
	@GetMapping("/main")
	public String getBBSList(Model model) {
		service.selectBBSList(model);
		return "bbs";
	}
	
	@GetMapping("/detail")
	// 게시글에 해당하는 num값을 받아와서
	// 그에 맞는 게시글로 안내해줘야하는데
	// num을 커맨드객체에도 같은 이름으로 세팅을 해두었기때문에 커맨드 객체를 사용하면
	// 자동으로 매칭하여 받아와줄 수 있다.
	public String getBBSDetail(Model model, BBSVO vo) {
		service.selectBBS(model, vo);
		return "bbs_detail";
	}
	
	@GetMapping("/create")
	public String getBBSCreate(BBSVO vo) {
		return "bbs_create";
	}
	
	@PostMapping("/create_result")
	public String setBBSCreate(BBSVO vo) {
//		System.out.println(vo.getTitle());
//		System.out.println(vo.getContent());
//		System.out.println(vo.getOwnerid());
//		System.out.println(vo.getOwnername());
		vo.setCreatedate(new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(new Date()));
		service.insertBBS(vo);
		return "redirect:/bbs/main";
	}
	
	@GetMapping("/delete_bbs")
	public String delBBS(BBSVO vo) {
		service.deleteBBS(vo);
		return "redirect:/bbs/main";
	}
	
	@GetMapping("/modify_bbs")
	public String modifyBBS(Model model, BBSVO vo) {
		service.selectBBS(model, vo);
		return "bbs_modify";
	}
	
	@PostMapping("/modify_result")
	public String modifyBBSResult(BBSVO vo) {
		service.updateBBS(vo);
		return "redirect:/bbs/main";
	}
}
