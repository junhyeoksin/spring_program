package org.zerock.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)  //테스트 코드
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Test
	public void testConnection() {
		try {
			Connection con = ds.getConnection();  
			log.info("test메시지입니다.... :" + con);
		}catch(Exception e) {
			log.error(e.getMessage());
		}
	}
	@Test
	public void testConnection2() {
		try {
			SqlSession session = sessionFactory.openSession();
			Connection con = ds.getConnection();  
			log.info("테스트 session코드 ....:" + session);
			log.info("테스트 con 코드 ....:" + con);
				
				
				
		}catch(Exception e) {
			 e.printStackTrace();
		}
	 
	}
}
