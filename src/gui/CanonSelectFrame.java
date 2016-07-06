package gui;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;

public class CanonSelectFrame extends JFrame {
	private SelectPanel mainPanel;
	private SpringLayout sl_mainPanel, sl_bfPanel;

	public CanonSelectFrame() {
		mainPanel = new SelectPanel();

		sl_mainPanel = (SpringLayout) mainPanel.getLayout();

		setupFrame();
	}

	private void setupFrame() {
		this.setContentPane(mainPanel);

	}

	public void start() {
		this.setSize(400, 300);
		this.setVisible(true);
	}
}
