package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole.IO;
import it.uniroma3.diadia.DiaDia;

public class ComandoAiuto implements Comando{
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "aiuto", "fine"};
	private IO io;
	
	private void aiuto() {
		this.io.mostraMessaggio( "Questi sono i comandi disponibili: \n");
		int i;
		for(i=0; i< elencoComandi.length -1; i++) 
			this.io.mostraMessaggio(i+1 + ")  " + elencoComandi[i]+"; ");
		this.io.mostraMessaggio(i+1 + ")  " + elencoComandi[i]+". ");
		this.io.mostraMessaggio("\n\t->  Comando 'vai' prevede che dopo si inserisca una direzione tra: ");
		this.io.mostraMessaggio("\n\t    'nord', 'sud', 'est' ed 'ovest'. Se non è spacificato nulla allora restituisce ");
		this.io.mostraMessaggio("\t    come si chiama la stanza, le sue uscite e gli attrezzi che contiene dentro");
		this.io.mostraMessaggio("\n\t->  Comando 'prendi' prevede che dopo si inserisca un attrezzo tra quelli presenti nella stanza");
		this.io.mostraMessaggio("\n\t->  Comando 'posa' prevede che dopo si inserisca un attrezzo tra quelli presenti nella borsa");
		this.io.mostraMessaggio("\n\t->  Comando 'guarda' restituisce la descrizione della stanza");
	}
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		for(int i=0; i< elencoComandi.length; i++) { 
			DiaDia.io.mostraMessaggio(elencoComandi[i]+" ");
		}
		DiaDia.io.mostraMessaggio("\n");
		this.aiuto();
	}

	@Override
	public void setParametro(String parametro) {
 
	}
	@Override
	public void setIO(IO io) {
		this.io=io;
	}
 

	@Override
	public String getNome() {
		return "aiuto";
	}

	@Override
	public String getParamero() {
		return null;
	}

}
