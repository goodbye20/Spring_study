package kr.co.goodee39.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import kr.co.goodee39.mapper.MapperInterface;

@Configuration
@ComponentScan(basePackages = "kr.co.goodee39.beans")
public class BeanConfigClass {
	
	// DataSource
	@Bean
	public BasicDataSource source() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName("org.mariadb.jdbc.Driver");
		source.setUrl("jdbc:mariadb://localhost:3310/mydb2");
		source.setUsername("root");
		source.setPassword("7227");
		return source;
	}

	// SqlSessionFactory : jdbc를 처리하는 객체
	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(source);
		SqlSessionFactory factory = factoryBean.getObject();
		
		return factory;
	}

	// Mapper 등록
	@Bean
	public MapperFactoryBean<MapperInterface> testMapper(SqlSessionFactory factory) throws Exception{
		MapperFactoryBean<MapperInterface> factoryBean = new MapperFactoryBean<MapperInterface>(MapperInterface.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
}
