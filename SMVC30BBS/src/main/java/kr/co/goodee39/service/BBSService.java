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
	
//	public void selectBBSList(Model model) {
//		BBSVO vo = new BBSVO();
//		model.addAttribute("list", sqlSessionTemplate.selectList("bbs.selectBBSList", vo));
//	}
	
	// 리스팅 처리
	// 페이지값인 num도 함께 받아줌
	public void selectBBSList(Model model, int num, String title, String content) {
		BBSVO vo = new BBSVO();
		// start 얻기 (start = 페이지값(num)-1* count(10))
		vo.setStart((num-1)*vo.getCount());
		if(!title.equals("")) {
			model.addAttribute("title", title);
			vo.setTitle("%"+title+"%");
		}
		if(!content.equals("")) {
			model.addAttribute("content", content);
			vo.setContent("%"+content+"%");
		}
		
		model.addAttribute("list", sqlSessionTemplate.selectList("bbs.selectBBSList", vo));
		model.addAttribute("count", sqlSessionTemplate.selectOne("bbs.selectBBSCount", vo));
		
		// 각각의 페이지 이동을 위해 num도 모델에 담아줌
		model.addAttribute("num", num);
	}
	
//	// content를 포함한 상세보기의
//	// 데이터들을 불러오는 로직
//	public void selectBBS(Model model, BBSVO vo) {
//	//	model.addAttribute("bbsVO", sqlSessionTemplate.selectOne("bbs.selectBBS", vo));
//	// 가져올땐 가져오고 보낼땐 보낼 수 있게 변경
//	vo = sqlSessionTemplate.selectOne("bbs.selectBBS", vo);
//	model.addAttribute("bbsVO", vo);
//	}
	
	
	// 위는 sqlSessionTemplate....을 vo(vo =)에 넣어줌으로써 주소값이 바뀌게되어
	// bbs_modify.jsp의 폼과의 매핑이 커맨드객체와 되지않고
	// 폼과의 매핑이 model에 담아둔 "bbsVO"로 맵핑해줘야하여
	// 위처럼 잘못된부분과 모델을 사용하지 않고, controller의 모델도 모두 제거
	// 커맨드 객체로만 맵핑하고 사용하여 쓰는 방식을 택함
	public void selectBBS(BBSVO vo) {
		//vo = sqlSessionTemplate.selectOne("bbs.selectBBS", vo);
		BBSVO vo2 = sqlSessionTemplate.selectOne("bbs.selectBBS", vo);
		vo.setNum(vo2.getNum());
		vo.setTitle(vo2.getTitle());
		vo.setContent(vo2.getContent());
		vo.setOwnerid(vo2.getOwnerid());
		vo.setOwnername(vo2.getOwnername());
		vo.setCreatedate(vo2.getCreatedate());
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
