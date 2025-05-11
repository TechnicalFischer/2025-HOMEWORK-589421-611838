package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;
//import it.uniroma3.diadia.attrezzi.ListaAttrezzi;

public class Borsa {
    public final static int DEFAULT_PESO_MAX_BORSA = 10;
    private int pesoMax;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
//    private ListaAttrezzi listaAttrezzi;

    public Borsa() {
        this(DEFAULT_PESO_MAX_BORSA);
    }

    public Borsa(int pesoMax) {
        this.pesoMax = pesoMax;
        this.attrezzi = new Attrezzo[10]; 
		this.numeroAttrezzi = 0;
    }
    /*
     * I metodi add - has - get - remove
     */
	
//    public boolean addAttrezzo(Attrezzo attrezzo) {
//        if (this.listaAttrezzi.getPeso() + attrezzo.getPeso() > this.pesoMax) {
//            return false;
//        }
//        return this.listaAttrezzi.addAttrezzo(attrezzo);
//    }
    public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
//    public boolean hasAttrezzo(String nomeAttrezzo) {
//        return this.listaAttrezzi.hasAttrezzo(nomeAttrezzo);
//    }
//
//    public Attrezzo getAttrezzo(String nomeAttrezzo) {
//        return this.listaAttrezzi.getAttrezzo(nomeAttrezzo);
//    }
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];

		return a;
	}
    
//
//    public boolean removeAttrezzo(Attrezzo attrezzo_da_rimuovere) {
//        return this.listaAttrezzi.removeAttrezzo(attrezzo_da_rimuovere);
//    }
    public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		if(this.numeroAttrezzi==0||this.getAttrezzo(nomeAttrezzo)==null)return null;
		Attrezzo a = null;
		boolean rimosso = false;
		int i=0;
		int j;
		if(numeroAttrezzi!=0) {
			for(i=0; i < numeroAttrezzi && !rimosso; i++) {

				if(attrezzi[i].getNome().equals(nomeAttrezzo)) {
					rimosso = true;
					a = attrezzi[i];
					j=i;

					if(j < this.numeroAttrezzi-1)	//sono in mezzo all'array
						for(j=i; j < this.numeroAttrezzi-1; j++)						
							this.attrezzi[j]=this.attrezzi[j+1];
					else	//sono alla fine dell'array
						this.attrezzi[j]=null;


					this.numeroAttrezzi--;
				}
			}
		}
		return a;
	}
//	public int getPeso() {
//        return this.listaAttrezzi.getPeso();
//	}

//	public boolean isEmpty() {
//        return this.listaAttrezzi.isEmpty();
//	}
    
    
	
	
    public String toString(){
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();

		return peso;
	}
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
}

