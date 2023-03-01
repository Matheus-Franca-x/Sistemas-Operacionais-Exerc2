package controller;

import java.io.BufferedReader;
import java.io.IOException;
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
	
	public void callOS()
	{
		System.out.println(OS());
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
			process = "ps -ef";
		}
		
		readProcess(process);
			
	}
	
	public void killProcess(String param)
	{
		String pidKill;
		String nomeKill;
		
		if(OS().contains("Windows"))
		{
			pidKill = "taskkill /pid";
			nomeKill = "taskkill /im";
		}
		else
		{
			pidKill = "kill -9";
			nomeKill = "pkill -f";
		}
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		
		//NumberFormatException
		try
		{
			pid = Integer.parseInt(param);
			buffer.append(pidKill);
			buffer.append(" ");
			buffer.append(pid);
		} catch(NumberFormatException e) {
			buffer.append(nomeKill);
			buffer.append(" ");
			buffer.append(param);
		}
		
		 callProcess(buffer.toString());
		
	}
	
	private void callProcess(String process) 
	{
		try
		{
			Runtime.getRuntime().exec(process);
		} catch(Exception e) {
			String msgErro = e.getMessage();
			if(msgErro.contains("740"))
			{
				StringBuffer buffer = new StringBuffer();
				if(OS().contains("Windows"))
				{
					buffer.append("cmd /c");
					buffer.append(" ");
				}
					buffer.append(process);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			else 
			{
				System.err.println(msgErro);
			}
		}
	}
	
	private void readProcess(String process)
	{
		try 
		{
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
