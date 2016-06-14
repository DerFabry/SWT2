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
	private HandPanel handPanel;
	private BattlefieldPanel bfPanel;

	public GamePanel() {
		springLayout = new SpringLayout();
		textPane = new JTextPane();
		handPanel = new HandPanel();
		bfPanel = new BattlefieldPanel();

		setupPanel();
	}

	private void setupPanel() {
		setBackground(Color.PINK);
		setLayout(springLayout);
		
		this.add(handPanel);
		this.add(bfPanel);

		add(textPane);
		textPane.setBackground(Color.PINK);

		springLayout.putConstraint(SpringLayout.NORTH, textPane, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textPane, -198, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textPane, 386, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, textPane, -10, SpringLayout.EAST, this);
		
		springLayout.putConstraint(SpringLayout.NORTH, handPanel, -200, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, handPanel, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, handPanel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, handPanel, 0, SpringLayout.EAST, this);

		springLayout.putConstraint(SpringLayout.NORTH, bfPanel, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, bfPanel, 0, SpringLayout.WEST, handPanel);
		springLayout.putConstraint(SpringLayout.SOUTH, bfPanel, 0, SpringLayout.NORTH, handPanel);
		springLayout.putConstraint(SpringLayout.EAST, bfPanel, -300, SpringLayout.EAST, handPanel);

		textPane.setText(
				"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.");
	
	
	}
}
