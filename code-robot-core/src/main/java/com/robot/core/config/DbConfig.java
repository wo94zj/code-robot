package com.robot.core.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.robot.core.exception.ExceptionUtil;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "db")
public class DbConfig {

	private String[] includeTables;
	
	@Autowired
	private DataSource dataSource;
	
	public String dbName() {
		try {
			return dataSource.getConnection().getMetaData().getDatabaseProductName();
		} catch (SQLException e) {
			throw ExceptionUtil.throwRE("cannot find dbName", e);
		}
		
	}
}
