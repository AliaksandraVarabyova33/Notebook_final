package edu.examples.java_classes.controller.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NoteBookLogic;

public class FindByDateCommand implements Command {

	private final NoteBookLogic logic = LogicProvider.getInstance().getNoteBookLogic();

	@Override
	public String execute(String request) {

		String[] params = request.split("\\s+");

		String date = params[1].split("=")[1];

		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("dd.MM.yyyy");

		Date dateAfterParsing = null;
		String response = "";

		try {
			dateAfterParsing = format.parse(date);
			response = "The list of found notes:\n" + logic.find(dateAfterParsing).toString();

		} catch (ParseException e1) {
			System.out.println("You entered date in the wrong format");
		} catch (LogicException e) {
			// log
			response = "Error!!!";
		}

		return response;
	}

}
