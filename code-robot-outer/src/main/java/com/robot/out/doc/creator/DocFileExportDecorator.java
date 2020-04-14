package com.robot.out.doc.creator;

import com.robot.core.pkg.IFileCreator;
import com.robot.core.pkg.IFileCreatorBuilder;

import java.util.List;

public class DocFileExportDecorator extends AbstractDocFileExport {

    @Override
    public void out(String pkg, String module, String temp) {
        List<IFileCreator> creators = IFileCreatorBuilder.builds(new DocFileCreatorBuilder());

        out(creators, pkg, module, temp);
    }
}
