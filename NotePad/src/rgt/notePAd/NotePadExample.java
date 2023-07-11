package rgt.notePAd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class NotePadExample implements ActionListener {
	JFrame f;
	JMenuBar mb;
	JMenu File, Edit, Search, View, Encoding, Language, Setting, Tools, Macro, Run, Plugins, Window, Help;
	JMenuItem cut, copy, paste, selectAll, open, save, close, New, Rename;
	JTextArea ta;

	NotePadExample() {
		f = new JFrame();

		cut = new JMenuItem("cut");
		copy = new JMenuItem("copy");
		paste = new JMenuItem("paste");
		selectAll = new JMenuItem("selectAll");
		open = new JMenuItem("open");
		save = new JMenuItem("save");
		close = new JMenuItem("close");
		New = new JMenuItem("New");
		Rename=new JMenuItem("Rename");
		
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		selectAll.addActionListener(this);
		
		open.addActionListener(this);
		save.addActionListener(this);
		close.addActionListener(this);
		New.addActionListener(this);
		Rename.addActionListener(this);

		mb = new JMenuBar();
		mb.setBounds(5, 5, 400, 40);

		File = new JMenu("File");
		Edit = new JMenu("Edit");
		Search = new JMenu("Search");
		View = new JMenu("View");
		Encoding = new JMenu("Encoding");
		Language = new JMenu("Language");
		Setting = new JMenu("Setting");
		Tools = new JMenu("Tools");
		Macro = new JMenu("Macro");
		Run = new JMenu("Run");
		Plugins = new JMenu("Plugins");
		Window = new JMenu("Window");
		Help = new JMenu("Help");

		Edit.add(cut);
		Edit.add(copy);
		Edit.add(paste);
		Edit.add(selectAll);
		
		File.add(open);
		File.add(close);
		File.add(save);
		File.add(New);
		File.add(Rename);
		

		mb.add(File);
		mb.add(Edit);
		mb.add(Search);
		mb.add(View);
		mb.add(Encoding);
		mb.add(Language);
		mb.add(Setting);
		mb.add(Tools);
		mb.add(Help);
		mb.add(Macro);
		mb.add(Run);
		mb.add(Plugins);
		mb.add(Window);
		ta = new JTextArea();
		ta.setBounds(5, 30, 460, 460);

		f.add(mb);
		f.add(ta);

		f.setLayout(null);
		f.setSize(500, 500);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cut)
			ta.cut();
		if (e.getSource() == paste)
			ta.paste();
		if (e.getSource() == copy)
			ta.copy();
		if (e.getSource() == selectAll)
			ta.selectAll();
		if (e.getSource() == open)
			ta.selectAll();
		if (e.getSource() == save)
			ta.selectAll();
		if (e.getSource() == close)
			ta.selectAll();
		if (e.getSource() == New)
			ta.selectAll();
		if (e.getSource() == Rename)
			ta.selectAll();
	}

	public static void main(String[] args) {
		new NotePadExample();
	}

}
