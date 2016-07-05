package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.text.BadLocationException;

public class PlayCardButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton jb	= (JButton) e.getSource();
		GamePanel gp = (GamePanel) jb.getParent().getParent();
		try {
			gp.textPaneAppendString("Button \"Karte spielen\" gedr�ckt");
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
