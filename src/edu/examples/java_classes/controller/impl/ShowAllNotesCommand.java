package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NoteBookLogic;

public class ShowAllNotesCommand implements Command {

	private final NoteBookLogic logic = LogicProvider.getInstance().getNoteBookLogic();

	@Override
	public String execute(String request) {

		String response = "";

		try {
			response = "The list of notes:\n" + logic.allNotes().toString();
		} catch (LogicException e) {
			// log
			response = "Error!!!";
		}

		return response;
	}

}
