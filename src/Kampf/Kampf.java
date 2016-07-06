package Kampf;

import spieler.Spieler;
import java.util.*;

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
		for(int i = 0; i < l�nge; i++)
		{
			werte[i] = getAnzahlW�rfe(angreifer[i]);
		}
		
		for(int i = 0; i < l�nge; i++)
			for(int j= 0; j < werte[i]; j++)
				angriffswertGesammt += getWurf();
		
		
		
		if(getVerteidigungswert() >= angriffswertGesammt)
			return false;

		return true;
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
		
		int[] kanonen = angreifer.getKanonen();
		
		for (int i = 0; 0 != kanonen[i]; i++)
			anzahl++;
		
		for(int i = 0; i < anzahl; i++)
			if(verteidiger.getId() == kanonen[i])
				anzahlW�rfe++;
		
		return anzahlW�rfe;
	}
	
	public int getVerteidigungswert()
	{
		int verteidigungswert = 0;
		int anzahl = 0;
		int[] kanonen = verteidiger.getKanonen();
		for(int i = 0; 0 != kanonen[i]; i++)
			anzahl++;
		
		for(int i = 0; i < anzahl; i++)
			if(kanonen[i] == 6)
				verteidigungswert++;
				
		
		return verteidigungswert;
	}
}
