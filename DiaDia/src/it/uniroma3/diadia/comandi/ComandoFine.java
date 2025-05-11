package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole.IO;

public class ComandoFine implements Comando {
	private IO io;
	private void fine() {
		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	@Override
	public void esegui(Partita partita) {
		this.fine();

	}

	@Override
	public void setParametro(String parametro) {

	}

	@Override
	public String getNome() {
		return "fine";
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
