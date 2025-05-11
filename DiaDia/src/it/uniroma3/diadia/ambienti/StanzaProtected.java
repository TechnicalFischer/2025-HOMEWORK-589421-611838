package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaProtected extends Stanza {
    protected String nome;
    protected Map<String, Stanza> stanzeAdiacenti;
    protected Attrezzo[] attrezzi;
    protected int numeroAttrezzi;
    protected static final int NUMERO_MASSIMO_ATTREZZI = 10;

    public StanzaProtected(String nome) {
        super(nome);
        this.nome = nome;
        this.stanzeAdiacenti = new HashMap<>();
        this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
        this.numeroAttrezzi = 0;
    }

     public String getDescrizione() {
        StringBuilder descrizione = new StringBuilder();
        descrizione.append(this.nome).append("\nUscite: ");
        for (String direzione : this.stanzeAdiacenti.keySet()) {
            descrizione.append(direzione).append(" ");
        }
        descrizione.append("\nAttrezzi nella stanza: ");
        if (this.numeroAttrezzi > 0) {
            for (int i = 0; i < this.numeroAttrezzi; i++) {
                descrizione.append(this.attrezzi[i].toString()).append(" ");
            }
        } else {
            descrizione.append("nessun attrezzo.");
        }
        return descrizione.toString();
    }
}