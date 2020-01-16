package com.ajay.designpattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ajaykumar
 */
public class MainApp {
	public static void main(String[] args) {
		WingController wingController = new WingController();
		EngineController engineController = new EngineController();
		List<ICommandController> commandControllers = new ArrayList();
		commandControllers.add(wingController);
		commandControllers.add(engineController);

		Cockpit cockpit = new Cockpit(commandControllers);
		Pilot pilot = new Pilot(cockpit);
		pilot.fly();

	}
}
