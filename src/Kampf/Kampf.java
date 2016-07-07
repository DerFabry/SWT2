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
	
	public int wuerfle(int anzahlW�rfel)  //ermittelt x mal eine zufallszahl zwischen 1 und 6 und addiert diese
	{
		if(anzahlW�rfel <= 0)   //just in case
			return 0;
		
		int result = 0;
		Random rand = new Random();
		for(int i = 0; i < anzahlW�rfel; i++)  //je anzahlW�rfe (anz. kanonen) gehe durch den body
		{
			result += rand.nextInt(6)+1;  //w�rfle und addiere den wert zu ressult
			
		}
		return result;  
	}

	
	public boolean angriffErfolgreich()  //bei true gewinnen/gewinnt die/der angreifer. sonst der verteidiger
	{
		int angriffswertGesammt = 0;
		int l�nge = angreifer.length;
		int werte[] = new int[l�nge];
		Spieler neuerPiratenk�nig = null;
		
		
		
		for(int i = 0; i < l�nge; i++)  //f�r alle angreifer
		{
			werte[i] = getAnzahlW�rfe(angreifer[i]);  //speicher die anzahl der w�rfe (kanonen) in dem array werte
			angriffswertGesammt += angreifer[i].getAngreiferBonus(); //addiere den bonus (durch karten) zum angriffswertGesammt
		}
		
		for(int i = 0; i < l�nge; i++) //f�r alle angreifer
			for(int j= 0; j < werte[i]; j++)  //je angreifer wird x mal (kanonen) die for schleife durchlaufen
			{
				int w�rfelWurf = wuerfle(1);    //speicher den wurf in der var. w�rfelWurf
				int max = 0;
				if(w�rfelWurf>max)  //wenn der aktuelle wurf gr��er als max...
				{
					max = w�rfelWurf;  //setze den h�chsten wert auf max
					neuerPiratenk�nig = angreifer[i]; //und setze die var. neuerP. auf diesen Spieler
					
				}
				angriffswertGesammt += w�rfelWurf;  //addiere den w�rfelWurf zum angriffswert
			}
				
		
		if(getVerteidigungswert() >= angriffswertGesammt) //siegt der verteidiger oder die/der angreifer
		{													//hier hat der verteidiger gewonnen
			for(int i = 0; i < l�nge; i++)
			{
				angreifer[i].setAngriffsBonus(0);			//setze alle temp. bonusse durch handkarten zur�ck.
				angreifer[i].setVerteidigungsBonus(0);
				verteidiger.setAngriffsBonus(0);
				verteidiger.setVerteidigungsBonus(0);
			}

			return false;  //verteidiger siegt.  ende, falls verteidiger siegreich.
		}
															//hier hat/haben der/die angreifer gewonnen
		for(int i = 0; i < l�nge; i++)		
		{
			angreifer[i].setAngriffsBonus(0);		//setze alle temp. bonusse durch handkarten zur�ck.
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
			verteidiger.setHandkarten(karte);	//gebe die verbleibenden handkarten dem verteidiger zur�ck
		
		
		
		
		
		neuerPiratenk�nig.setPiratenk�nig();		//angreifer mit h�chsten wert ist nun priratenk�nig
		
		return true;  //angreifer siegt. ende
	}

	
	public int getAnzahlW�rfe(Spieler angreifer)
	{
		int anzahlW�rfe = 0;
		int anzahl = angreifer.getKanonen().size();
		
		List<Integer> kanonen = angreifer.getKanonen();
		
		
		for(int i = 0; i < anzahl; i++)					//f�r alle angreifer
			if(verteidiger.getId() == kanonen.get(i))  //je kanone, die auf den verteidiger gerichtet ist
				anzahlW�rfe++;							//z�hle anzahlW�rfe hoch
		
		return anzahlW�rfe;
	}
	
	public int getAnzahlW�rfeVerteidiger(Spieler verteidiger)
	{
		int anzahlW�rfe = 0;
		List<Integer> kanonen = verteidiger.getKanonen();
		
		for(int i = 0; i < kanonen.size(); i++) //je kanone, in der 
		{
			if(6 == kanonen.get(i))					//sich eine 6 befindet
				anzahlW�rfe++;					//z�hle anzahl hoch
		}
		
		
		
		return anzahlW�rfe;
	}
	
	public int getVerteidigungswert()
	{
		int verteidigungswert = 0;    
		int anzahl = verteidiger.getKanonen().size();
		List<Integer> kanonen = verteidiger.getKanonen();    //speicher die verteidiger kanonen in der lok. liste kanonen
		
		for(int i = 0; i < anzahl; i++)  //f�r jede kanone
			if(kanonen.get(i) == 6)  		//wenn der wert 6 ist (sich selbst besch�tzend)
				verteidigungswert++;		//erh�he den verteidigungswert
		
		if(verteidiger.getId() != verteidiger.getPiratenk�nigId()) //sollte der verteidiger nicht der Piratenk�nig sein
			verteidigungswert += wuerfle(getAnzahlW�rfeVerteidiger(verteidiger));    //dann kann man w�rfeln
		else
			verteidigungswert += getAnzahlW�rfeVerteidiger(verteidiger);  //sonst pro kanone + 1
		
		
		verteidigungswert += verteidiger.getAnzahlSchiffe();  //addiere anzahl schiffe
		verteidigungswert += verteidiger.getVerteidigungsBonus();  //addiere anzahl bonus (durch handkarten)
		
		return verteidigungswert;
	}
}
