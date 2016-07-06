package Karten.SWT2.src;


public class KampfCreator extends Spielablauf{

	public Karte SpieleKarteAus(int id) throws ArrayIndexOutOfBoundsException, Exception 
	{
		
		if (id < 7 || id > 13)
			if(id < 7 && id > 0)
				throw new Exception("falscher creator");
			else
				throw new ArrayIndexOutOfBoundsException("id kleiner als 0 oder größer als 13 (KampfCreator)");
			
		
		if(id == 7)
			return new Überraschungsangriff();
			
		else if(id == 8)
			return new Meuterei();
			
		else if(id == 9)
			return new Kanonenboot();
		
		else if(id == 10)		
			return new Bestechung();
		
		else if(id == 11)	
			return new NassesPulver();
			
		else if(id == 12)
			return new Kapern();
			
		else if(id == 13)		
			return new SchlechterWind();
		
		return null;
	
	}

}
