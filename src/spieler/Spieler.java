package spieler;

import java.util.ArrayList;
import java.util.Vector;

import Karten.SWT2.src.Flaute;
import Karten.SWT2.src.Karte;
import verwaltung.Verwaltung;

public class Spieler {

	private int id;
	private String name;
	private ArrayList<Integer> kanonen;
	private int dublonen;
	private int siegpunkte;
	private int anzahlSchiffe;
	private int angriffsBonus;
	private Verwaltung verwaltung;
	
	private int verteidigungsBonus;
	private ArrayList<Integer> handkarten; // integer repräsentieren die ids der HandKarten
	
	
	public Spieler (int id, String name){
		verwaltung = new Verwaltung();
		this.id = id;
		this.setName(name);
		kanonen = new ArrayList<Integer>();
		kanonen.add(0);
		
		setDublonen(0);
		setSiegpunkte(0);
		anzahlSchiffe =0;
		handkarten = new ArrayList<Integer>();
		angriffsBonus = 0;
		verteidigungsBonus = 0;
		
	}
	
	public void richteKanone(Spieler ziel){
		int i =0;
		boolean kanoneGesetzt=false;
		while(i<kanonen.size()&& !kanoneGesetzt){
			if(kanonen.get(i)==0){
				kanonen.set(i,ziel.getId());
				kanoneGesetzt= true;
			}
			i++;
		}
		
	
	}
	
	public int getId(){return id;};
	public void spieleKarteAus(int karte){ 
		getHandkarten().remove(karte);
	};
	public void spieleKarteAus(Karte karte, Spieler spieler){};
	public Karte macheBeute(Spieler spieler){ return new Flaute();};
	public void kaufeKanonen(){};
	public void kaufeKarten(){};
	public void kaufeSchiff(){/*bonus hochzählen*/};
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
	
	public int getPiratenkönigId()
	{
		return verwaltung.getPiratenkönig().getId();
	}
	
	public ArrayList<Integer> getKanonen(){
		System.out.println("test");
		return kanonen;//test
		
		}

	public ArrayList<Integer> getHandkarten() {
		return handkarten;
	}

	public void setHandkarten(int kartenId) {
	
		this.handkarten.add(kartenId);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSiegpunkte() {
		return siegpunkte;
	}

	public void setSiegpunkte(int siegpunkte) {
		this.siegpunkte = siegpunkte;
	}

	public int getDublonen() {
		return dublonen;
	}

	public void setDublonen(int dublonen) {
		this.dublonen = dublonen;
	}
	
	public void entferneHandkarten()
	{
		handkarten = new ArrayList<Integer>();
	}
	
	public void setPiratenkönig()
	{
		verwaltung.setPiratenkönig(this);
	}

}
