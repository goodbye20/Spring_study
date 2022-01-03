package kr.co.goodee39.service;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.goodee39.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public String getMember(MemberVO vo, HttpSession session) {
		MemberVO vo1 = sqlSessionTemplate.selectOne("member.selectMember", vo);
		String path = "";
		
		if(vo1 != null) {
			session.setAttribute("account", vo1);
		//  path = "bbs";
		//  첫 request(로그인시도)를 받고 redirect를 걸어줌으로써
		//  두번째 request 재요청과정에 인터셉터를 통한 권한검사를 받게 하기위해 redirect를 걸어줌
			path = "redirect:/bbs/main";
		} else {
			path = "index";
		}
		return path;
	}
	
	public String setMember(MemberVO vo) {
		sqlSessionTemplate.insert("member.insertMember", vo);
		return "";
	}
}
