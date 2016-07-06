package Karten.SWT2.src;


public class Beute extends Karte{

	private int betrag;
	public Beute() {
		super();
		this.setId(3);
		this.setName("Beute");
		// TODO Auto-generated constructor stub
	}
	public void setBetrag(int betrag)
	{
		this.betrag = betrag;
	}
	
	public int getBetrag()
	{
		return betrag;
	}
	
	public void kartenAktion() {
		// TODO Auto-generated method stub
		
	}

}
