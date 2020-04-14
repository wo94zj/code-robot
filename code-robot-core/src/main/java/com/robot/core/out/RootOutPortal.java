package com.robot.core.out;

import org.springframework.stereotype.Component;

import com.robot.core.out.AbstractOutPortal;

@Component
public class RootOutPortal extends AbstractOutPortal {

	@Override
	protected String getBasePath() {
		return getRootPath();
	}
	
}
