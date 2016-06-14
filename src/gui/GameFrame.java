/**
 * 
 */
package gui;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

/**
 * @author Stephan
 *
 */
public class GameFrame extends JFrame {
	private GamePanel mainPanel;
	private SpringLayout sl_mainPanel, sl_bfPanel;

	public GameFrame() {
		mainPanel = new GamePanel();

		sl_mainPanel = (SpringLayout) mainPanel.getLayout();

		setupFrame();
	}

	private void setupFrame() {
		this.setContentPane(mainPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void start() {
		this.setSize(1280, 720);
		this.setVisible(true);
	}

}
