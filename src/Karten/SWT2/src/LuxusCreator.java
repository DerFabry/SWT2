package Karten.SWT2.src;


public class LuxusCreator extends Spielablauf{

	public void SpieleKarteAus(int id) throws Exception {
		if(id < 0 || id > 2)
		{
			if(id < 0 || id > 13)
				throw new ArrayIndexOutOfBoundsException("id nicht vorhanden (LuxusCreator)");
			else 
				throw new Exception("falscher Creator");
		}
		
		if(id == 0)
		{
			new SprechenderPapagei().kartenAktion();
		}
		else if(id == 1)
		{
			new Schatzkarte().kartenAktion();
			
		}
		else if(id == 2)
		{
			new Ausflugsboot().kartenAktion();
		}

	}

}
