package controller;

public class KillController 
{
	public KillController()
	{
		super();
	}
	
	private String OS()
	{
		String os = System.getProperty("os.name");
		String arch = System.getProperty("os.arch");
		String version = System.getProperty("os.version");
		
		return os + " - v. " + version + " - arch. " + arch;
	}
	
	public String callOS()
	{
		return OS();
	}
	
	public void listaProcessos()
	{
		
	}
	
	
	
	
}
