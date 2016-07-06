package Kampf;

import spieler.Spieler;
import verwaltung.Verwaltung;

import java.util.*;

import Karten.SWT2.src.Karte;

public class Kampf {
	
	private Spieler angreifer[];
	private Spieler verteidiger;
	private int anzahlSchiffeAngreifer;
	private int anzahlSchiffeVerteidiger;
	private int schritt;
	
	
	public Kampf(Spieler angreifer[], Spieler verteidiger, int anzahlSchiffeAngreifer, int anzahlSchiffeVerteidiger, int schritt)
	{
		
		this.angreifer = angreifer;
		this.verteidiger = verteidiger;
		this.anzahlSchiffeAngreifer = anzahlSchiffeAngreifer;
		this.anzahlSchiffeVerteidiger = anzahlSchiffeVerteidiger;
		this.schritt = schritt;
		
	}
	
	
	public int wuerfle(int anzahlW�rfel)
	{
		if(anzahlW�rfel <= 0)
			return 0;
		
		int result = 0;
		Random rand = new Random();
		for(int i = 0; i < anzahlW�rfel; i++)
		{
			result += rand.nextInt(6)+1;
			
		}
		return result;
	}

	
	public boolean angriffErfolgreich()
	{
		int angriffswertGesammt = 0;
		int l�nge = angreifer.length;
		int werte[] = new int[l�nge];
		Spieler neuerPiratenk�nig = null;
		
		
		
		for(int i = 0; i < l�nge; i++)
		{
			werte[i] = getAnzahlW�rfe(angreifer[i]);
			angriffswertGesammt += angreifer[i].getAngreiferBonus();
		}
		
		for(int i = 0; i < l�nge; i++)
			for(int j= 0; j < werte[i]; j++)
			{
				int w�rfelWurf = getWurf();
				int max = 0;
				if(w�rfelWurf>max)
				{
					max = w�rfelWurf;
					neuerPiratenk�nig = angreifer[i];
					
				}
				angriffswertGesammt += w�rfelWurf;
			}
				
		
		if(getVerteidigungswert() >= angriffswertGesammt)
		{
			for(int i = 0; i < l�nge; i++)
			{
				angreifer[i].setAngriffsBonus(0);
				angreifer[i].setVerteidigungsBonus(0);
				verteidiger.setAngriffsBonus(0);
				verteidiger.setVerteidigungsBonus(0);
			}

			return false;  //verteidiger siegt
		}
			
		for(int i = 0; i < l�nge; i++)		//bonus zur�cksetzten
		{
			angreifer[i].setAngriffsBonus(0);
			angreifer[i].setVerteidigungsBonus(0);
			verteidiger.setAngriffsBonus(0);
			verteidiger.setVerteidigungsBonus(0);
		}
		
		
		List<Integer> kartenListe = new LinkedList<Integer>();
		
		kartenListe = verteidiger.getHandkarten();
		
		Collections.shuffle(kartenListe);
		
		for(int i = 0; i < angreifer.length; i++)
			if(!kartenListe.isEmpty())
			{
				angreifer[i].setHandkarten(kartenListe.get(0));
				kartenListe.remove(0);
			}
		
		verteidiger.entferneHandkarten();
		for(Integer karte : kartenListe)
			verteidiger.setHandkarten(karte);
		
		
		
		
		
		neuerPiratenk�nig.setPiratenk�nig();
		
		//bonus zur�cksetzten
		return true;  //angreifer siegt
	}
	public int getWurf()
	{
		Random rand = new Random();
		return rand.nextInt(6)+1;
	}
	
	public int getAnzahlW�rfe(Spieler angreifer)
	{
		int anzahlW�rfe = 0;
		int anzahl = 0;
		
		List<Integer> kanonen = angreifer.getKanonen();
		
		for (int i = 0; 0 != kanonen.get(i); i++)
			anzahl++;
		
		for(int i = 0; i < anzahl; i++)
			if(verteidiger.getId() == kanonen.get(i))
				anzahlW�rfe++;
		
		return anzahlW�rfe;
	}
	
	public int getAnzahlW�rfeVerteidiger(Spieler verteidiger)
	{
		int anzahlW�rfe = 0;
		int anzahl = 0;
		
		List<Integer> kanonen = verteidiger.getKanonen();
		
		for(int i = 0; i < kanonen.size(); i++)
		{
			if(6 == kanonen.get(i))
				anzahlW�rfe++;
		}
		
		
		
		return anzahlW�rfe;
	}
	
	public int getVerteidigungswert()
	{
		int verteidigungswert = 0;
		int anzahl = 0;
		List<Integer> kanonen = verteidiger.getKanonen();
		for(int i = 0; 0 != kanonen.get(i); i++)
			anzahl++;
		
		for(int i = 0; i < anzahl; i++)
			if(kanonen.get(i) == 6)
				verteidigungswert++;
		
		if(verteidiger.getId() != verteidiger.getPiratenk�nigId())
			verteidigungswert += wuerfle(getAnzahlW�rfeVerteidiger(verteidiger));
		
		
		
		verteidigungswert += verteidiger.getAnzahlSchiffe();
		verteidigungswert += verteidiger.getVerteidigungsBonus();
		
		return verteidigungswert;
	}
}
