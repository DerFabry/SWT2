package Karten.SWT2.src;


public class Überraschungsangriff extends Karte
{
	private int kampfschritt;
	
	public Überraschungsangriff() {
		// TODO Auto-generated constructor stub
	
		super();
		this.setId(7);
		this.setName("Überraschungsangriff");
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
