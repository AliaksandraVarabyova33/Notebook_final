package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NoteBookLogic;

public class FindByContentCommand implements Command {

	private final NoteBookLogic logic = LogicProvider.getInstance().getNoteBookLogic();

	@Override
	public String execute(String request) {
		String[] params = request.split("\\s+");

		String content = params[1].split("=")[1];

		String response = "";

		try {
			response = "The list of found notes:\n" + logic.find(content).toString();
		} catch (LogicException e) {
			// log
			response = "Error!!!";
		}

		return response;
	}

}
