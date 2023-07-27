package com.iu.main.di;

public class Robot {

	private static Robot robot;
	
//	private Arm arm;
	private String name;
	
	
	private Robot() {
		
	}
	
//	Singletone
//	객체를 딱 한개만 만듬
	public static Robot getInstance() {
		if(robot==null) {
			Robot.robot = new Robot();
		}
		return Robot.robot;
	}
	
}
