package verwaltung;
import spieler.Spieler;
import java.util.*;

import java.util.Vector;

import Karten.SWT2.src.Karte;

public class Verwaltung {
	private Spieler piratenk�nig;
	private int anzahlSpieler;
	private int aktuelleSpielphase;
	private Spieler spieler[];
	private Vector<Karte> kartenstapel[];
	
	////////////////////
	
	public Verwaltung(int anzahlSpieler)
	{
		Random rand = new Random();
		spieler = new Spieler[anzahlSpieler];
		
		for(int i = 1; i < anzahlSpieler+1; i++)
		{
			spieler[i] = new Spieler(i, "Spieler "+i);
			spieler[i].
		}
		
		this.setPiratenk�nig(spieler[rand.nextInt(anzahlSpieler)+1]);
		
		for
		
	}
	
	////////////////////
	
	
	
	public int pruefeAnazhlDerHandkarten(){
		return 0;
	}
	
	public Spieler getPiratenk�nig()
	{
		return piratenk�nig;
	}
	
	public void setPiratenk�nig(Spieler piratenk�nig)
	{
		this.piratenk�nig = piratenk�nig;
	}
	
	public int getAnzahlSpieler()
	{
		return anzahlSpieler;
	}
	
	public int getAktuelleSpielphase()
	{
		return aktuelleSpielphase;
	}
	
	public void setAktuelleSpielphase(int aktuelleSpielphase)
	{
		this.aktuelleSpielphase = aktuelleSpielphase;
		
	}
	
	public Object ermittlePiratenKoenig(){
		return new Object();
	}
	
	public void initKartenStapel(){
		
	}
}
