package edu.examples.java_classes.util;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ClearFile {

	public static void clearFile() {
		try {
			FileWriter fstream1 = new FileWriter("resources/my_notes.txt");
			BufferedWriter out1 = new BufferedWriter(fstream1);
			out1.write("");
			out1.close();
		} catch (Exception e) {
			System.err.println("Error in file cleaning: " + e.getMessage());
		}
	}

}
