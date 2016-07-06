package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;

import spieler.Spieler;

public class CanonTragetSelectButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int localPlayerID = 1;
		JButton button = (JButton) e.getSource();
		SelectPanel spPanel = (SelectPanel) button.getParent();
		ArrayList<JComboBox<Spieler>> cbList = spPanel.getComboBoxList();
		Iterator<JComboBox<Spieler>> iter = cbList.iterator();
		GuiAdapterklasse ac = GuiAdapterklasse.getInstance();
		ArrayList<Spieler> spielerListe = ac.getSpieler();
		Spieler localPlayer = spielerListe.get(0);
		Iterator<Spieler> spielerIterator = spielerListe.iterator();
		while(spielerIterator.hasNext()){
			Spieler sp = spielerIterator.next();
			if(sp.getId() == localPlayerID){
				localPlayer = sp;
			}
		}
		
		while(iter.hasNext()){
			JComboBox<Spieler> cb = iter.next();
			if(cb.isVisible()){
				localPlayer.richteKanone((Spieler) cb.getSelectedItem());
			}
		}

	}

}
