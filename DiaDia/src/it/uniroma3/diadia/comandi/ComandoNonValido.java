package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole.IO;

public class ComandoNonValido implements Comando{
	private IO io;
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		this.io.mostraMessaggio("Comando non valido");;
	}

	@Override
	public void setParametro(String parametro) {
		
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "parametro non valido...";
	}

	@Override
	public String getParamero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIO(IO io) {
		// TODO Auto-generated method stub
		this.io=io;
	}

}
