package Karten.SWT2.src;


public class �berraschungsangriff extends Karte
{
	private int kampfschritt;
	
	public �berraschungsangriff() {
		// TODO Auto-generated constructor stub
	
		super();
		this.setId(7);
		this.setName("�berraschungsangriff");
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
