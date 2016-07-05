package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class SelectPanel extends JPanel {
	JLabel lblKanone_1, lblKanone_2, lblKanone_3, lblKanone_4;
	JComboBox comboBox_1, comboBox_2, comboBox_3, comboBox_4;
	
	public SelectPanel() {
		lblKanone_1 = new JLabel("Kanone 1:");
		lblKanone_2 = new JLabel("Kanone 2:");
		lblKanone_3 = new JLabel("Kanone 3:");
		lblKanone_4 = new JLabel("Kanone 4:");
		
		comboBox_1 = new JComboBox();
		comboBox_2 = new JComboBox();
		comboBox_3 = new JComboBox();
		comboBox_4 = new JComboBox();
		
		setupPanel();
	}
	public void setupPanel() {
		setBackground(Color.WHITE);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		add(lblKanone_1);
		add(lblKanone_2);
		add(lblKanone_3);		
		add(lblKanone_4);
		
		add(comboBox_1);
		add(comboBox_2);
		add(comboBox_3);
		add(comboBox_4);
		
		springLayout.putConstraint(SpringLayout.NORTH, lblKanone_1, 42, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblKanone_1, 43, SpringLayout.WEST, this);
		
		springLayout.putConstraint(SpringLayout.NORTH, lblKanone_2, 11, SpringLayout.SOUTH, lblKanone_1);
		springLayout.putConstraint(SpringLayout.WEST, lblKanone_2, 0, SpringLayout.WEST, lblKanone_1);
		
		springLayout.putConstraint(SpringLayout.NORTH, lblKanone_3, 11, SpringLayout.SOUTH, lblKanone_2);
		springLayout.putConstraint(SpringLayout.WEST, lblKanone_3, 0, SpringLayout.WEST, lblKanone_1);
		
		springLayout.putConstraint(SpringLayout.NORTH, lblKanone_4, 11, SpringLayout.SOUTH, lblKanone_3);
		springLayout.putConstraint(SpringLayout.WEST, lblKanone_4, 0, SpringLayout.WEST, lblKanone_1);
		
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, comboBox_1, 0, SpringLayout.VERTICAL_CENTER, lblKanone_1);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 26, SpringLayout.EAST, lblKanone_1);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, 136, SpringLayout.EAST, lblKanone_1);
		
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, comboBox_2, 0, SpringLayout.VERTICAL_CENTER, lblKanone_2);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_2, 0, SpringLayout.WEST, comboBox_1);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_2, 0, SpringLayout.EAST, comboBox_1);
		
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, comboBox_3, 0, SpringLayout.VERTICAL_CENTER, lblKanone_3);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_3, 0, SpringLayout.WEST, comboBox_2);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_3, 0, SpringLayout.EAST, comboBox_2);
		
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, comboBox_4, 0, SpringLayout.VERTICAL_CENTER, lblKanone_4);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_4, 0, SpringLayout.WEST, comboBox_3);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_4, 0, SpringLayout.EAST, comboBox_3);
	}
}
