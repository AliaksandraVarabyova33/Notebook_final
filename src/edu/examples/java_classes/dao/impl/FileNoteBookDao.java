package edu.examples.java_classes.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;

public class FileNoteBookDao implements NoteBookDao {

	@Override
	public void save(Note n) throws DaoException {

		BufferedWriter bufWriter = null;

		try {
			bufWriter = new BufferedWriter(new FileWriter("resources/my_notes.txt", true));

			bufWriter.write(n.getId() + " " + n.getTitle() + " " + n.getContent() + " "
					+ new SimpleDateFormat("dd/MM/yyyy").format(n.getD()) + "\n");

		} catch (IOException e) {
			throw new DaoException("Notepad data not saved.", e);
		} finally {
			try {
				bufWriter.close();
			} catch (IOException e) {
				throw new DaoException("Stream was not closed", e);
			}
		}
	}

	@Override
	public List<Note> allNotes() throws DaoException {

		InputStreamReader reader = null;

		try {
			reader = new InputStreamReader(new FileInputStream("resources/my_notes.txt"), "UTF-8");
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			throw new DaoException("File was not found or encoding is not supported", e);
		}

		BufferedReader breader = new BufferedReader(reader);

		String line = null;
		List<Note> notes = new ArrayList<Note>();

		try {
			while ((line = breader.readLine()) != null) {
				String[] parts = line.split("\\s+");
				int id = Integer.parseInt(parts[0]);
				String title = parts[1];
				String content = parts[2];
				Date d = new SimpleDateFormat("dd/MM/yyyy").parse(parts[3]);
				notes.add(new Note(id, title, content, d));
			}
		} catch (IOException e) {
			throw new DaoException("Notes data was not extracted", e);
		} catch (ParseException e) {
			throw new DaoException("Error during parsing happened", e);
		} finally {
			try {
				breader.close();
			} catch (IOException e) {
				throw new DaoException("Stream was not closed", e);
			}
		}
		return notes;
	}

}
