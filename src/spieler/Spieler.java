package spieler;

import java.util.ArrayList;
import java.util.Vector;

import Karten.SWT2.src.*;
import verwaltung.Verwaltung;

public class Spieler {

	private int id;  //notwendige varable
	private String name;
	private ArrayList<Integer> kanonen;
	private int dublonen;
	private int siegpunkte;
	private int anzahlSchiffe;
	private int angriffsBonus;
	private Verwaltung verwaltung;
	
	private int verteidigungsBonus;
	private ArrayList<Integer> handkarten; // integer repräsentieren die ids der HandKarten
	
	
	public Spieler (int id, String name){  //konstr.
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
	
	public void richteKanone(Spieler ziel){   //setze die kanone auf einen spieler
		int i =0;
		boolean kanoneGesetzt=false;
		while(i<kanonen.size()&& !kanoneGesetzt){  //falls keine kanonen verfügbar oder die kanone schon gesetzt wurde break
			if(kanonen.get(i)==0){                  //wenn eine ungesetzte kanone gefunden
				kanonen.set(i,ziel.getId());		//ziele
				kanoneGesetzt= true;				//und sorge für break
			}
			i++;									//zähle i hoch um durch die liste zu gehen
		}
		
	
	}
	
	public int getId(){return id;};
	public void spieleKarteAus(int karte){ 
		getHandkarten().remove(karte);
	}
	
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
		return kanonen;
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
	public String toString(){
		return getName();
	}
	public void entferneHandkarten()
	{
		handkarten = new ArrayList<Integer>();
	}
	
	public void setPiratenkönig()
	{
		verwaltung.setPiratenkönig(this);
	}
	
	public Karte lieferHandkarte(int id)
	{
		switch(id)
		{
			case 0: {return new SprechenderPapagei();}
			case 1: {return new Schatzkarte();}
			case 2: {return new Ausflugsboot();}
			case 3: {return new Beute();}
			case 4: {return new Flaute();}
			case 6: {return new Waffenschmied();}
			case 7: {return new Spion();}
			case 8: {return new Überraschungsangriff();}
			case 9: {return new Meuterei();}
			case 10: {return new Kanonenboot();}
			case 11: {return new Bestechung();}
			case 12: {return new NassesPulver();}
			case 13: {return new Kapern();}
			case 14: {return new SchlechterWind();}

			default: System.out.println("wrong id");
		
		
		
		}
		return null;
	}
	
	
	

}
