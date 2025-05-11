package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole.IO;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi implements Comando{
	private String attrezzo;
	private IO io;
	@Override
	public void esegui(Partita partita) {
		if(this.attrezzo==null) {
			this.io.mostraMessaggio("Attrezzo non specificato");
			return;
		}
		
		Stanza stanza= partita.getStanzaCorrente();
		Borsa borsa= partita.getGiocatore().getBorsa();
		boolean messo;
		Attrezzo attrezzoDaSpostare=stanza.getAttrezzo(attrezzo);
		if(attrezzoDaSpostare == null)
			this.io.mostraMessaggio("Attrezzo non trovato nella stanza");
		else {
			messo = borsa.addAttrezzo(attrezzoDaSpostare);
			if(messo) {
				this.io.mostraMessaggio("Attrezzo messo in borsa!");
				stanza.removeAttrezzo(attrezzoDaSpostare);
			}else {
				this.io.mostraMessaggio("Inserimento attrezzo non riuscito");
			}
		}
		
	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo=parametro;
	}
	@Override
	public String getNome() {
		return "prendi";
	}
	@Override
	public String getParamero() {
		return this.attrezzo;
	}
	@Override
	public void setIO(IO io) {
		this.io=io;
	}
	
}
