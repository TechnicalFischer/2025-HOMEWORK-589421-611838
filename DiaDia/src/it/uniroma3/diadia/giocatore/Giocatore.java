//Giocatore ha la responsabilità di gestire i CFU del giocatore e di
//memorizzare gli attrezzi in un oggetto istanza della classe Borsa
//>>(vedi codice a seguire)
//– aggiungere un riferimento ad un'istanza di Giocatore nella classe
//Partita (che ovviamente dovrà essere liberata dalle
//responsabilità spostate nella nuova classe)
package it.uniroma3.diadia.giocatore;
//import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
	
	static final public int CFU_INIZIALI = 12;
	public int cfu;
    private Borsa borsa;

	
    public Giocatore() {
        this.borsa = new Borsa();
        this.cfu = CFU_INIZIALI;

    }
    
    /*
     * I metodi add - has - get - remove
     */
    public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	
    public void togliUnCfu() {
    	this.cfu--;
    }
    
    public boolean hasZeroCfu() {
    	return this.cfu <= 0;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Giocatore con " + this.cfu + " cfu");
        s.append("\n");
        s.append(borsa);
        return s.toString();
    }

	public Borsa getBorsa() {
		return borsa;
	}
}
