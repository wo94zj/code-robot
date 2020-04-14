package com.robot.core.pkg;

import java.util.List;

/**
 * 构建需要生成的文件的创建者
 *
 */
public interface IFileCreatorBuilder {

	List<IFileCreator> builds();
	
	public static List<IFileCreator> builds(IFileCreatorBuilder builder) {
		return builder.builds();
	}
	
}