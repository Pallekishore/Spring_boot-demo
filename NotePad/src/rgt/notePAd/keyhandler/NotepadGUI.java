package rgt.notePAd.keyhandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NotepadGUI implements ActionListener {
	JFrame window;
	// Text Area
	JTextArea textArea;
	JScrollPane scrollPane;
	boolean wordWrapOn = false;
//TOP MENU BAR
	JMenuBar menuBar;
	JMenu menuFile, menuEdit, menuFormat, menuColor, Search, View, Encoding, Language, Setting, Tools, Macro, Run,
			Plugins, Window, Help;
//FILE MENU
	JMenuItem New, open, save, saveAs, close, exit, cut, copy, paste, selectAll, Rename;
	// FORMAT MENU
	JMenuItem iWarp, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24,
			iFontSize28;
	JMenu menuFont, menuFontSize;

	Functioning functioning = new Functioning(this);
	FunctionFormat format = new FunctionFormat(this);

	public static void main(String[] args) {
		new NotepadGUI();
	}

	public NotepadGUI() {
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createFormatMenu();
		format.selectedFont="Arial";
		format.createFont(16);
		format.wordWrap();
		window.setVisible(true);
	}

	private void createWindow() {
		window = new JFrame("Notepadd++");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void createTextArea() {
		textArea = new JTextArea();
		// for to show vertical and horizontal scroll bar when its needed
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// to set the Border
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
	}

	// to create menu bar list
	public void createMenuBar() {
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);

		menuFile = new JMenu("File");
		menuBar.add(menuFile);

		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);

		menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);

		menuColor = new JMenu("Color");
		menuBar.add(menuColor);

		Search = new JMenu("Search");
		menuBar.add(Search);

		View = new JMenu("View");
		menuBar.add(View);

		Encoding = new JMenu("Encoding");
		menuBar.add(Encoding);

		Language = new JMenu("Language");
		menuBar.add(Language);

		Setting = new JMenu("Setting");
		menuBar.add(Setting);

		Tools = new JMenu("Tools");
		menuBar.add(Tools);

		Macro = new JMenu("Macro");
		menuBar.add(Macro);

		Run = new JMenu("Run");
		menuBar.add(Run);

		Plugins = new JMenu("Plugins");
		menuBar.add(Plugins);

		Window = new JMenu("Window");
		menuBar.add(Window);

		Help = new JMenu("Help");
		menuBar.add(Help);

	}

// To created sub menu list to main menu
	public void createFileMenu() {
		New = new JMenuItem("New");
		New.addActionListener(this);
		New.setActionCommand("New");// to set string value to trigger the action listener
		menuFile.add(New);

		open = new JMenuItem("Open");
		open.addActionListener(this);
		open.setActionCommand("Open");
		menuFile.add(open);

		save = new JMenuItem("Save");
		save.addActionListener(this);
		save.setActionCommand("Save");
		menuFile.add(save);

		saveAs = new JMenuItem("SaveAs");
		saveAs.addActionListener(this);
		saveAs.setActionCommand("SaveAs");
		menuFile.add(saveAs);

		close = new JMenuItem("Close");
		close.addActionListener(this);
		close.setActionCommand("Close");
		menuFile.add(close);

		Rename = new JMenuItem("Rename");
		Rename.addActionListener(this);
		Rename.setActionCommand("Rename");
		menuFile.add(Rename);

		exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		exit.setActionCommand("Exit");
		menuFile.add(exit);

	}

	public void createFormatMenu() {
		iWarp = new JMenuItem("Word Wrap: Off");
		iWarp.addActionListener(this);
		iWarp.setActionCommand("Word Wrap");
		menuFormat.add(iWarp);

		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);

		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);

		iFontCSMS = new JMenuItem("Comic Sans Ms");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans Ms");
		menuFont.add(iFontCSMS);

		iFontTNR = new JMenuItem("Times New Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times New Roman");
		menuFont.add(iFontTNR);

		menuFontSize = new JMenu("Font Size");
		menuFormat.add(menuFontSize);

		iFontSize8 = new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("Times New Roman");
		menuFontSize.add(iFontSize8);

		iFontSize12 = new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("Times New Roman");
		menuFontSize.add(iFontSize12);

		iFontSize16 = new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("Times New Roman");
		menuFontSize.add(iFontSize16);

		iFontSize20 = new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("Times New Roman");
		menuFontSize.add(iFontSize20);

		iFontSize24 = new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("Times New Roman");
		menuFontSize.add(iFontSize24);

		iFontSize28 = new JMenuItem("28");
		iFontSize28.addActionListener(this);
		iFontSize28.setActionCommand("Times New Roman");
		menuFontSize.add(iFontSize28);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		case "New":
			functioning.newFile();
			break;
		case "Open":
			functioning.open();
			break;
		case "Save":
			functioning.save();
			break;
		case "SaveAs":
			functioning.saveAs();
			break;
		case "Rename":
			functioning.saveAs();
			break;

		case "Exit":
			functioning.exit();
			break;
		case "Word Wrap":
			format.wordWrap();
			break;
		case "Arial":
			format.setFont(command);
			break;
		case "Comic Sans Ms":
			format.setFont(command);
			break;
		case "Times New Roman":
			format.setFont(command);
			break;
		case "size8":
			format.createFont(8);
			break;
		case "size12":
			format.createFont(12);
			break;
		case "size16":
			format.createFont(16);
			break;
		case "size20":
			format.createFont(20);
			break;
		case "size24":
			format.createFont(24);
			break;
		case "size28":
			format.createFont(28);
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + command);
		}
		/*
		 * if (e.getSource() == cut) ta.cut(); if (e.getSource() == paste) ta.paste();
		 * if (e.getSource() == copy) ta.copy(); if (e.getSource() == selectAll)
		 * ta.selectAll(); if (e.getSource() == open) ta.selectAll(); if (e.getSource()
		 * == save) ta.selectAll(); if (e.getSource() == close) ta.selectAll(); if
		 * (e.getSource() == New) ta.selectAll(); if (e.getSource() == Rename)
		 * ta.selectAll(); }
		 * 
		 * }
		 */

	}
}

/*
 * NotePadExample() { f = new JFrame(); cut = new JMenuItem("cut"); copy = new
 * JMenuItem("copy"); paste = new
 * 
 * cut.addActionListener(this); copy.addActionListener(this);
 * paste.addActionListener(this); selectAll.addActionListener(this);
 * open.addActionListener(this); save.addActionListener(this);
 * close.addActionListener(this); New.addActionListener(this);
 * Rename.addActionListener(this); mb = new JMenuBar(); mb.setBounds(5, 5, 400,
 * 40);
 * 
 * Edit.add(cut); Edit.add(copy); Edit.add(paste); Edit.add(selectAll);
 * 
 * File.add(open); File.add(close); File.add(save); File.add(New);
 * File.add(Rename);
 * 
 * 
 * ta = new JTextArea(); ta.setBounds(5, 30, 460, 460);
 * 
 * f.add(mb); f.add(ta);
 * 
 * f.setLayout(null); f.setSize(500, 500); f.setVisible(true); }
 * 
 * }
 */
