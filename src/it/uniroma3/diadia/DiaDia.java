package it.uniroma3.diadia;


//import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "aiuto", "fine"};

	private Partita partita;
	private IOConsole schermo;
//	private Giocatore giocatore;
//	private Labirinto labirinto;
//	private Borsa borsa;

	public DiaDia() {
		this.partita = new Partita();
		this.schermo = new IOConsole();
	}

	public void gioca() {
	    schermo.mostraMessaggio(MESSAGGIO_BENVENUTO);
	    String istruzione;
	    do {
	    	istruzione=schermo.leggiRiga();
	    }while(!processaIstruzione(istruzione));//manca il loop
	    
	    
	    //	    try (Scanner scannerDiLinee = new Scanner(System.in)) {
//	        String istruzione;
//	        do {
//	            istruzione = scannerDiLinee.nextLine();
//	        } while (!processaIstruzione(istruzione));
//	    }
	}   

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if(comandoDaEseguire.getNome()==null) {
			return false;
		}
		
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
			
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		
		else{schermo.mostraMessaggio("Comando sconosciuto");}
		
		
		if (this.partita.isFinita()) {
			if (this.partita.vinta()) {
				schermo.mostraMessaggio("Hai vinto!");
	 	        return true;
	    	 }
			schermo.mostraMessaggio("Termine Partita");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) { 
			schermo.mostraMessaggio(elencoComandi[i]+" ");
		}
		schermo.mostraMessaggio("\n");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			schermo.mostraMessaggio(direzione);
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.labirinto.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			schermo.mostraMessaggio(direzione);
		else {
			this.partita.labirinto.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.giocatore.getCfu();
			this.partita.giocatore.setCfu(--cfu);
		}
		schermo.mostraMessaggio(partita.toString());
	}
	
	private void prendi(String nomeAttrezzo) {
	    if (nomeAttrezzo == null) {
	        System.out.println("Quale attrezzo vuoi prendere?");
	        return;
	    }
 
	    Stanza stanzaCorrente = this.partita.labirinto.getStanzaCorrente();
	    Attrezzo attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);
 
	    if (attrezzo == null) {
	        System.out.println("Attrezzo " + nomeAttrezzo + " non presente in questa stanza.");
	        return;
	    }
 
	    // Accediamo alla borsa senza usare "getGiocatore()"
	    if (this.partita.labirinto.getStanzaCorrente().removeAttrezzo(attrezzo)) {
	        System.out.println("Hai preso " + nomeAttrezzo + " e l'hai messo nella borsa.");
	    } else {
	        System.out.println("Non puoi prendere " + nomeAttrezzo + ", la borsa è piena.");
	    }
	}
 
	/**
	 * Cerca di posare un attrezzo dalla borsa nella stanza corrente.
	 * Se l'attrezzo è nella borsa e c'è spazio nella stanza, lo rimuove dalla borsa
	 * e lo aggiunge alla stanza, altrimenti stampa un messaggio di errore
	 */
	private void posa(String nomeAttrezzo) {
		if (nomeAttrezzo == null) {
			this.schermo.mostraMessaggio("Quale attrezzo vuoi posare?");
			return;
		}
		Attrezzo attrezzo = null;
		attrezzo = this.partita.getGiocatore().getAttrezzo(nomeAttrezzo);
		if (attrezzo == null) {
			this.schermo.mostraMessaggio("Attrezzo inesistente nella borsa");
		}
		else {
			this.partita.posaAttrezzo(attrezzo);
		}
		this.partita.getGiocatore().togliUnCfu();
		this.stampa_stato_partita();
	}
	
	private void stampa_stato_partita() {
		this.schermo.mostraMessaggio(this.partita.labirinto.getStanzaCorrente().getDescrizione());
		this.schermo.mostraMessaggio(this.partita.getGiocatore().toString());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		schermo.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] args) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}