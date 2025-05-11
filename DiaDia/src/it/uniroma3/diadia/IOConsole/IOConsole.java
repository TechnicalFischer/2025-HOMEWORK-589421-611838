package it.uniroma3.diadia.IOConsole;

import java.util.Scanner;

//import it.uniroma3.diadia.IOConsole.IOConsole.IO;

public class IOConsole implements IO {
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
	public String leggiParola() {

		Scanner scannerDiLinee = new Scanner(System.in);
		String parola = scannerDiLinee.next();
		return parola;

	}

	public String[]GetComandoEParametro(String istruzione){
		String ComandoEParametro[]=new String[2];
		Scanner scannerDiLinee = new Scanner(istruzione);
		if(scannerDiLinee.hasNext())ComandoEParametro[0]=scannerDiLinee.next();
		if(scannerDiLinee.hasNext())ComandoEParametro[1]=scannerDiLinee.next();
		return ComandoEParametro;
	}
}
