package Kampf;

import spieler.Spieler;

import java.util.*;


public class Kampf {
	
	private Spieler angreifer[];
	private Spieler verteidiger;

	
	
	///////////////////////////
	
	public Kampf(Spieler angreifer[], Spieler verteidiger)
	{
		
		this.angreifer = angreifer;
		this.verteidiger = verteidiger;
		
		
	}
	
	//////////////////////////
	
	public int wuerfle(int anzahlWürfel)  //ermittelt x mal eine zufallszahl zwischen 1 und 6 und addiert diese
	{
		if(anzahlWürfel <= 0)   //just in case
			return 0;
		
		int result = 0;
		Random rand = new Random();
		for(int i = 0; i < anzahlWürfel; i++)  //je anzahlWürfe (anz. kanonen) gehe durch den body
		{
			result += rand.nextInt(6)+1;  //würfle und addiere den wert zu ressult
			
		}
		return result;  
	}

	
	public boolean angriffErfolgreich()  //bei true gewinnen/gewinnt die/der angreifer. sonst der verteidiger
	{
		int angriffswertGesammt = 0;
		int länge = angreifer.length;
		int werte[] = new int[länge];
		Spieler neuerPiratenkönig = null;
		
		
		
		for(int i = 0; i < länge; i++)  //für alle angreifer
		{
			werte[i] = getAnzahlWürfe(angreifer[i]);  //speicher die anzahl der würfe (kanonen) in dem array werte
			angriffswertGesammt += angreifer[i].getAngreiferBonus(); //addiere den bonus (durch karten) zum angriffswertGesammt
		}
		
		for(int i = 0; i < länge; i++) //für alle angreifer
			for(int j= 0; j < werte[i]; j++)  //je angreifer wird x mal (kanonen) die for schleife durchlaufen
			{
				int würfelWurf = wuerfle(1);    //speicher den wurf in der var. würfelWurf
				int max = 0;
				if(würfelWurf>max)  //wenn der aktuelle wurf größer als max...
				{
					max = würfelWurf;  //setze den höchsten wert auf max
					neuerPiratenkönig = angreifer[i]; //und setze die var. neuerP. auf diesen Spieler
					
				}
				angriffswertGesammt += würfelWurf;  //addiere den würfelWurf zum angriffswert
			}
				
		
		if(getVerteidigungswert() >= angriffswertGesammt) //siegt der verteidiger oder die/der angreifer
		{													//hier hat der verteidiger gewonnen
			for(int i = 0; i < länge; i++)
			{
				angreifer[i].setAngriffsBonus(0);			//setze alle temp. bonusse durch handkarten zurück.
				angreifer[i].setVerteidigungsBonus(0);
				verteidiger.setAngriffsBonus(0);
				verteidiger.setVerteidigungsBonus(0);
			}

			return false;  //verteidiger siegt.  ende, falls verteidiger siegreich.
		}
															//hier hat/haben der/die angreifer gewonnen
		for(int i = 0; i < länge; i++)		
		{
			angreifer[i].setAngriffsBonus(0);		//setze alle temp. bonusse durch handkarten zurück.
			angreifer[i].setVerteidigungsBonus(0);
			verteidiger.setAngriffsBonus(0);
			verteidiger.setVerteidigungsBonus(0);
		}
		
		
		List<Integer> kartenListe = new LinkedList<Integer>();
														//verteile handkarten neu
		kartenListe = verteidiger.getHandkarten();      //nehme die akt. handkarten in die liste "kartenListe" auf
		
		Collections.shuffle(kartenListe);				//mische
		
		for(int i = 0; i < angreifer.length; i++)
			if(!kartenListe.isEmpty())
			{
				angreifer[i].setHandkarten(kartenListe.get(0));  //verteile die handkarten
				kartenListe.remove(0);
			}
		
		verteidiger.entferneHandkarten();		
		for(Integer karte : kartenListe)
			verteidiger.setHandkarten(karte);	//gebe die verbleibenden handkarten dem verteidiger zurück
		
		
		
		
		
		neuerPiratenkönig.setPiratenkönig();		//angreifer mit höchsten wert ist nun priratenkönig
		
		return true;  //angreifer siegt. ende
	}

	
	public int getAnzahlWürfe(Spieler angreifer)
	{
		int anzahlWürfe = 0;
		int anzahl = angreifer.getKanonen().size();
		
		List<Integer> kanonen = angreifer.getKanonen();
		
		
		for(int i = 0; i < anzahl; i++)					//für alle angreifer
			if(verteidiger.getId() == kanonen.get(i))  //je kanone, die auf den verteidiger gerichtet ist
				anzahlWürfe++;							//zähle anzahlWürfe hoch
		
		return anzahlWürfe;
	}
	
	public int getAnzahlWürfeVerteidiger(Spieler verteidiger)
	{
		int anzahlWürfe = 0;
		List<Integer> kanonen = verteidiger.getKanonen();
		
		for(int i = 0; i < kanonen.size(); i++) //je kanone, in der 
		{
			if(6 == kanonen.get(i))					//sich eine 6 befindet
				anzahlWürfe++;					//zähle anzahl hoch
		}
		
		
		
		return anzahlWürfe;
	}
	
	public int getVerteidigungswert()
	{
		int verteidigungswert = 0;    
		int anzahl = verteidiger.getKanonen().size();
		List<Integer> kanonen = verteidiger.getKanonen();    //speicher die verteidiger kanonen in der lok. liste kanonen
		
		for(int i = 0; i < anzahl; i++)  //für jede kanone
			if(kanonen.get(i) == 6)  		//wenn der wert 6 ist (sich selbst beschützend)
				verteidigungswert++;		//erhöhe den verteidigungswert
		
		if(verteidiger.getId() != verteidiger.getPiratenkönigId()) //sollte der verteidiger nicht der Piratenkönig sein
			verteidigungswert += wuerfle(getAnzahlWürfeVerteidiger(verteidiger));    //dann kann man würfeln
		else
			verteidigungswert += getAnzahlWürfeVerteidiger(verteidiger);  //sonst pro kanone + 1
		
		
		verteidigungswert += verteidiger.getAnzahlSchiffe();  //addiere anzahl schiffe
		verteidigungswert += verteidiger.getVerteidigungsBonus();  //addiere anzahl bonus (durch handkarten)
		
		return verteidigungswert;
	}
}
