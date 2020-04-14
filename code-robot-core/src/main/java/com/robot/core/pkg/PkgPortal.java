package com.robot.core.pkg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.robot.core.config.PkgConfig;
import com.robot.core.db.ITypeConvert;
import com.robot.core.db.po.TableField;
import com.robot.core.db.po.TableInfo;
import com.robot.core.pkg.config.ConfigWorker;
import com.robot.core.pkg.model.ModelWorker;
import com.robot.core.pkg.resp.RespWorker;
import com.robot.core.pkg.util.UtilWorker;

@Component
public class PkgPortal {

    @Autowired
    private PkgConfig pkgConfig;

    public void execute(ITypeConvert typeConvert, TableInfo table, List<TableField> fields) {
        ModelWorker modelWorker = new ModelWorker();
        modelWorker.setTypeConvert(typeConvert);
        modelWorker.work(pkgConfig, table, fields);

        RespWorker respWorker = new RespWorker();
        respWorker.work(pkgConfig);


        UtilWorker utilWorker = new UtilWorker();
        utilWorker.work(pkgConfig);

        ConfigWorker configWorker = new ConfigWorker();
        configWorker.work(pkgConfig);
    }

}
