package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {

	@Setter(onMethod_ = {@Autowired})
	private DataSource dataSource;
	
	@Setter(onMethod_ = {@Autowired})
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnextion() {
		try (SqlSession session = sqlSessionFactory.openSession();
				Connection conn = dataSource.getConnection()){
			log.info(session);
			log.info(conn);
		//try() -> () 내 작업들은 try-catch문 끝나면 자동으로 close 처리됨
			
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
