package kr.co.goodee39.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.co.goodee39.vo.BBSVO;

@Service
public class BBSService {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public void selectBBSList(Model model) {
		BBSVO vo = new BBSVO();
		model.addAttribute("list", sqlSessionTemplate.selectList("bbs.selectBBSList", vo));
	}
	
	// content를 포함한 상세보기의
	// 데이터들을 불러오는 로직
	public void selectBBS(Model model, BBSVO vo) {
	//	model.addAttribute("bbsVO", sqlSessionTemplate.selectOne("bbs.selectBBS", vo));
	// 가져올땐 가져오고 보낼땐 보낼 수 있게 변경
	vo = sqlSessionTemplate.selectOne("bbs.selectBBS", vo);
	model.addAttribute("bbsVO", vo);
	}
	
	public void insertBBS(BBSVO vo) {
		sqlSessionTemplate.insert("bbs.insertBBS", vo);
	}
	
	public void deleteBBS(BBSVO vo) {
		sqlSessionTemplate.delete("bbs.deleteBBS", vo);
	}
	
	public void updateBBS(BBSVO vo)	{
		sqlSessionTemplate.update("bbs.updateBBS", vo);
	}
}
