package spieler;

import java.util.ArrayList;
import java.util.Vector;

import Karten.SWT2.src.Flaute;
import Karten.SWT2.src.Karte;
import verwaltung.Verwaltung;

public class Spieler {

	private int id;
	private String name;
	private int kanonen[];
	private int dublonen;
	private int siegpunkte;
	private int anzahlSchiffe;
	private int angriffsBonus;
	private Verwaltung verwaltung;
	
	private int verteidigungsBonus;
	private ArrayList<Integer> handkarten; // integer repr�sentieren die ids der HandKarten
	
	
	public Spieler (int id, String name){
		verwaltung = new Verwaltung();
		this.id = id;
		this.name = name;
		kanonen = new int[4];
		dublonen= 0;
		siegpunkte = 0;
		anzahlSchiffe =0;
		handkarten = new ArrayList<Integer>();
		angriffsBonus = 0;
		verteidigungsBonus = 0;
		
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
	public void kaufeSchiff(){/*bonus hochz�hlen*/};
	public void macheVersprechungen(Spieler spieler, Karte karte){};
	public void zieheKarten(){};
	public int getAngreiferBonus()
	{
		return angriffsBonus;
	}
	
	public void setAngriffsBonus(int bonus)
	{
		this.angriffsBonus = bonus;
	}
	
	public int getVerteidigungsBonus()
	{
		return verteidigungsBonus;
	}
	
	public void setVerteidigungsBonus(int bonus)
	{
		this.verteidigungsBonus = bonus;
	}
	
	public int getAnzahlSchiffe()
	{
		return anzahlSchiffe;
	}
	
	public int getPiratenk�nigId()
	{
		return verwaltung.getPiratenk�nig().getId();
	}
	
	public int[] getKanonen(){
		return kanonen;
		}

	public ArrayList<Integer> getHandkarten() {
		return handkarten;
	}

	public void setHandkarten(int kartenId) {
	
		this.handkarten.add(kartenId);
	}
	
	}
