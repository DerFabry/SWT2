package gui;

import spieler.Spieler;
import verwaltung.Verwaltung;

public class GuiAdapterklasse {
	private static final GuiAdapterklasse OBJ = new GuiAdapterklasse();

	private GuiAdapterklasse() {

	}

	public static GuiAdapterklasse getInstance() {
		return OBJ;
	}

	public void handleCanonButtonListener() {
		System.out.println("handleCanonButtonListener");
	}

	public void handleBuyShipButtonListener() {
		System.out.println("handleBuyShipButtonListener");
	}

	public void handleBuyCanonButtonListener() {
		System.out.println("handleBuyCanonButtonListener");
	}

	public void handleMakePromisesButtonListener() {
		System.out.println("handleMakePromisesButtonListener");
	}

	public void handleBuyCardButtonListener() {
		System.out.println("handleBuyCardButtonListener");
	}

	public void handlePlayCardButtonListener() {
		System.out.println("handleBuyCardButtonListener");
	}
	
	public Spieler[] getSpieler(){
		Verwaltung verwaltung = Verwaltung.getInstance();
		Spieler[] spielerArray = verwaltung.getSpieler();
		return spielerArray;
		
	}
}
