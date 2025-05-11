package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole.IO;
//import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.Partita;
//import it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.ambienti.Stanza;
public class ComandoVai implements Comando {
	private String direzione;
	private IO io;
	public ComandoVai(){
	}

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		// qui il codice per cambiare stanza ...
		{
			Stanza stanzacorrente=partita.getStanzaCorrente();
			Stanza prossimaStanza=null;
			if(this.direzione==null) {
				this.io.mostraMessaggio("Direzione non specificata");
				return;}
			prossimaStanza = stanzacorrente.getStanzaAdiacente(this.direzione);
			if (prossimaStanza == null) {
				this.io.mostraMessaggio("Direzione inesistente");
			}
			else {
				partita.setStanzaCorrente(prossimaStanza);
				this.io.mostraMessaggio(partita.getStanzaCorrente().getNome());
				partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
			}
		}
	}
	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;
	}
	@Override
	public String getNome() {
		return "vai";
	}
	@Override
	public String getParamero() {
		return this.direzione;
	}

	@Override
	public void setIO(IO io) {
		this.io=io;
	}
}
