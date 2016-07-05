package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SpringLayout;

public class HandPanel extends JPanel {

	JButton button_1, button_2, button_3, button_4, button_5, button_6;
	CardPanel cardPanel1, cardPanel2, cardPanel3, cardPanel4, cardPanel5;
	SpringLayout springLayout;
	int cardWidth;

	public HandPanel() {
		springLayout = new SpringLayout();

		button_1 = new JButton("Richte Kanone aus");
		button_2 = new JButton("Kaufe Schiffe");
		button_3 = new JButton("Kaufe Kanonen");
		button_4 = new JButton("Mache Versprechungen");
		button_5 = new JButton("Kaufe Karte");
		button_6 = new JButton("Spiele Karte");

		cardPanel1 = new CardPanel();
		cardPanel2 = new CardPanel();
		cardPanel3 = new CardPanel();
		cardPanel4 = new CardPanel();
		cardPanel5 = new CardPanel();

		cardWidth = 130;

		setupPanel();
	}

	private void setupPanel() {
		setBackground(new Color(210, 180, 140));

		setLayout(springLayout);

		add(button_1);
		add(button_2);
		add(button_3);
		add(button_4);
		add(button_5);
		add(button_6);

		add(cardPanel1);
		add(cardPanel2);
		add(cardPanel3);
		add(cardPanel4);
		add(cardPanel5);

		springLayout.putConstraint(SpringLayout.NORTH, button_1, 0, SpringLayout.NORTH, button_4);
		springLayout.putConstraint(SpringLayout.EAST, button_1, -20, SpringLayout.WEST, button_4);
		springLayout.putConstraint(SpringLayout.WEST, button_1, -200, SpringLayout.EAST, button_1);

		springLayout.putConstraint(SpringLayout.NORTH, button_2, 0, SpringLayout.NORTH, button_5);
		springLayout.putConstraint(SpringLayout.WEST, button_2, 0, SpringLayout.WEST, button_1);
		springLayout.putConstraint(SpringLayout.EAST, button_2, 0, SpringLayout.EAST, button_1);

		springLayout.putConstraint(SpringLayout.NORTH, button_3, 0, SpringLayout.NORTH, button_6);
		springLayout.putConstraint(SpringLayout.WEST, button_3, 0, SpringLayout.WEST, button_2);
		springLayout.putConstraint(SpringLayout.EAST, button_3, 0, SpringLayout.EAST, button_2);

		springLayout.putConstraint(SpringLayout.NORTH, button_4, 20, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, button_4, -230, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, button_4, -30, SpringLayout.EAST, this);

		springLayout.putConstraint(SpringLayout.NORTH, button_5, 10, SpringLayout.SOUTH, button_4);
		springLayout.putConstraint(SpringLayout.WEST, button_5, 0, SpringLayout.WEST, button_4);
		springLayout.putConstraint(SpringLayout.EAST, button_5, 0, SpringLayout.EAST, button_4);

		springLayout.putConstraint(SpringLayout.NORTH, button_6, 10, SpringLayout.SOUTH, button_5);
		springLayout.putConstraint(SpringLayout.WEST, button_6, 0, SpringLayout.WEST, button_4);
		springLayout.putConstraint(SpringLayout.EAST, button_6, 0, SpringLayout.EAST, button_4);

		springLayout.putConstraint(SpringLayout.NORTH, cardPanel1, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, cardPanel1, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, cardPanel1, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, cardPanel1, cardWidth, SpringLayout.WEST, cardPanel1);


		springLayout.putConstraint(SpringLayout.NORTH, cardPanel2, 0, SpringLayout.NORTH, cardPanel1);
		springLayout.putConstraint(SpringLayout.SOUTH, cardPanel2, 0, SpringLayout.SOUTH, cardPanel1);
		springLayout.putConstraint(SpringLayout.WEST, cardPanel2, 10, SpringLayout.EAST, cardPanel1);
		springLayout.putConstraint(SpringLayout.EAST, cardPanel2, cardWidth, SpringLayout.WEST, cardPanel2);


		springLayout.putConstraint(SpringLayout.NORTH, cardPanel3, 0, SpringLayout.NORTH, cardPanel2);
		springLayout.putConstraint(SpringLayout.SOUTH, cardPanel3, 0, SpringLayout.SOUTH, cardPanel2);
		springLayout.putConstraint(SpringLayout.WEST, cardPanel3, 10, SpringLayout.EAST, cardPanel2);
		springLayout.putConstraint(SpringLayout.EAST, cardPanel3, cardWidth, SpringLayout.WEST, cardPanel3);


		springLayout.putConstraint(SpringLayout.NORTH, cardPanel4, 0, SpringLayout.NORTH, cardPanel3);
		springLayout.putConstraint(SpringLayout.SOUTH, cardPanel4, 0, SpringLayout.SOUTH, cardPanel3);
		springLayout.putConstraint(SpringLayout.WEST, cardPanel4, 10, SpringLayout.EAST, cardPanel3);
		springLayout.putConstraint(SpringLayout.EAST, cardPanel4, cardWidth, SpringLayout.WEST, cardPanel4);

		springLayout.putConstraint(SpringLayout.NORTH, cardPanel5, 0, SpringLayout.NORTH, cardPanel4);
		springLayout.putConstraint(SpringLayout.SOUTH, cardPanel5, 0, SpringLayout.SOUTH, cardPanel4);
		springLayout.putConstraint(SpringLayout.WEST, cardPanel5, 10, SpringLayout.EAST, cardPanel4);
		springLayout.putConstraint(SpringLayout.EAST, cardPanel5, cardWidth, SpringLayout.WEST, cardPanel5);

	}

}
