package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	

	
	private boolean finita;
	
	public Giocatore giocatore;
	public Labirinto labirinto;
	
	public Partita(){
		this.labirinto = new Labirinto();
		this.finita = false;
		this.giocatore = new Giocatore();
	}
	
	public String toString() {
		String stringa = this.labirinto.getStanzaCorrente()+"\nCfu= "+this.giocatore.getCfu();
		return stringa;
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente()== this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() <= 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	

	/** 
	 * prendi attrezzo
	 */
//	public boolean prendiAttrezzo(Attrezzo attrezzo) {
//		boolean test = this.giocatore.addAttrezzo(attrezzo);
//		if (!test) return false;
//		this.labirinto.getStanzaCorrente().removeAttrezzo(attrezzo);
//		return true;
//	}
//	/**
//	 * posa attrezzo
//	 */
//	public boolean posaAttrezzo(Attrezzo attrezzo) {
//		boolean test = this.labirinto.getStanzaCorrente().addAttrezzo(attrezzo);
//		if (!test) return false;
//		this.giocatore.removeAttrezzo(attrezzo);
//		return true;
//	}
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.labirinto.stanzaCorrente = stanzaCorrente;
	}
	
	public Stanza getStanzaCorrente() {
		return this.labirinto.stanzaCorrente;
	}

	public boolean giocatoreIsVivo() {
		 if(this.giocatore.getCfu()>=0)
			 return true;
		 else return false;
	 }	
}
