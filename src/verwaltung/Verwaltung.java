package verwaltung;
import spieler.Spieler;
import java.util.*;

import java.util.Vector;

import Karten.SWT2.src.Karte;

public class Verwaltung {
	private Spieler piratenkönig;
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
		
		this.setPiratenkönig(spieler[rand.nextInt(anzahlSpieler)+1]);
		
		for
		
	}
	
	////////////////////
	
	
	
	public int pruefeAnazhlDerHandkarten(){
		return 0;
	}
	
	public Spieler getPiratenkönig()
	{
		return piratenkönig;
	}
	
	public void setPiratenkönig(Spieler piratenkönig)
	{
		this.piratenkönig = piratenkönig;
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
