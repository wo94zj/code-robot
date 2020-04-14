package com.robot.out.doc.creator;

import com.robot.core.pkg.IFileCreator;
import com.robot.core.pkg.IFileCreatorBuilder;
import com.robot.out.doc.creator.impl.ApiCreator;

import java.util.ArrayList;
import java.util.List;

public class DocFileCreatorBuilder implements IFileCreatorBuilder {

    @Override
    public List<IFileCreator> builds() {
        List<IFileCreator> list = new ArrayList<>();
        list.add(new ApiCreator());
        return list;
    }
}
