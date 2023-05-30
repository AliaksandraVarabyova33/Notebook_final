package edu.examples.java_classes.input;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.examples.java_classes.entity.Note;

public class Display {
	
	public void printMenu(ConcreteMenu m) {
		//System.out.println(m.getTitle());
		
		Set<Map.Entry<Integer, String>> items = m.getItems();
		for(Map.Entry<Integer, String> item : items) {
			System.out.println(item.getKey() + " " + item.getValue());
		}
	}
	
	public void printNotes(List<Note> notes) {

		if (notes == null || notes.size() == 0) {
			System.out.println("No notes found");
		}

		for (Note n : notes) {
			System.out.println(n);
		}

	}

}
