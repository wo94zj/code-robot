package com.robot.out.doc;

import com.robot.core.config.PkgConfig;
import com.robot.out.doc.creator.DocFileExportDecorator;

/**
 * 文档生成
 */
public class DocFileWorker {

    public void work(PkgConfig pkgConfig){
        DocFileExportDecorator decorator = new DocFileExportDecorator();
        decorator.out(null, null, null);
    }
}
