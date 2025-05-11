package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.util.HashMap;
import java.util.Map;

// StanzaMagicaProtected che estende StanzaProtected (con campi protetti)
class StanzaMagicaProtected extends StanzaProtected {
    private static final long serialVersionUID = 1L;

    public StanzaMagicaProtected(String nome) {
        super(nome);
    }

    @Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (attrezzo == null || numeroAttrezzi == attrezzi.length)
            return false;
        String nome = attrezzo.getNome();
        int peso = attrezzo.getPeso();
        if (isVocale(nome.charAt(0))) {
            nome = new StringBuilder(nome).reverse().toString();
            peso *= 2;
        }
        Attrezzo attrezzoModificato = new Attrezzo(nome, peso);
        attrezzi[numeroAttrezzi] = attrezzoModificato;
        numeroAttrezzi++;
        return true;
    }

    private boolean isVocale(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
