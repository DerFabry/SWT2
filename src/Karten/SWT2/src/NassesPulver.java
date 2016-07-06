package Karten.SWT2.src;


public class NassesPulver extends Karte{
	
	private int kampfschritt;
	public NassesPulver() {
		// TODO Auto-generated constructor stub
	
		super();
		this.setId(11);
		this.setName("Nasses Pulver");
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
