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
	private HandPanel handPanel;
	private BattlefieldPanel bfPanel;
	private SpringLayout springLayout;
	
	public GameFrame() {
		mainPanel = new GamePanel();
		springLayout = (SpringLayout) mainPanel.getLayout();
		handPanel = new HandPanel();
		
		
		bfPanel = new BattlefieldPanel();

		setupFrame();
	}
	
	private void setupFrame(){
		this.setContentPane(mainPanel);
		mainPanel.add(handPanel);
		mainPanel.add(bfPanel);
		
		springLayout.putConstraint(SpringLayout.NORTH, handPanel, -188, SpringLayout.SOUTH, mainPanel);
		springLayout.putConstraint(SpringLayout.SOUTH, handPanel, 0, SpringLayout.SOUTH, mainPanel);
		springLayout.putConstraint(SpringLayout.WEST, handPanel, 0, SpringLayout.WEST, mainPanel);
		springLayout.putConstraint(SpringLayout.EAST, handPanel, 0, SpringLayout.EAST, mainPanel);
		
		springLayout.putConstraint(SpringLayout.NORTH, bfPanel, 0, SpringLayout.NORTH, mainPanel);
		springLayout.putConstraint(SpringLayout.WEST, bfPanel, 0, SpringLayout.WEST, handPanel);
		springLayout.putConstraint(SpringLayout.SOUTH, bfPanel, -6, SpringLayout.NORTH, handPanel);
		springLayout.putConstraint(SpringLayout.EAST, bfPanel, 1300, SpringLayout.WEST, handPanel);
	}
	
	public void start(){
		this.setSize(1920, 1080);
		this.setVisible(true);
	}

}
