package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole.*;

public class ComandoGuarda implements Comando{

	private IO io;
	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
	@Override
	public void setParametro(String parametro) {}

	@Override
	public String getNome() {
		return "guarda";
	}

	@Override
	public String getParamero() {
		return null;
	}
	@Override
	public void setIO(IO io) {
		this.io=io;
	}
}
