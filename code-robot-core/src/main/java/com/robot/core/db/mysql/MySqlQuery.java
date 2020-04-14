package com.robot.core.db.mysql;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.robot.core.db.IDbQuery;
import com.robot.core.db.po.TableField;
import com.robot.core.db.po.TableInfo;
import com.robot.core.util.SpringContextUtil;

public class MySqlQuery implements IDbQuery {

	@Override
	public List<TableInfo> tableList() {
		JdbcTemplate jdbc = SpringContextUtil.getBean(JdbcTemplate.class);
		List<TableInfo> tables = jdbc.query("show table status", (rs, n) -> {
			TableInfo table = new TableInfo(rs.getString("name"), rs.getString("comment"));
			return table;
		});
		return tables;
	}

	@Override
	public List<TableField> tableField(String tableName) {
		JdbcTemplate jdbc = SpringContextUtil.getBean(JdbcTemplate.class);
		List<TableField> fields = jdbc.query("show full fields from " + tableName, (rs, n) -> {
			String key = rs.getString("key");
			String extra = rs.getString("extra");
			TableField field = new TableField("PRI".equals(key) ? true : false,
					"auto_increment".equals(extra) ? true : false, rs.getString("field"), rs.getString("type"),
					rs.getString("default"), rs.getString("comment"));
			return field;
		});
		return fields;
	}

}
