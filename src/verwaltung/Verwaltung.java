package verwaltung;
import spieler.Spieler;
import java.rmi.*;
import java.util.*;

import Karten.SWT2.src.GeldCreator;
import Karten.SWT2.src.KampfCreator;
import Karten.SWT2.src.Karte;
import Karten.SWT2.src.LuxusCreator;
import Karten.SWT2.src.SonstigesCreator;

public class Verwaltung implements Remote{
	private static final Verwaltung VERWALTUNG = new Verwaltung(5);
	private Spieler piratenk�nig;
	private int anzahlSpieler;
	private int aktuelleSpielphase;
	private Spieler[] spieler;
	private LinkedList<Karte> kartenstapel;
	
	////////////////////
	
	public Verwaltung(){}
	
	private Verwaltung(int anzahlSpieler)
	{
		try {
			///////////////////
			//RMI
			Verwaltung object = new Verwaltung();
			
			
			
			
			
			
			///////////////////
			
			
			
			
			
			
			aktuelleSpielphase = 1;
			
			kartenstapel = new LinkedList<Karte>();   //erzeuge kartenstapel
			
			
			
			LuxusCreator luxus = new LuxusCreator();  
			
			
			for(int i = 0; i < 3; i++)						
				kartenstapel.add(luxus.SpieleKarteAus(i));		//f�ge die kartenvarianten zum kartenstapel, die in die kategorie luxus geh�ren
			
			GeldCreator geld = new GeldCreator();
			for(int i = 0; i < 26; i++)
				kartenstapel.add(geld.SpieleKarteAus(3));		//f�ge alle "gold" karten varianten hinzu
			
			KampfCreator kampf = new KampfCreator();
			
			for(int i = 7; i < 14; i++)							//f�ge 2x (regeln) alle "kamp" karten varianten hinzu
			{
				kartenstapel.add(kampf.SpieleKarteAus(i));
				kartenstapel.add(kampf.SpieleKarteAus(i));
			}
			
			
			SonstigesCreator sonst = new SonstigesCreator();
			
			for(int i = 4; i < 6; i++)							
				kartenstapel.add(sonst.SpieleKarteAus(i));		//f�ge sonstige hinzu
			
			
			Collections.shuffle(kartenstapel);  //mische den erzeugten kartenstapel
			
			
			
			
			Random rand = new Random();
			spieler = new Spieler[anzahlSpieler];    //lasse spieler auf ein array der klasse spieler und der l�nge anz.Spieler zeigen
			
			for(int i = 1; i < anzahlSpieler+1; i++)
			{
				spieler[i-1] = new Spieler(i, "Spieler "+i);  //f�lle das array mit spielern (beg. bei 1)
				


				spieler[i-1].setHandkarten(zieheKarte());   //verteile handkarten (2x - steht in regeln)
				spieler[i-1].setHandkarten(zieheKarte());
				
			}
			
			this.setPiratenk�nig(spieler[rand.nextInt(anzahlSpieler)+1]);  //ein zuf�lliger spieler wird zu piratenk�nig
			
			for(int i = 0; i < anzahlSpieler; i++)
				piratenk�nig.setHandkarten(zieheKarte());   //gebe zus�tzliche handkarten an piratenk�nig
			
			aktuelleSpielphase = 2;
		} catch (Exception e) {  //catch (z.b. shuffle oder eigene exception von karten)
			
			e.printStackTrace();
		}

	}
	
	public static Verwaltung getInstance(){
		return VERWALTUNG;
	}
	
	////////////////////
	
	public int zieheKarte()
	{
		Karte karte = kartenstapel.getFirst();  //kartenstapel ist eine LinkedList. Deshalb immer zugriff auf die oberste Karte.
		kartenstapel.removeFirst();				//l�sche die karte danach vom kartenstapel
		return karte.getId();					//und gebe die karte zur�ck
	}
	
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
	
	
	
	public Spieler[] getSpieler()
	{
		return spieler;
	}
}
