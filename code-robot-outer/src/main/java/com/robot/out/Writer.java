package com.robot.out;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.StringUtils;

import com.robot.core.Applicaption;
import com.robot.core.config.PkgConfig;
import com.robot.core.launch.RobotGenerator;
import com.robot.core.util.PathPlanUtil;
import com.robot.core.util.SpringContextUtil;
import com.robot.out.cf.resource.ConfigFileWorker;
import com.robot.out.cf.root.RootFileWorker;
import com.robot.out.config.ProjectConfig;
import com.robot.out.doc.DocFileWorker;
import com.robot.out.mvn.MvnWorker;

public class Writer {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Applicaption.class, args);
		
		ProjectConfig config = SpringContextUtil.getBean(ProjectConfig.class);
		if((!StringUtils.isEmpty(config.getGroupId())) || (!StringUtils.isEmpty(config.getArtifactId()))) {
			if(StringUtils.isEmpty(config.getName())) {
				config.setName(config.getArtifactId());
			}
			
			String basePath = config.getName();
			if(!StringUtils.isEmpty(config.getRootPath())) {
				basePath = config.getRootPath() + File.separator + config.getName();
			}
			//设置项目目录
			PathPlanUtil.me().setRootPath(basePath);
			
			PkgConfig pkgConfig = SpringContextUtil.getBean(PkgConfig.class);
			MvnWorker mvnWorker = new MvnWorker();
			mvnWorker.work(pkgConfig);
			
			ConfigFileWorker configFileWorker = new ConfigFileWorker();
			configFileWorker.work(null);
			
			RootFileWorker rootFileWorker = new RootFileWorker();
			rootFileWorker.work(null);
		}
		
		RobotGenerator robot = SpringContextUtil.getBean(RobotGenerator.class);
		robot.execute();
		
		DocFileWorker docFileWorker = new DocFileWorker();
		docFileWorker.work(null);
		
		SpringApplication.exit(context, () -> {return 0;});
	}
}
