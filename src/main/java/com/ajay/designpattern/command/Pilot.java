package com.ajay.designpattern.command;

import javax.swing.JOptionPane;

/**
 * @author ajaykumar
 */
public class Pilot {
	private Cockpit cockpit;

	public Pilot(Cockpit cockpit) {
		this.cockpit = cockpit;
	}

	private String[] commands =

		{
			Cockpit.TAKE_OFF,
			Cockpit.LAND,
			EngineController.DECREASE_SPEED,
			EngineController.INCREASE_SPEED,
			WingController.MOVE_DOWN,
			WingController.MOVE_UP,
			WingController.MOVE_LEFT,
			WingController.MOVE_RIGHT

		};

	public void fly() {
		do {
			String command = (String) JOptionPane.showInputDialog(null, "Choose command", "Command Controls", JOptionPane.INFORMATION_MESSAGE, null, commands, commands[0]);
			cockpit.excecuteCommand(command);
		} while (true);
	}

}
