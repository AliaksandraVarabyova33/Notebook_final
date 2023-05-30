package edu.examples.java_classes.start;

import edu.examples.java_classes.input.ConsoleMenu;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.util.ClearFile;

public class Main {

	public static void main(String[] args) throws LogicException {

		ClearFile.clearFile();

		ConsoleMenu menu = new ConsoleMenu();

		menu.execute();

	}

}
