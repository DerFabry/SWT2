package verwaltung;
import spieler.Spieler;
import java.util.*;
import javax.naming.InitialContext;

import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.jms.MessageListener;
import javax.jms.JMSException;
import javax.jms.ExceptionListener;
import javax.jms.QueueSession;
import javax.jms.QueueReceiver;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;

import javax.naming.InitialContext;

import Karten.SWT2.src.*;

public class Verwaltung implements MessageListener, ExceptionListener {
	private static final Verwaltung VERWALTUNG = new Verwaltung(3);
	private Spieler piratenkönig;
	private int anzahlSpieler;
	private int aktuelleSpielphase;
	private Spieler[] spieler;
	private LinkedList<Karte> kartenstapel;
	
	////////////////////
	
	public Verwaltung(){}
	
	private <QueueReceiver, QueueSession, QueueConnection> Verwaltung(int anzahlSpieler)
	{
		try{
		 // get the initial context
	       InitialContext ctx = new InitialContext();
	                                                                          
	       // lookup the queue object
	       Queue queue = (Queue) ctx.lookup("queue/queue0");
	                                                                          
	       // lookup the queue connection factory
	       QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx.
	           lookup("queue/connectionFactory");
	                                                                         
	       // create a queue connection
	       QueueConnection queueConn = connFactory.createQueueConnection();
	                                                                          
	       // create a queue session
	       QueueSession queueSession = queueConn.createQueueSession(false,
	           Session.AUTO_ACKNOWLEDGE);
	                                                                          
	       // create a queue receiver
	       QueueReceiver queueReceiver = queueSession.createReceiver(queue);
	                                                                          
	      // set an asynchronous message listener
	       AsyncReceiver asyncReceiver = new AsyncReceiver();
	       queueReceiver.setMessageListener(asyncReceiver);
	                                                                          
	       // set an asynchronous exception listener on the connection
	       queueConn.setExceptionListener(asyncReceiver);
	                                                                          
	       // start the connection
	       queueConn.start();
	                                                                          
	       // wait for messages
	       System.out.print("waiting for messages");
	      for (int i = 0; i < 10; i++) {
	          Thread.sleep(1000);
	          System.out.print(".");
	      }
	       System.out.println();
	                                                                          
	       // close the queue connection
	       queueConn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
				
				
		
		
		
		
		
		try {
			aktuelleSpielphase = 1;								//setze spielphase auf 1
			
			kartenstapel = new LinkedList<Karte>();				//erzeuge einen kartenstapel
			
			
			
			LuxusCreator luxus = new LuxusCreator();
			
			
			for(int i = 0; i < 3; i++)
				kartenstapel.add(luxus.SpieleKarteAus(i));		//füge dem kartenstapel die luxus karten hinzu
			
			GeldCreator geld = new GeldCreator();
			for(int i = 0; i < 26; i++)
				kartenstapel.add(geld.SpieleKarteAus(3));		//füge dem kartenstapel die geld karten hinzu
			
			KampfCreator kampf = new KampfCreator();
			
			for(int i = 7; i < 14; i++)
			{
				kartenstapel.add(kampf.SpieleKarteAus(i));		//füge die kampfkarten hinzu (2x - regeln)
				kartenstapel.add(kampf.SpieleKarteAus(i));
			}
			
			
			SonstigesCreator sonst = new SonstigesCreator();
			
			for(int i = 4; i < 6; i++)
				kartenstapel.add(sonst.SpieleKarteAus(i));		//füge sonstige karten hinzu
			
			
			Collections.shuffle(kartenstapel);					//mische
			
			
			
			
			Random rand = new Random();
			spieler = new Spieler[anzahlSpieler];				//deklariere das array spieler. lasse es auf anzahl Spieler viele spieler zeigen
			
			for(int i = 1; i < anzahlSpieler+1; i++)
			{
				spieler[i-1] = new Spieler(i, "Spieler "+i);	//fülle das array mit den spielern
				

				spieler[i-1].setHandkarten(zieheKarte());		//gebe jedem spieler 
				spieler[i-1].setHandkarten(zieheKarte());		//2 handkarten
				
			}
			
			this.setPiratenkönig(spieler[rand.nextInt(anzahlSpieler)]);  //setze einen zufälligen spieler als piratenkönig
			
			for(int i = 0; i < anzahlSpieler; i++)
				piratenkönig.setHandkarten(zieheKarte());		//gebe dem piratenkönig zusätzliche handkarten (anzahl = anzahl spieler)
			
			aktuelleSpielphase = 2;								//leite spielphase 2 ein
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static Verwaltung getInstance(){
		return VERWALTUNG;
	}
	
	////////////////////
	
	public int zieheKarte()
	{
		Karte karte = kartenstapel.getFirst(); //beim kartenstapel handelt es sich um eine linkedList. deshalb liefert getFirst immer die oberste karte des stapels.
		kartenstapel.removeFirst();				//wenn die karte genommen wurde, entferne sie vom kartenstapel
		return karte.getId();					//und gebe die id an den aufrufer zurück
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
		ArrayList<Spieler> spielerListe = new ArrayList<Spieler>();		//gebe eine ArrayList aller spieler zurück
		for (Spieler spieler : spieler) {
			spielerListe.add(spieler);
		}
		return spielerListe;
	}
	
	public Karte lieferHandkarte(int id)
	{
		switch(id)												//gebe für jede id einer karte
		{
			case 0: {return new SprechenderPapagei();}			//eine konkrete karte zurück (z.b. input 0 -> output sprechenderPapagei)
			case 1: {return new Schatzkarte();}					//usw.
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

			default: {System.out.println("wrong id"); break;}			//wenn id nicht bekannt, gib wrong id aus.
		
		
		
		}
		return null;											//sollte eigentlich nicht erreicht werden.
		
	}
}
