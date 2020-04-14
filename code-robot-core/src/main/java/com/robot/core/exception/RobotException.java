package com.robot.core.exception;

public class RobotException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RobotException(String message) {
        super(message);
    }

    public RobotException(Throwable throwable) {
        super(throwable);
    }

    public RobotException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
