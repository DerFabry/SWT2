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
	private SpringLayout sl_mainPanel, sl_bfPanel;
	private PlayerInfoPanel opponentInfo1, opponentInfo2, opponentInfo3, opponentInfo4;
	private OwnInfoPanel ownInfo;
	private int opponentInfoPanelWidth, opponentInfoPanelHeight;

	public GameFrame() {
		mainPanel = new GamePanel();
		handPanel = new HandPanel();
		bfPanel = new BattlefieldPanel();

		opponentInfo1 = new PlayerInfoPanel();
		opponentInfo2 = new PlayerInfoPanel();
		opponentInfo3 = new PlayerInfoPanel();
		opponentInfo4 = new PlayerInfoPanel();

		ownInfo = new OwnInfoPanel();

		sl_mainPanel = (SpringLayout) mainPanel.getLayout();
		sl_bfPanel = new SpringLayout();

		opponentInfoPanelWidth = 200;
		opponentInfoPanelHeight = 150;
		setupFrame();
	}

	private void setupFrame() {
		this.setContentPane(mainPanel);
		mainPanel.add(handPanel);
		mainPanel.add(bfPanel);

		bfPanel.setLayout(sl_bfPanel);
		bfPanel.add(opponentInfo1);
		bfPanel.add(opponentInfo2);
		bfPanel.add(opponentInfo3);
		bfPanel.add(opponentInfo4);

		bfPanel.add(ownInfo);

		
		sl_mainPanel.putConstraint(SpringLayout.NORTH, handPanel, -200, SpringLayout.SOUTH, mainPanel);
		sl_mainPanel.putConstraint(SpringLayout.SOUTH, handPanel, 0, SpringLayout.SOUTH, mainPanel);
		sl_mainPanel.putConstraint(SpringLayout.WEST, handPanel, 0, SpringLayout.WEST, mainPanel);
		sl_mainPanel.putConstraint(SpringLayout.EAST, handPanel, 0, SpringLayout.EAST, mainPanel);

		sl_mainPanel.putConstraint(SpringLayout.NORTH, bfPanel, 0, SpringLayout.NORTH, mainPanel);
		sl_mainPanel.putConstraint(SpringLayout.WEST, bfPanel, 0, SpringLayout.WEST, handPanel);
		sl_mainPanel.putConstraint(SpringLayout.SOUTH, bfPanel, 0, SpringLayout.NORTH, handPanel);
		sl_mainPanel.putConstraint(SpringLayout.EAST, bfPanel, 1000, SpringLayout.WEST, handPanel);

		sl_bfPanel.putConstraint(SpringLayout.WEST, ownInfo, 100, SpringLayout.EAST, opponentInfo1);
		sl_bfPanel.putConstraint(SpringLayout.NORTH, ownInfo, 200, SpringLayout.NORTH, bfPanel);
		sl_bfPanel.putConstraint(SpringLayout.SOUTH, ownInfo, 0, SpringLayout.SOUTH, bfPanel);
		sl_bfPanel.putConstraint(SpringLayout.EAST, ownInfo, -100, SpringLayout.WEST, opponentInfo3);

		sl_bfPanel.putConstraint(SpringLayout.NORTH, opponentInfo1, 0, SpringLayout.NORTH, bfPanel);
		sl_bfPanel.putConstraint(SpringLayout.WEST, opponentInfo1, 0, SpringLayout.WEST, bfPanel);
		sl_bfPanel.putConstraint(SpringLayout.EAST, opponentInfo1, opponentInfoPanelWidth, SpringLayout.WEST, bfPanel);
		sl_bfPanel.putConstraint(SpringLayout.SOUTH, opponentInfo1, opponentInfoPanelHeight, SpringLayout.NORTH, bfPanel);

		sl_bfPanel.putConstraint(SpringLayout.NORTH, opponentInfo2, 0, SpringLayout.NORTH, bfPanel);
		sl_bfPanel.putConstraint(SpringLayout.SOUTH, opponentInfo2, 0, SpringLayout.SOUTH, opponentInfo1);
		sl_bfPanel.putConstraint(SpringLayout.EAST, opponentInfo2, 0, SpringLayout.EAST, bfPanel);
		sl_bfPanel.putConstraint(SpringLayout.WEST, opponentInfo2, -(opponentInfoPanelWidth), SpringLayout.EAST, bfPanel);

		sl_bfPanel.putConstraint(SpringLayout.NORTH, opponentInfo3, -(opponentInfoPanelHeight), SpringLayout.SOUTH, bfPanel);
		sl_bfPanel.putConstraint(SpringLayout.WEST, opponentInfo3, 0, SpringLayout.WEST, opponentInfo2);
		sl_bfPanel.putConstraint(SpringLayout.SOUTH, opponentInfo3, 0, SpringLayout.SOUTH, bfPanel);
		sl_bfPanel.putConstraint(SpringLayout.EAST, opponentInfo3, 0, SpringLayout.EAST, opponentInfo2);

		sl_bfPanel.putConstraint(SpringLayout.NORTH, opponentInfo4, 0, SpringLayout.NORTH, opponentInfo3);
		sl_bfPanel.putConstraint(SpringLayout.SOUTH, opponentInfo4, 0, SpringLayout.SOUTH, opponentInfo3);
		sl_bfPanel.putConstraint(SpringLayout.EAST, opponentInfo4, 0, SpringLayout.EAST, opponentInfo1);
		sl_bfPanel.putConstraint(SpringLayout.WEST, opponentInfo4, 0, SpringLayout.WEST, bfPanel);
	}

	public void start() {
		this.setSize(1280, 720);
		this.setVisible(true);
	}

}
