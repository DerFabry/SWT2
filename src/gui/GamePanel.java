package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class GamePanel extends JPanel {
	private SpringLayout springLayout;
	
	public GamePanel() {
		springLayout = new SpringLayout();
		setupPanel();
	}

	private void setupPanel() {
		setBackground(Color.PINK);
		setLayout(springLayout);
	}
}
