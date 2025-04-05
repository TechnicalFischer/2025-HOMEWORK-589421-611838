//Giocatore ha la responsabilità di gestire i CFU del giocatore e di
//memorizzare gli attrezzi in un oggetto istanza della classe Borsa
//>>(vedi codice a seguire)
//– aggiungere un riferimento ad un'istanza di Giocatore nella classe
//Partita (che ovviamente dovrà essere liberata dalle
//responsabilità spostate nella nuova classe)
package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

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
    
    public boolean addAttrezzo(Attrezzo attrezzo) {
        return this.borsa.addAttrezzo(attrezzo) ;
    }
    
    public boolean hasAttrezzo(String nomeAttrezzo) {
    	return this.borsa.hasAttrezzo(nomeAttrezzo);
    }
    
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
    	return this.borsa.getAttrezzo(nomeAttrezzo);
    }
    
    public boolean removeAttrezzo(Attrezzo attrezzo) {
        return this.borsa.removeAttrezzo(attrezzo) ;
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
}
