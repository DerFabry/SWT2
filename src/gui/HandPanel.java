package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class HandPanel extends JPanel {

	JButton canonButton, buyShipButton, buyCanonButton, makePromisesButton, buyCardButton, playCardButton;
	CardPanel cardPanel1, cardPanel2, cardPanel3, cardPanel4, cardPanel5;
	List<CardPanel> hand = new ArrayList<CardPanel>();
	SpringLayout springLayout;
	int cardWidth;

	public HandPanel() {
		springLayout = new SpringLayout();

		canonButton = new JButton("Richte Kanone aus");
		buyShipButton = new JButton("Kaufe Schiffe");
		buyCanonButton = new JButton("Kaufe Kanonen");
		makePromisesButton = new JButton("Mache Versprechungen");
		buyCardButton = new JButton("Kaufe Karte");
		playCardButton = new JButton("Spiele Karte");

		cardPanel1 = new CardPanel();
		cardPanel2 = new CardPanel();
		cardPanel3 = new CardPanel();
		cardPanel4 = new CardPanel();
		cardPanel5 = new CardPanel();

		cardWidth = 130;

		hand.add(cardPanel1);
		hand.add(cardPanel2);
		hand.add(cardPanel3);
		hand.add(cardPanel4);
		hand.add(cardPanel5);

		setupPanel();
	}

	private void setupPanel() {
		setBackground(new Color(210, 180, 140));

		setLayout(springLayout);

		add(canonButton);
		add(buyShipButton);
		add(buyCanonButton);
		add(makePromisesButton);
		add(buyCardButton);
		add(playCardButton);

		add(cardPanel1);
		add(cardPanel2);
		add(cardPanel3);
		add(cardPanel4);
		add(cardPanel5);
		
	canonButton.addActionListener(new CanonButtonListener());
//		buyShipButton.addActionListener(new BuyShipButtonListener());
//		buyCanonButton.addActionListener(new BuyCanonButtonListener());
//		makePromisesButton.addActionListener(new MakePromisesButtonListener());
//		buyCardButton.addActionListener(new BuyCardButtonListener());
//		playCardButton.addActionListener(new PlayCardButtonListener());

		springLayout.putConstraint(SpringLayout.NORTH, canonButton, 0, SpringLayout.NORTH, makePromisesButton);
		springLayout.putConstraint(SpringLayout.EAST, canonButton, -20, SpringLayout.WEST, makePromisesButton);
		springLayout.putConstraint(SpringLayout.WEST, canonButton, -200, SpringLayout.EAST, canonButton);

		springLayout.putConstraint(SpringLayout.NORTH, buyShipButton, 0, SpringLayout.NORTH, buyCardButton);
		springLayout.putConstraint(SpringLayout.WEST, buyShipButton, 0, SpringLayout.WEST, canonButton);
		springLayout.putConstraint(SpringLayout.EAST, buyShipButton, 0, SpringLayout.EAST, canonButton);

		springLayout.putConstraint(SpringLayout.NORTH, buyCanonButton, 0, SpringLayout.NORTH, playCardButton);
		springLayout.putConstraint(SpringLayout.WEST, buyCanonButton, 0, SpringLayout.WEST, buyShipButton);
		springLayout.putConstraint(SpringLayout.EAST, buyCanonButton, 0, SpringLayout.EAST, buyShipButton);

		springLayout.putConstraint(SpringLayout.NORTH, makePromisesButton, 20, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, makePromisesButton, -230, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, makePromisesButton, -30, SpringLayout.EAST, this);

		springLayout.putConstraint(SpringLayout.NORTH, buyCardButton, 10, SpringLayout.SOUTH, makePromisesButton);
		springLayout.putConstraint(SpringLayout.WEST, buyCardButton, 0, SpringLayout.WEST, makePromisesButton);
		springLayout.putConstraint(SpringLayout.EAST, buyCardButton, 0, SpringLayout.EAST, makePromisesButton);

		springLayout.putConstraint(SpringLayout.NORTH, playCardButton, 10, SpringLayout.SOUTH, buyCardButton);
		springLayout.putConstraint(SpringLayout.WEST, playCardButton, 0, SpringLayout.WEST, makePromisesButton);
		springLayout.putConstraint(SpringLayout.EAST, playCardButton, 0, SpringLayout.EAST, makePromisesButton);

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

		updateHand();
	}

	public void updateHand() {
		int limit = 4;
		int count = 0;
		Iterator<CardPanel> it = hand.iterator();
		while (it.hasNext()) {
			CardPanel cp = it.next();
			if (count < limit) {
				cp.setVisible(true);
			} else {
				cp.setVisible(false);
			}
			count++;
		}
	}

}
