package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class CardPanel extends JPanel {
	JLabel lblNewLabel;
	public CardPanel(){
		
		lblNewLabel = new JLabel("");
		setupPanel();
		
	}
	private void setupPanel() {
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		add(lblNewLabel);
	}
	
	public void updatePanel(int card) {
		lblNewLabel.setText(Integer.toString(card));
	}
}
