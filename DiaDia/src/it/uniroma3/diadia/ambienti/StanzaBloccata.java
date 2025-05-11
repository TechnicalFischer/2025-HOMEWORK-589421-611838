package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

// Classe StanzaBloccata
class StanzaBloccata extends Stanza {
    private String direzioneBloccata;
    private String nomeAttrezzoSblocco;

    public StanzaBloccata(String nome, String direzioneBloccata, String nomeAttrezzoSblocco) {
        super(nome);
        this.direzioneBloccata = direzioneBloccata;
        this.nomeAttrezzoSblocco = nomeAttrezzoSblocco;
    }

    @Override
    public Stanza getStanzaAdiacente(String direzione) {
        if (direzione == null)
            return null;
        if (direzione.equals(direzioneBloccata) && this.getAttrezzo(nomeAttrezzoSblocco) == null) {
            return this; // Restituisce la stanza stessa, indicando che è bloccata
        } else {
            return super.getStanzaAdiacente(direzione);
        }
    }

    @Override
    public String getDescrizione() {
        if (this.getAttrezzo(nomeAttrezzoSblocco) == null) {
            return "La stanza è bloccata in direzione " + direzioneBloccata + ".";
        } else {
            return super.getDescrizione();
        }
    }
}
