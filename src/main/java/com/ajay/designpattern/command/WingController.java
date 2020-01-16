package com.ajay.designpattern.command;

/**
 * @author ajaykumar
 */
public class WingController implements ICommandController {

	public static final String MOVE_UP = "MOVE_UP";

	public static final String MOVE_DOWN = "MOVE_DOWN";

	public static final String MOVE_LEFT = "MOVE_LEFT";

	public static final String MOVE_RIGHT = "MOVE_RIGHT";

	private Wings wings;

	public WingController() {
		this.wings = new Wings();
	}

	public void excecuteCommand(String commandInput) {
		switch (commandInput) {
			case MOVE_UP:
				wings.moveUp();
				break;
			case MOVE_DOWN:
				wings.moveDown();
				break;
			case MOVE_LEFT:
				wings.moveLeft();
				break;
			case MOVE_RIGHT:
				wings.moveRight();
				break;
			default:
				System.out.println("Sorry, the input command is weird");
		}

	}

	public boolean canHandle(String commandInput) {
		return commandInput.equals(MOVE_DOWN) ||
			commandInput.equals(MOVE_UP) ||
			commandInput.equals(MOVE_RIGHT) ||
			commandInput.equals(MOVE_LEFT);
	}
}
