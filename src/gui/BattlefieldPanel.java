package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import spieler.Spieler;

public class BattlefieldPanel extends JPanel {
	private SpringLayout sl_this;
	private PlayerInfoPanel opponentInfo1, opponentInfo2, opponentInfo3, opponentInfo4;
	private OwnInfoPanel ownInfo;
	private int opponentInfoPanelWidth, opponentInfoPanelHeight;
	private ArrayList<PlayerInfoPanel> playerInfoPanelList;
	GuiAdapterklasse ga;

	public BattlefieldPanel() {
		sl_this = new SpringLayout();
		opponentInfo1 = new PlayerInfoPanel();
		opponentInfo2 = new PlayerInfoPanel();
		opponentInfo3 = new PlayerInfoPanel();
		opponentInfo4 = new PlayerInfoPanel();

		ownInfo = new OwnInfoPanel();

		opponentInfoPanelWidth = 200;
		opponentInfoPanelHeight = 150;

		playerInfoPanelList = new ArrayList<PlayerInfoPanel>();

		playerInfoPanelList.add(opponentInfo1);
		playerInfoPanelList.add(opponentInfo2);
		playerInfoPanelList.add(opponentInfo3);
		playerInfoPanelList.add(opponentInfo4);

		ga = GuiAdapterklasse.getInstance();

		updateOpponents(ga.getSpieler());
		setupPanel();
	}

	private void setupPanel() {
		setBackground(new Color(135, 206, 250));
		setLayout(sl_this);

		this.add(opponentInfo1);
		this.add(opponentInfo2);
		this.add(opponentInfo3);
		this.add(opponentInfo4);

		this.add(ownInfo);

		sl_this.putConstraint(SpringLayout.WEST, ownInfo, 100, SpringLayout.EAST, opponentInfo1);
		sl_this.putConstraint(SpringLayout.NORTH, ownInfo, 200, SpringLayout.NORTH, this);
		sl_this.putConstraint(SpringLayout.SOUTH, ownInfo, 0, SpringLayout.SOUTH, this);
		sl_this.putConstraint(SpringLayout.EAST, ownInfo, -100, SpringLayout.WEST, opponentInfo3);

		sl_this.putConstraint(SpringLayout.NORTH, opponentInfo1, 0, SpringLayout.NORTH, this);
		sl_this.putConstraint(SpringLayout.WEST, opponentInfo1, 0, SpringLayout.WEST, this);
		sl_this.putConstraint(SpringLayout.EAST, opponentInfo1, opponentInfoPanelWidth, SpringLayout.WEST, this);
		sl_this.putConstraint(SpringLayout.SOUTH, opponentInfo1, opponentInfoPanelHeight, SpringLayout.NORTH, this);

		sl_this.putConstraint(SpringLayout.NORTH, opponentInfo2, 0, SpringLayout.NORTH, this);
		sl_this.putConstraint(SpringLayout.SOUTH, opponentInfo2, 0, SpringLayout.SOUTH, opponentInfo1);
		sl_this.putConstraint(SpringLayout.EAST, opponentInfo2, 0, SpringLayout.EAST, this);
		sl_this.putConstraint(SpringLayout.WEST, opponentInfo2, -(opponentInfoPanelWidth), SpringLayout.EAST, this);

		sl_this.putConstraint(SpringLayout.NORTH, opponentInfo3, -(opponentInfoPanelHeight), SpringLayout.SOUTH, this);
		sl_this.putConstraint(SpringLayout.WEST, opponentInfo3, 0, SpringLayout.WEST, opponentInfo2);
		sl_this.putConstraint(SpringLayout.SOUTH, opponentInfo3, 0, SpringLayout.SOUTH, this);
		sl_this.putConstraint(SpringLayout.EAST, opponentInfo3, 0, SpringLayout.EAST, opponentInfo2);

		sl_this.putConstraint(SpringLayout.NORTH, opponentInfo4, 0, SpringLayout.NORTH, opponentInfo3);
		sl_this.putConstraint(SpringLayout.SOUTH, opponentInfo4, 0, SpringLayout.SOUTH, opponentInfo3);
		sl_this.putConstraint(SpringLayout.EAST, opponentInfo4, 0, SpringLayout.EAST, opponentInfo1);
		sl_this.putConstraint(SpringLayout.WEST, opponentInfo4, 0, SpringLayout.WEST, this);
	}

	private void updateOpponents(ArrayList<Spieler> spielerList) {
		// TODO Dynamische PlayerID

		int localPlayerID = 1;
		Iterator<PlayerInfoPanel> Paneliter = playerInfoPanelList.iterator();
		Iterator<Spieler> spielerIterator = spielerList.iterator();
		while (spielerIterator.hasNext()) {
			Spieler sp = spielerIterator.next();
			if (sp.getId() == localPlayerID) {
				ownInfo.updatePlayerInfo(sp);
			} else {
				Paneliter.next().setPlayerinfo(sp);
			}
		}
		while (Paneliter.hasNext()) {
			Paneliter.next().setVisible(false);
		}
	}
}
