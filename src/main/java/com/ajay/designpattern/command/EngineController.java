package com.ajay.designpattern.command;

/**
 * @author ajaykumar
 */
public class EngineController implements ICommandController {

	public static final String INCREASE_SPEED = "INCREASE_SPEED";

	public static final String DECREASE_SPEED = "DECREASE_SPEED";

	private Engine engine;

	public EngineController() {
		this.engine = new Engine();
	}

	public void excecuteCommand(String commandInput) {

		switch (commandInput) {
			case INCREASE_SPEED:
				engine.increaseSpeed();
				break;
			case DECREASE_SPEED:
				engine.decreaseSpeed();
				break;
			default:
				System.out.println("Sorry, the input command is weird");

		}
	}

	public boolean canHandle(String commandInput) {
		return INCREASE_SPEED.equals(commandInput) || DECREASE_SPEED.equals(commandInput);
	}
}
