package spieler;

import Karten.SWT2.src.Flaute;
import Karten.SWT2.src.Karte;

public class Spieler {

	private int id;
	private String name;
	private int kanonen[];
	private int dublonen;
	private int siegpunkte;
	private int anzahlSchiffe;
	private Karte handkarten[];
	
	private void richteKanone(Spieler ziel){
	
	};
	
	public void spieleKarteAus(Karte karte){};
	public void spieleKarteAus(Karte karte, Spieler spieler){};
	public Karte macheBeute(Spieler spieler){ return new Flaute();};
	public void kaufeKanonen(){};
	public void kaufeKarten(){};
	public void kaufeSchiff(){};
	public void macheVersprechungen(Spieler spieler, Karte karte){};
	public void zieheKarten(){};
	public int[] getKanonen(){
		return kanonen;
		};
	
	}
