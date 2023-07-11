package rgt.notePAd.keyhandler;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class Functioning {
	NotepadGUI notepadGUI;
	String fileName;
	String fileAddress;
	private JFileChooser fileChooser;
	private JTextField textField;

	public Functioning(NotepadGUI notepadGUI) {
		this.notepadGUI = notepadGUI;

	}

	public void newFile() {
		notepadGUI.textArea.setText("");
		notepadGUI.window.setTitle("New");
		// to reset filename at the time of new window
		fileName = null;
		fileAddress = null;
	}

	public void open() {
		FileDialog fileDialog = new FileDialog(notepadGUI.window, "Open", FileDialog.LOAD);
		fileDialog.setVisible(true);
		if (fileDialog.getFile() != null) {
			fileName = fileDialog.getFile();
			fileAddress = fileDialog.getDirectory();
			notepadGUI.window.setTitle(fileName);
		}
		System.out.println("File Address:  " + fileAddress + "\nFile Name:  " + fileName);
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));// need the address to read a
																							// file
			notepadGUI.textArea.setText("");
			String line = null;
			// to get total data from file
			while ((line = br.readLine()) != null) {
				notepadGUI.textArea.append(line + "\n");
			}
			br.close();
		} catch (Exception e) {
			System.out.println("FILE NOT OPENED");
		}

	}

	public void save() {
		if (fileName == null) {
			saveAs();// new file
		} else {
			// working on existing file so try to override file
			try {
				FileWriter fileWriter = new FileWriter(fileAddress + fileName);
				fileWriter.write(notepadGUI.textArea.getText());
				notepadGUI.window.setTitle(fileName);
				fileWriter.close();

			} catch (Exception e) {
				System.out.println("SOMETHING WRONG!");
			}

		}
	}

	public void saveAs() {
		FileDialog fileDialog = new FileDialog(notepadGUI.window, "Save", FileDialog.SAVE);
		fileDialog.setVisible(true);
		if (fileDialog.getFile() != null) {
			fileName = fileDialog.getFile();
			fileAddress = fileDialog.getDirectory();
			notepadGUI.window.setTitle(fileName);//
		}
		try {
			FileWriter fileWriter = new FileWriter(fileAddress + fileName);
			fileWriter.write(notepadGUI.textArea.getText());
			fileWriter.close();

		} catch (Exception e) {
			System.out.println("SOMETHING WRONG!");
		}
	}

	public void Rename() {

		try {

			String newFileName = textField.getText();
			File oldFile = new File(fileChooser.getSelectedFile(), null);
			File newFileOrDirectoryName = new File(newFileName);

			if (oldFile.exists()) {
				if (oldFile.renameTo(newFileOrDirectoryName)) {
				FileWriter fileWriter = new FileWriter(fileAddress + fileName);
				fileWriter.write(notepadGUI.textArea.getText());
				notepadGUI.window.setTitle(fileName);
					System.out.println("File renamed successfully");
					fileWriter.close();

				} else {
					System.out.println("Failed to rename the file.");
				}
			}
		} catch (Exception e) {
			System.out.println("SOMETHING WRONG!");
		}
	}

	public void exit() {
		System.out.println(0);
	}
}
