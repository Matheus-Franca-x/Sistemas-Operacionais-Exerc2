package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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
		String process = null;
		if (OS().contains("Windows"))
		{
			process = "tasklist /fo table";
		}
		else if (OS().contains("Linux"))
		{
			process = "ps aux";
		}
		
		readProcess(process);
		
		
		
		
	}
	
	
	
	private void readProcess(String process)
	{
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null)
			{
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
			} catch (Exception e) {
			String msgErro = e.getMessage();
			System.out.println(msgErro);
		}
	}
	
	
	
	
}
