package Karten.SWT2.src;


public class SonstigesCreator extends Spielablauf
{

	public void SpieleKarteAus(int id) throws ArrayIndexOutOfBoundsException, Exception 
	{
		if (id < 4 || id > 6)
			if(id < 0 || id > 13)
				throw new ArrayIndexOutOfBoundsException("id kleiner als 0 oder größer als 13 (SonstigesCreator)");
			else 
				throw new Exception("falscher creator");
		
		
		
		if(id == 4)
			new Flaute().kartenAktion();
		
		else if (id == 5)
			new Waffenschmied().kartenAktion();
		
		else if (id == 6)
			new Spion().kartenAktion();
		
	}

	
}
