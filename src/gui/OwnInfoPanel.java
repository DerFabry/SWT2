package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.Font;

public class OwnInfoPanel extends JPanel {
	private SpringLayout sf_OwnInformationPanel;
	private JLabel lblName, lblSchiffe, lblKanonen, lblKopfgeld, lblShips, lblcanons, lblbounty;
	private int majorFontSize, minorFontSize;

	public OwnInfoPanel() {
		sf_OwnInformationPanel = new SpringLayout();
		lblName = new JLabel("$name");
		lblSchiffe = new JLabel("Schiffe:");
		lblKanonen = new JLabel("Kanonen:");
		lblKopfgeld = new JLabel("Kopfgeld:");
		lblShips = new JLabel("$ships");
		lblcanons = new JLabel("$canons");
		lblbounty = new JLabel("$bounty");
		majorFontSize = 15;
		minorFontSize = 13;
		setupPanel();
	}

	private void setupPanel(){
		setBackground(new Color(50, 205, 50));
		setLayout(sf_OwnInformationPanel);
		
		add(lblName);
		add(lblSchiffe);
		add(lblKanonen);
		add(lblKopfgeld);
		add(lblShips);
		add(lblcanons);
		add(lblbounty);
		
		lblName.setFont(new Font("Tahoma", Font.PLAIN, majorFontSize));
		sf_OwnInformationPanel.putConstraint(SpringLayout.NORTH, lblName, 10, SpringLayout.NORTH, this);
		sf_OwnInformationPanel.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblName, 0, SpringLayout.HORIZONTAL_CENTER, this);
		

		lblSchiffe.setFont(new Font("Tahoma", Font.PLAIN, minorFontSize));
		sf_OwnInformationPanel.putConstraint(SpringLayout.NORTH, lblSchiffe, 55, SpringLayout.NORTH, this);
		sf_OwnInformationPanel.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblSchiffe, -35, SpringLayout.HORIZONTAL_CENTER, this);
		

		lblKanonen.setFont(new Font("Tahoma", Font.PLAIN, minorFontSize));
		sf_OwnInformationPanel.putConstraint(SpringLayout.NORTH, lblKanonen, 6, SpringLayout.SOUTH, lblSchiffe);
		sf_OwnInformationPanel.putConstraint(SpringLayout.WEST, lblKanonen, 0, SpringLayout.WEST, lblSchiffe);
		

		sf_OwnInformationPanel.putConstraint(SpringLayout.NORTH, lblKopfgeld, 6, SpringLayout.SOUTH, lblKanonen);
		sf_OwnInformationPanel.putConstraint(SpringLayout.WEST, lblKopfgeld, 0, SpringLayout.WEST, lblSchiffe);
		lblKopfgeld.setFont(new Font("Tahoma", Font.PLAIN, minorFontSize));
		

		lblShips.setFont(new Font("Tahoma", Font.PLAIN, minorFontSize));
		sf_OwnInformationPanel.putConstraint(SpringLayout.NORTH, lblShips, 0, SpringLayout.NORTH, lblSchiffe);
		sf_OwnInformationPanel.putConstraint(SpringLayout.WEST, lblShips, 26, SpringLayout.EAST, lblSchiffe);
		

		lblcanons.setFont(new Font("Tahoma", Font.PLAIN, minorFontSize));
		sf_OwnInformationPanel.putConstraint(SpringLayout.NORTH, lblcanons, 2, SpringLayout.NORTH, lblKanonen);
		sf_OwnInformationPanel.putConstraint(SpringLayout.WEST, lblcanons, 0, SpringLayout.WEST, lblShips);
		

		lblbounty.setFont(new Font("Tahoma", Font.PLAIN, minorFontSize));
		sf_OwnInformationPanel.putConstraint(SpringLayout.NORTH, lblbounty, 2, SpringLayout.NORTH, lblKopfgeld);
		sf_OwnInformationPanel.putConstraint(SpringLayout.WEST, lblbounty, 0, SpringLayout.WEST, lblShips);
	}

}
