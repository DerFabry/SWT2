package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import com.sun.xml.internal.bind.v2.model.core.Adapter;

import spieler.Spieler;

public class HandPanel extends JPanel {

	JButton canonButton, buyShipButton, buyCanonButton, makePromisesButton, buyCardButton, playCardButton;
	CardPanel cardPanel1, cardPanel2, cardPanel3, cardPanel4, cardPanel5, cardPanel6, cardPanel7, cardPanel8, cardPanel9, cardPanel10;
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
		cardPanel6 = new CardPanel();
		cardPanel7 = new CardPanel();
		cardPanel8 = new CardPanel();
		cardPanel9= new CardPanel();
		cardPanel10 = new CardPanel();

		cardWidth = 130;

		hand.add(cardPanel1);
		hand.add(cardPanel2);
		hand.add(cardPanel3);
		hand.add(cardPanel4);
		hand.add(cardPanel5);
		hand.add(cardPanel6);
		hand.add(cardPanel7);
		hand.add(cardPanel8);
		hand.add(cardPanel9);
		hand.add(cardPanel10);

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
		buyShipButton.addActionListener(new BuyShipButtonListener());
		buyCanonButton.addActionListener(new BuyCanonButtonListener());
		makePromisesButton.addActionListener(new MakePromisesButtonListener());
		buyCardButton.addActionListener(new BuyCardButtonListener());
		playCardButton.addActionListener(new PlayCardButtonListener());

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
		
		springLayout.putConstraint(SpringLayout.NORTH, cardPanel6, 0, SpringLayout.NORTH, cardPanel5);
		springLayout.putConstraint(SpringLayout.SOUTH, cardPanel6, 0, SpringLayout.SOUTH, cardPanel5);
		springLayout.putConstraint(SpringLayout.WEST, cardPanel6, 10, SpringLayout.EAST, cardPanel5);
		springLayout.putConstraint(SpringLayout.EAST, cardPanel6, cardWidth, SpringLayout.WEST, cardPanel6);
		
		springLayout.putConstraint(SpringLayout.NORTH, cardPanel7, 0, SpringLayout.NORTH, cardPanel6);
		springLayout.putConstraint(SpringLayout.SOUTH, cardPanel7, 0, SpringLayout.SOUTH, cardPanel6);
		springLayout.putConstraint(SpringLayout.WEST, cardPanel7, 10, SpringLayout.EAST, cardPanel6);
		springLayout.putConstraint(SpringLayout.EAST, cardPanel7, cardWidth, SpringLayout.WEST, cardPanel7);
		
		springLayout.putConstraint(SpringLayout.NORTH, cardPanel8, 0, SpringLayout.NORTH, cardPanel7);
		springLayout.putConstraint(SpringLayout.SOUTH, cardPanel8, 0, SpringLayout.SOUTH, cardPanel7);
		springLayout.putConstraint(SpringLayout.WEST, cardPanel8, 10, SpringLayout.EAST, cardPanel7);
		springLayout.putConstraint(SpringLayout.EAST, cardPanel8, cardWidth, SpringLayout.WEST, cardPanel8);
		
		springLayout.putConstraint(SpringLayout.NORTH, cardPanel9, 0, SpringLayout.NORTH, cardPanel8);
		springLayout.putConstraint(SpringLayout.SOUTH, cardPanel9, 0, SpringLayout.SOUTH, cardPanel8);
		springLayout.putConstraint(SpringLayout.WEST, cardPanel9, 10, SpringLayout.EAST, cardPanel8);
		springLayout.putConstraint(SpringLayout.EAST, cardPanel9, cardWidth, SpringLayout.WEST, cardPanel9);
		
		springLayout.putConstraint(SpringLayout.NORTH, cardPanel10, 0, SpringLayout.NORTH, cardPanel9);
		springLayout.putConstraint(SpringLayout.SOUTH, cardPanel10, 0, SpringLayout.SOUTH, cardPanel9);
		springLayout.putConstraint(SpringLayout.WEST, cardPanel10, 10, SpringLayout.EAST, cardPanel9);
		springLayout.putConstraint(SpringLayout.EAST, cardPanel10, cardWidth, SpringLayout.WEST, cardPanel10);
		
		updateHand();
	}

	public void updateHand() {
		//TODO Dynamische SPielerID
		int spielerID = 1;
		GuiAdapterklasse ga = GuiAdapterklasse.getInstance();
		ArrayList<Spieler> spielerList = ga.getSpieler();
		Iterator<Spieler> iter = spielerList.iterator();
		Spieler localPlayer = spielerList.get(0);
		while(iter.hasNext()){
			Spieler spieler = iter.next();
			if (spieler.getId() == spielerID){
				localPlayer = spieler;
			}
		}
		
		ArrayList<Integer> kartenArray = localPlayer.getHandkarten();
		Iterator<Integer> kartenIterator = kartenArray.iterator();
		Iterator<CardPanel> PanelIterator = hand.iterator();
		while(kartenIterator.hasNext()){
			
			int card = kartenIterator.next();
			CardPanel cp = PanelIterator.next();
			cp.updatePanel(card);
		}
		while(PanelIterator.hasNext()){
			CardPanel cp = PanelIterator.next();
			cp.setVisible(false);
			
		}
		
	}
}
