package com.robot.keeper.db.mysql;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import com.robot.core.util.SpringContextUtil;

@ActiveProfiles("robot")
@SpringBootTest
public class MySqlQueryTest {

	@Test
	public void sqlTest() {
		JdbcTemplate jdbc = SpringContextUtil.getBean(JdbcTemplate.class);
		/**
		 * org.springframework.jdbc.BadSqlGrammarException: PreparedStatementCallback; bad SQL grammar [show full fields from ?]; 
		 * nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; 
		 * check the manual that corresponds to your MySQL server version for the right syntax to use near ''mc_account'' at line 1
		 */
		List<String> query = jdbc.query("show full fields from ?", new Object[] {"mc_account"}, (rs,n) -> {
			return rs.getString("field");
		});
		
		System.out.println(query);
	}
}
