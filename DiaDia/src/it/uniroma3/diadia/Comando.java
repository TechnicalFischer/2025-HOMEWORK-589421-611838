package it.uniroma3.diadia;
import java.util.Scanner;
 
/**
* Questa classe modella un comando.
* Un comando consiste al piu' di due parole:
* il nome del comando ed un parametro
* su cui si applica il comando.
* (Ad es. alla riga digitata dall'utente "vai nord"
*  corrisponde un comando di nome "vai" e parametro "nord").
*
* @author  docente di POO
* @version base
*/
//Scanner per suddividere la stringa in parolePrima parola → diventa il nome del comando (es. "vai")Seconda parola → diventa il parametro (es. "nord")
public class Comando {
 
    private String nome;
    private String parametro;
    
    public Comando(String istruzione) {      
        if (istruzione == null) {   
            this.nome = null;
            this.parametro = null;
            return;
        }
 
        try (Scanner scannerDiParole = new Scanner(istruzione)) {
            if (scannerDiParole.hasNext())
                this.nome = scannerDiParole.next();
            if (scannerDiParole.hasNext())
                this.parametro = scannerDiParole.next();
        }
    }
 
    public String getNome() {
        return this.nome;
    }
 
    public String getParametro() {
        return this.parametro;
    }
 
    public boolean sconosciuto() {
        return (this.nome == null);
    }
}