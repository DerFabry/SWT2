package verwaltung;
import spieler.Spieler;
import java.util.*;

import Karten.SWT2.src.Ausflugsboot;
import Karten.SWT2.src.Bestechung;
import Karten.SWT2.src.Beute;
import Karten.SWT2.src.Flaute;
import Karten.SWT2.src.GeldCreator;
import Karten.SWT2.src.KampfCreator;
import Karten.SWT2.src.Kanonenboot;
import Karten.SWT2.src.Kapern;
import Karten.SWT2.src.Karte;
import Karten.SWT2.src.LuxusCreator;
import Karten.SWT2.src.Meuterei;
import Karten.SWT2.src.NassesPulver;
import Karten.SWT2.src.Schatzkarte;
import Karten.SWT2.src.SchlechterWind;
import Karten.SWT2.src.SonstigesCreator;
import Karten.SWT2.src.Spion;
import Karten.SWT2.src.SprechenderPapagei;
import Karten.SWT2.src.Waffenschmied;
import Karten.SWT2.src.Überraschungsangriff;

public class Verwaltung {
	private static final Verwaltung VERWALTUNG = new Verwaltung(3);
	private Spieler piratenkönig;
	private int anzahlSpieler;
	private int aktuelleSpielphase;
	private Spieler[] spieler;
	private LinkedList<Karte> kartenstapel;
	
	////////////////////
	
	public Verwaltung(){}
	
	private Verwaltung(int anzahlSpieler)
	{
		try {
			aktuelleSpielphase = 1;
			
			kartenstapel = new LinkedList<Karte>();
			
			
			
			LuxusCreator luxus = new LuxusCreator();
			
			
			for(int i = 0; i < 3; i++)
				kartenstapel.add(luxus.SpieleKarteAus(i));
			
			GeldCreator geld = new GeldCreator();
			for(int i = 0; i < 26; i++)
				kartenstapel.add(geld.SpieleKarteAus(3));
			
			KampfCreator kampf = new KampfCreator();
			
			for(int i = 7; i < 14; i++)
			{
				kartenstapel.add(kampf.SpieleKarteAus(i));
				kartenstapel.add(kampf.SpieleKarteAus(i));
			}
			
			
			SonstigesCreator sonst = new SonstigesCreator();
			
			for(int i = 4; i < 6; i++)
				kartenstapel.add(sonst.SpieleKarteAus(i));
			
			
			Collections.shuffle(kartenstapel);
			
			
			
			
			Random rand = new Random();
			spieler = new Spieler[anzahlSpieler];
			
			for(int i = 1; i < anzahlSpieler+1; i++)
			{
				spieler[i-1] = new Spieler(i, "Spieler "+i);
				

				spieler[i-1].setHandkarten(zieheKarte());
				spieler[i-1].setHandkarten(zieheKarte());
				
			}
			
			this.setPiratenkönig(spieler[rand.nextInt(anzahlSpieler)]);
			
			for(int i = 0; i < anzahlSpieler; i++)
				piratenkönig.setHandkarten(zieheKarte());
			
			aktuelleSpielphase = 2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static Verwaltung getInstance(){
		return VERWALTUNG;
	}
	
	////////////////////
	
	public int zieheKarte()
	{
		Karte karte = kartenstapel.getFirst();
		kartenstapel.removeFirst();
		return karte.getId();
	}
	
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
	
	
	public ArrayList<Spieler> getSpieler()
	{
		ArrayList<Spieler> spielerListe = new ArrayList<Spieler>();
		for (Spieler spieler : spieler) {
			spielerListe.add(spieler);
		}
		return spielerListe;
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
