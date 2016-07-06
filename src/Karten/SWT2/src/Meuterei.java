package Karten.SWT2.src;


public class Meuterei extends Karte{

	
	
	private int kampfschritt;
	public Meuterei() {
		// TODO Auto-generated constructor stub
	
		super();
		this.setId(8);
		this.setName("Meuterei");
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
