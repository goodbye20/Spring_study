package kr.co.goodee39.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.co.goodee39.beans.JdbcBean;

@Component
public class JdbcDAO {
	
	// JDBC 관리 객체 주입
	@Autowired
	private JdbcTemplate db;
	
	// Mapper 주입
	@Autowired
	private memberMapper mapper;
	
	// 저장 (insert)
	public void insert_data(JdbcBean bean) {
		String sql = "insert into jdbc_table(int_data, str_data) values(?,?)";
		db.update(sql, bean.getInt_data(), bean.getStr_data());
	}
	
	// 가져오기 (select)
	public List<JdbcBean> select_data() {
		String sql = "select int_data, str_data from jdbc_table";
		List<JdbcBean> list = db.query(sql, mapper);
		
		return list;
	}
	
	// 수정 (update)
	public void update_data(JdbcBean bean) {
		String sql = "update jdbc_table set str_data = ? where int_data = ?";
		db.update(sql, bean.getStr_data(), bean.getInt_data());
	}
	
	// 삭제 (delete)
	public void delete_data(int int_data) {
		String sql = "delete from jdbc_table where int_data = ?";
		db.update(sql, int_data);
	}
}
