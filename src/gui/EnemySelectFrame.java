package gui;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class EnemySelectFrame extends JFrame {
	private SelectPanel selectPanel;
	
	public EnemySelectFrame(SelectPanel selectPanel) throws HeadlessException {
		this.selectPanel = selectPanel;
		setupFrame();
	}
	
	private void setupFrame(){
		this.setContentPane(selectPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void start(){
		this.setSize(800, 600);
		this.setVisible(true);
	}
}
