package com.ajay.designpattern.command;

import java.util.List;

/**
 * @author ajaykumar
 */
public class Cockpit implements ICommandController {

	public static final String TAKE_OFF = "TAKE_OFF";

	public static final String LAND = "LAND";

	private List<ICommandController> commandControlList;

	public Cockpit(List<ICommandController> commandControlList) {
		this.commandControlList = commandControlList;
		this.commandControlList.add(this);
	}

	private void land() {
		System.out.println("Landing the Flight----------");
		this.excecuteCommand(EngineController.DECREASE_SPEED);
		this.excecuteCommand(WingController.MOVE_DOWN);
		System.out.println("---------");
	}

	private void takeOff() {
		System.out.println("Flight Take Off operations---------");
		this.excecuteCommand(EngineController.INCREASE_SPEED);
		this.excecuteCommand(WingController.MOVE_UP);
		System.out.println("---------");
	}

	public void excecuteCommand(String commandInput) {
		if (commandInput == null) {
			System.out.println("\nShutting the engine down");
			this.land();
			System.exit(0);
		}

		for (ICommandController commandController : commandControlList) {

			if (commandController instanceof Cockpit) {
				switch (commandInput) {
					case Cockpit.TAKE_OFF:
						this.takeOff();
						break;
					case Cockpit.LAND:
						this.land();
						break;
				}
			} else if (commandController.canHandle(commandInput)) {
				commandController.excecuteCommand(commandInput);
			}
		}
	}

	public boolean canHandle(String commandInput) {
		return TAKE_OFF.equals(commandInput) || LAND.equals(commandInput);
	}
}
