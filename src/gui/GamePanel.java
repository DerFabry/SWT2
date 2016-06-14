package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class GamePanel extends JPanel {
	private SpringLayout springLayout;
	private JTextPane textPane;

	public GamePanel() {
		springLayout = new SpringLayout();
		textPane = new JTextPane();
		setupPanel();
	}

	private void setupPanel() {
		setBackground(Color.PINK);
		setLayout(springLayout);

		add(textPane);
		textPane.setBackground(Color.PINK);

		springLayout.putConstraint(SpringLayout.NORTH, textPane, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textPane, -198, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textPane, 386, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, textPane, -10, SpringLayout.EAST, this);

		textPane.setText(
				"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.");
	}
}
