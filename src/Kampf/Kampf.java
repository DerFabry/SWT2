package Kampf;

import spieler.Spieler;
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
	
	
	public int wuerfle(int anzahlWürfel)
	{
		if(anzahlWürfel <= 0)
			return 0;
		
		int result = 0;
		Random rand = new Random();
		for(int i = 0; i < anzahlWürfel; i++)
		{
			result += rand.nextInt(6)+1;
			
		}
		return result;
	}

	
	public boolean angriffErfolgreich()
	{
		int angriffswertGesammt = 0;
		int länge = angreifer.length;
		int werte[] = new int[länge];
		
		
		
		for(int i = 0; i < länge; i++)
		{
			werte[i] = getAnzahlWürfe(angreifer[i]);
			angriffswertGesammt += angreifer[i].getAngreiferBonus();
		}
		
		for(int i = 0; i < länge; i++)
			for(int j= 0; j < werte[i]; j++)
			
				angriffswertGesammt += getWurf();
		
		if(getVerteidigungswert() >= angriffswertGesammt)
		{
			for(int i = 0; i < länge; i++)
			{
				angreifer[i].setAngriffsBonus(0);
				angreifer[i].setVerteidigungsBonus(0);
				verteidiger.setAngriffsBonus(0);
				verteidiger.setVerteidigungsBonus(0);
			}
			
			
			return false;
		}
			
		//bonus zurücksetzten
		return true;
	}
	public int getWurf()
	{
		Random rand = new Random();
		return rand.nextInt(6)+1;
	}
	
	public int getAnzahlWürfe(Spieler angreifer)
	{
		int anzahlWürfe = 0;
		int anzahl = 0;
		
		int[] kanonen = angreifer.getKanonen();
		
		for (int i = 0; 0 != kanonen[i]; i++)
			anzahl++;
		
		for(int i = 0; i < anzahl; i++)
			if(verteidiger.getId() == kanonen[i])
				anzahlWürfe++;
		
		return anzahlWürfe;
	}
	
	public int getAnzahlWürfeVerteidiger(Spieler verteidiger)
	{
		int anzahlWürfe = 0;
		int anzahl = 0;
		
		int[] kanonen = verteidiger.getKanonen();
		
		for(int i = 0; i < kanonen.length; i++)
		{
			if(6 == kanonen[i])
				anzahlWürfe++;
		}
		
		
		
		return anzahlWürfe;
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
		
		if(verteidiger.getId() != verteidiger.getPiratenkönigId())
			verteidigungswert += wuerfle(1);
		
		
		
		verteidigungswert += verteidiger.getAnzahlSchiffe();
		verteidigungswert += verteidiger.getVerteidigungsBonus();
		
		return verteidigungswert;
	}
}
