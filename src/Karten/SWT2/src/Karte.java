package Karten.SWT2.src;


public abstract class Karte {
	
	private int id;
	private String name;
	private String text;
	
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getText()
	{
		return text;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setText(String text)
	{
		this.text = text;
	}
	
	public abstract void kartenAktion();
	

}
