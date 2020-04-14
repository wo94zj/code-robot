package com.robot.out.cf.resource.creator.impl;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import com.robot.core.pkg.AbstractCommonCreator;
import com.robot.core.util.SpringContextUtil;
import com.robot.out.constant.ExtendKeyConst;
import com.zaxxer.hikari.HikariDataSource;

public class YmlCreator extends AbstractCommonCreator {

	@Override
	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<>();
		
		HikariDataSource dataSource = (HikariDataSource) SpringContextUtil.getBean(DataSource.class);
		
		map.put(ExtendKeyConst.JDBC_URL, dataSource.getJdbcUrl());
		map.put(ExtendKeyConst.JDBC_USERNAME, dataSource.getUsername());
		map.put(ExtendKeyConst.JDBC_PASSWORD, dataSource.getPassword());
		map.put(ExtendKeyConst.JDBC_DRIVERNAME, dataSource.getDriverClassName());
		
		return map;
	}
	
	@Override
	public String name() {
		return "application.yml";
	}

}
