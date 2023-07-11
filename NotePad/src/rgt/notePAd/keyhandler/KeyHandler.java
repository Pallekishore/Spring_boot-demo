package rgt.notePAd.keyhandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	NotepadGUI notePadExample = new NotepadGUI();

	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
//			notePadExample.File.save();

		}
		if (e.isShiftDown() && e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
		//	notePadExample.File.saveAs();

		}
		if (e.isAltDown()  && e.getKeyCode() == KeyEvent.VK_F) {
			notePadExample.menuFile.doClick();

		}
	}

}
