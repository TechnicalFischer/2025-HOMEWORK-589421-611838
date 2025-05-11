package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

// Classe StanzaBuia
public class StanzaBuia extends Stanza {
    private String nomeAttrezzoLuce;

    public StanzaBuia(String nome, String nomeAttrezzoLuce) {
        super(nome);
        this.nomeAttrezzoLuce = nomeAttrezzoLuce;
    }

    @Override
    public String getDescrizione() {
        if (this.getAttrezzo(nomeAttrezzoLuce) != null) {
            return super.getDescrizione();
        } else {
            return "Qui c'è un buio pesto";
        }
    }
}
