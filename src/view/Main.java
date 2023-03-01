package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main 
{
	public static void main(String[] args)
	{
		KillController controll = new KillController();
		
		int opcao = -1;
		String kill;
		
		while(opcao != 9)
		{
			opcao = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Sistema Operacional. \n 2 - Lista de Processos. \n 3 - Finalizar um Processo. \n 9 - Fechar programa."));

			switch(opcao)
			{
			case 1:
				controll.callOS();
				break;
			case 2:
				controll.listaProcessos();
				break;
			case 3:
				kill = JOptionPane.showInputDialog("Digite um PID ou um nome do processo para finalizar a tarefa.");
				controll.killProcess(kill);
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Obrigado por utilizar o nosso programa.");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcao invalida.");
			}
		}
	}
}
