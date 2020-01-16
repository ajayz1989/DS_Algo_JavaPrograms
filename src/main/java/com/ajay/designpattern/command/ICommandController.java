package com.ajay.designpattern.command;

/**
 * @author ajaykumar
 */
public interface ICommandController {

	void excecuteCommand(String commandInput);

	boolean canHandle(String commandInput);
}
