package kr.co.goodee39.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.Model;

import kr.co.goodee39.vo.DataVO1;

@Service
public class testService {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
	public void setData(DataVO1 vo1) {
		sqlSessionTemplate.insert("springsample.insertSample", vo1);
	}
	
	
	public void getData(Model model) {
		model.addAttribute("list", sqlSessionTemplate.selectList("springsample.selectSample"));
	}
	
	public void txData1(Model model) {
		
	}
	
	public void txData2(Model model) {
		
	}
}
