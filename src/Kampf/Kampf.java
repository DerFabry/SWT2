package Kampf;

import spieler.Spieler;
import java.util.*;

public class Kampf {
	
	private Spieler angreifer;
	private Spieler verteidiger;
	private int anzahlSchiffeAngreifer;
	private int anzahlSchiffeVerteidiger;
	private int schritt;
	
	public Kampf(Spieler angreifer, Spieler verteidiger, int anzahlSchiffeAngreifer, int anzahlSchiffeVerteidiger, int schritt)
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
	
	public Spieler ermittleSieger()
	{
		return new Spieler();
	}
	
	public int getVerteidigungswert()
	{return 0;
			}
	

}
