package edu.examples.java_classes.input.command.impl;

import java.util.Scanner;

import edu.examples.java_classes.controller.Controller;
import edu.examples.java_classes.input.command.Command;

public class ConsoleFindItemByContent implements Command {

	private Controller controller = Controller.getInstance();

	@Override
	public void execute() {

		String content;

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter content > ");
		content = sc.nextLine();

		String request = "FIND_BY_CONTENT content=" + content;

		// ----------------------------------------------

		String response;

		response = controller.doAction(request);

		// ----------------------------------------------------------

		System.out.println(response);

	}

}
