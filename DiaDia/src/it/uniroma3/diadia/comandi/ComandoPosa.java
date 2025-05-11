package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.*;

public class ComandoPosa implements Comando{

	private String comandoDaEseguire;
	private IO io;
	public boolean posa(String attrezzo,Partita partita) {
		Stanza stanza=partita.getStanzaCorrente();
		Borsa borsa=partita.getGiocatore().getBorsa();
		if(attrezzo == null)
			this.io.mostraMessaggio("Attrezzo non specificato");
		Attrezzo attrezzoDaSpostare = null;
		if(stanza.StanzaPiena()) {
			this.io.mostraMessaggio("La stanza e' piena");
			return false;
		}
		attrezzoDaSpostare = borsa.removeAttrezzo(attrezzo);

		if(attrezzoDaSpostare != null) {
			stanza.addAttrezzo(attrezzoDaSpostare);
			this.io.mostraMessaggio("Attrezzo posato");
			return true;
		}
		else {
			this.io.mostraMessaggio("Attrezzo non trovato in borsa");
			return false;
		}
	}

	@Override
	public void setIO(IO io) {
		this.io=io;
	}
	@Override
	public void esegui(Partita partita) {
		this.posa(this.comandoDaEseguire,partita);

	}

	@Override
	public void setParametro(String parametro) {
		this.comandoDaEseguire=parametro;

	}


	@Override
	public String getNome() {
		return "posa";
	}


	@Override
	public String getParamero() {
		return this.comandoDaEseguire;
	}
}
