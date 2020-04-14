package com.robot.keeper.launch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.robot.core.launch.RobotGenerator;

@ActiveProfiles("robot")
@SpringBootTest
public class RobotGeneratorTest {

	@Autowired
	private RobotGenerator robotGenerator;
	
	@Test
	public void executeTest() {
		robotGenerator.execute();
	}
	
}
