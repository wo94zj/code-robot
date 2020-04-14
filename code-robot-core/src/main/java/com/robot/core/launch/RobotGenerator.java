package com.robot.core.launch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.robot.core.db.DbPortal;
import com.robot.core.db.po.TableField;
import com.robot.core.db.po.TableInfo;
import com.robot.core.pkg.PkgPortal;

@Component
public class RobotGenerator {

    @Autowired
    private DbPortal dbPortal;
    @Autowired
    private PkgPortal pkgPortal;

    public void execute() {
        List<TableInfo> tables = dbPortal.listTables();
        if (CollectionUtils.isEmpty(tables)) {
            return;
        }

        for (TableInfo table : tables) {
            List<TableField> fields = dbPortal.tableFields(table.getName());
            pkgPortal.execute(dbPortal.typeConvert(), table, fields);
        }
    }
}
