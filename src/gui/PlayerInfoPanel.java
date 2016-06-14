package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

public class PlayerInfoPanel extends JPanel {
	private JLabel lblSpielername, lblKanonen, lblSchiffe, lblHandkarten, lblKopfgeld, lblname, lblships, lblcanons, lblcards, lblbounty;
	
	public PlayerInfoPanel() {
		lblSpielername = new JLabel("Spielername:");
		lblSchiffe = new JLabel("Schiffe");
		lblKanonen = new JLabel("Kanonen");
		lblHandkarten = new JLabel("Handkarten");
		lblKopfgeld = new JLabel("Kopfgeld");
		
		lblname = new JLabel("$name");
		lblships = new JLabel("$ships");
		lblcanons = new JLabel("$canons");
		lblcards = new JLabel("$cards");
		lblbounty = new JLabel("$bounty");
		setupPanel();
	}
	private void setupPanel(){
		setBackground(new Color(255, 0, 0));
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		add(lblSpielername);
		add(lblSchiffe);
		add(lblKanonen);
		add(lblHandkarten);
		add(lblKopfgeld);
		add(lblname);
		add(lblships);
		add(lblcanons);
		add(lblcards);
		add(lblbounty);
		
		springLayout.putConstraint(SpringLayout.NORTH, lblSpielername, 20, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblSpielername, 40, SpringLayout.WEST, this);
		
		springLayout.putConstraint(SpringLayout.NORTH, lblSchiffe, 6, SpringLayout.SOUTH, lblSpielername);
		springLayout.putConstraint(SpringLayout.WEST, lblSchiffe, 0, SpringLayout.WEST, lblSpielername);
		
		springLayout.putConstraint(SpringLayout.NORTH, lblKanonen, 6, SpringLayout.SOUTH, lblSchiffe);
		springLayout.putConstraint(SpringLayout.WEST, lblKanonen, 0, SpringLayout.WEST, lblSpielername);
		
		springLayout.putConstraint(SpringLayout.NORTH, lblHandkarten, 6, SpringLayout.SOUTH, lblKanonen);
		springLayout.putConstraint(SpringLayout.WEST, lblHandkarten, 0, SpringLayout.WEST, lblSpielername);
		
		springLayout.putConstraint(SpringLayout.NORTH, lblKopfgeld, 6, SpringLayout.SOUTH, lblHandkarten);
		springLayout.putConstraint(SpringLayout.WEST, lblKopfgeld, 0, SpringLayout.WEST, lblSpielername);
		
		springLayout.putConstraint(SpringLayout.NORTH, lblname, 0, SpringLayout.NORTH, lblSpielername);
		springLayout.putConstraint(SpringLayout.WEST, lblname, 6, SpringLayout.EAST, lblSpielername);
		
		springLayout.putConstraint(SpringLayout.NORTH, lblships, 0, SpringLayout.NORTH, lblSchiffe);
		springLayout.putConstraint(SpringLayout.WEST, lblships, 0, SpringLayout.WEST, lblname);
		
		springLayout.putConstraint(SpringLayout.WEST, lblcanons, 0, SpringLayout.WEST, lblname);
		springLayout.putConstraint(SpringLayout.SOUTH, lblcanons, 0, SpringLayout.SOUTH, lblKanonen);
		
		springLayout.putConstraint(SpringLayout.NORTH, lblcards, 0, SpringLayout.NORTH, lblHandkarten);
		springLayout.putConstraint(SpringLayout.WEST, lblcards, 0, SpringLayout.WEST, lblname);
		
		springLayout.putConstraint(SpringLayout.NORTH, lblbounty, 0, SpringLayout.NORTH, lblKopfgeld);
		springLayout.putConstraint(SpringLayout.WEST, lblbounty, 0, SpringLayout.WEST, lblname);
	}
}
