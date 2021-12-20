package kr.co.goodee39.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.co.goodee39.beans.JdbcBean;

@Component
// ********** implements RowMapper가 핵심 **********
// 를 해주어야 JdbcDAO에서 select문에 db.query메서드안에 mapper class를 넣어줄수 있음 안그러면 오류
public class memberMapper implements RowMapper<JdbcBean>{
	// 맵핑을 해주는 로직
	public JdbcBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		JdbcBean bean = new JdbcBean();
		bean.setInt_data(rs.getInt("int_data"));
		bean.setStr_data(rs.getString("str_data"));
		
		return bean;
	}
}
