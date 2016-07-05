package Karten.SWT2.src;


public class KampfCreator extends Spielablauf{

	public void SpieleKarteAus(int id) throws ArrayIndexOutOfBoundsException, Exception 
	{
		
		if (id < 7 || id > 13)
			if(id < 7 && id > 0)
				throw new Exception("falscher creator");
			else
				throw new ArrayIndexOutOfBoundsException("id kleiner als 0 oder größer als 13 (KampfCreator)");
			
		
		if(id == 7)
			new Überraschungsangriff().kartenAktion();
			
		else if(id == 8)
			new Meuterei().kartenAktion();
			
		else if(id == 9)
			new Kanonenboot().kartenAktion();
		
		else if(id == 10)		
			new Bestechung().kartenAktion();
		
		else if(id == 11)	
			new NassesPulver().kartenAktion();
			
		else if(id == 12)
			new Kapern().kartenAktion();
			
		else if(id == 13)		
			new SchlechterWind().kartenAktion();
	
	}

}
