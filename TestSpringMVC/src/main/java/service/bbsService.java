package service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import vo.bbsVO;


@Service
public class bbsService {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public void getList(Model model) {
		model.addAttribute("list", sqlSessionTemplate.selectList("bbs.selectBBSList"));
	}
	
	
	public void addList(bbsVO vo) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		
		vo.setOwner("이영주");
		vo.setCreatedate(date);
		
		sqlSessionTemplate.insert("bbs.insertBBSList", vo);
	}
}
