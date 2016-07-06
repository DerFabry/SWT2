package Karten.SWT2.src;


public class Kanonenboot extends Karte{

	private int kampfschritt;
	public Kanonenboot() {
		// TODO Auto-generated constructor stub
	
		super();
		this.setId(9);
		this.setName("Kanonenboot");
		// TODO Auto-generated constructor stub
	}
	public void setKampschritt(int kampfschritt)
	{
		this.kampfschritt = kampfschritt;
	}

	public int getKampfschritt()
	{
		return kampfschritt;
	}
	
	public void kartenAktion() {
		// TODO Auto-generated method stub
		
	}
}
