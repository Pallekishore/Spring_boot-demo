package rgt.notePAd.keyhandler;

import java.awt.Font;

public class FunctionFormat {

	NotepadGUI gui;
	Font arial, comicSansMS, timesNewRomam;
	String selectedFont;

	public FunctionFormat(NotepadGUI gui) {
		this.gui = gui;
	}

	public void wordWrap() {
		if (gui.wordWrapOn == false) {
			gui.wordWrapOn = true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.iWarp.setText("Word Wrap:On");
		} else if (gui.wordWrapOn == true) {
			gui.wordWrapOn = false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.iWarp.setText("Word Wrap:Off");
		}
	}

	public void createFont(int fontSize) {
		arial = new Font("Arial", Font.PLAIN, fontSize);
		comicSansMS = new Font("Comic Sans Ms", Font.PLAIN, fontSize);
		timesNewRomam = new Font("Times New Roman", Font.PLAIN, fontSize);

		setFont(selectedFont);
	}

	public void setFont(String font) {
		selectedFont = font;
		switch (selectedFont) {
		case "Arial":
			gui.textArea.setFont(arial);
			break;
		case "Comic Sans Ms":
			gui.textArea.setFont(comicSansMS);
			break;
		case "Times New Roman":
			gui.textArea.setFont(timesNewRomam);
			break;
		}
	}
}/*
package OnLineShoppingSystem;

import java.awt.Font;

import rgt.notePAd.keyhandler.NotepadGUI;

public class FunctionFormat {

	NotepadGUI gui;
	Font arial, comicSansMS, timesNewRomam;
	String selectedFont;

	public FunctionFormat(NotepadGUI gui) {
		this.gui = gui;
	}

	public void wordWrap() {
		if (gui.wordWrapOn == false) {
			gui.wordWrapOn = true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.iWarp.setText("Word Wrap:On");
		} else if (gui.wordWrapOn == true) {
			gui.wordWrapOn = false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.iWarp.setText("Word Wrap:Off");
		}
	}

	public void createFont(int fontSize) {
		arial = new Font("Arial", Font.PLAIN, fontSize);
		comicSansMS = new Font("Comic Sans Ms", Font.PLAIN, fontSize);
		timesNewRomam = new Font("Times New Roman", Font.PLAIN, fontSize);

		setFont(selectedFont);
	}

	public void setFont(String font) {
		selectedFont = font;
		switch (selectedFont) {
		case "Arial":
			gui.textArea.setFont(arial);
			break;
		case "Comic Sans Ms":
			gui.textArea.setFont(comicSansMS);
			break;
		case "Times New Roman":
			gui.textArea.setFont(timesNewRomam);
			break;
		}
	}
}
*/
