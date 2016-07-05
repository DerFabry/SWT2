package spieler;

import java.util.ArrayList;
import java.util.Vector;

import Karten.SWT2.src.Flaute;
import Karten.SWT2.src.Karte;

public class Spieler {

	private int id;
	private String name;
	private int kanonen[];
	private int dublonen;
	private int siegpunkte;
	private int anzahlSchiffe;
	private ArrayList<Integer> handkarten; // integer repräsentieren die ids der HandKarten
	
	
	public Spieler (int id, String name){
		this.id = id;
		this.name = name;
		kanonen = new int[4];
		dublonen= 0;
		siegpunkte = 0;
		anzahlSchiffe =0;
		handkarten = new ArrayList<Integer>();
		
	};
	
	private void richteKanone(Spieler ziel){
		int i =0;
		boolean kanoneGesetzt=false;
		while(i<kanonen.length&& !kanoneGesetzt){
			if(kanonen[i]==0){
				kanonen[i] = ziel.getId();
				kanoneGesetzt= true;
			}
			i++;
		}
		
	
	};
	
	public int getId(){return id;};
	public void spieleKarteAus(int karte){ 
		getHandkarten().remove(karte);
	};
	public void spieleKarteAus(Karte karte, Spieler spieler){};
	public Karte macheBeute(Spieler spieler){ return new Flaute();};
	public void kaufeKanonen(){};
	public void kaufeKarten(){};
	public void kaufeSchiff(){};
	public void macheVersprechungen(Spieler spieler, Karte karte){};
	public void zieheKarten(){};
	public int[] getKanonen(){
		return kanonen;
		}

	public ArrayList<Integer> getHandkarten() {
		return handkarten;
	}

	public void setHandkarten(int kartenId) {
	
		this.handkarten.add(kartenId);
	};
	
	}
