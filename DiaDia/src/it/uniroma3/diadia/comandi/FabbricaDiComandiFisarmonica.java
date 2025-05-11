package it.uniroma3.diadia.comandi;
//import it.uniroma3.diadia.DiaDia;
import java.util.Scanner;
import it.uniroma3.diadia.IOConsole.IO;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
	IO io;
	public FabbricaDiComandiFisarmonica(IO io) {
		this.io=io;
	}
	public Comando costruisciComando(String istruzione) {
		
		String nomeComando=null;
		String parametro=null;
		Comando comando = null;
		//String leggi=this.io.leggiRiga();
		String [] comandoeparametro=this.io.GetComandoEParametro(istruzione);
		if (comandoeparametro[0]!=null)
			nomeComando =comandoeparametro[0]; // prima parola: nome del comando
		if (comandoeparametro[1]!=null)
			parametro = comandoeparametro[1]; // seconda parola: eventuale parametro
		if (nomeComando==null)
			comando = new ComandoNonValido();
		else if (nomeComando.equals("vai")) {
			comando = new ComandoVai();
			comando.setParametro(parametro);}
		else if (nomeComando.equals("prendi")) {
			comando = new ComandoPrendi();
			comando.setParametro(parametro);}
		else if (nomeComando.equals("posa")) {
			comando = new ComandoPosa();
			comando.setParametro(parametro);
			comando.setParametro(parametro);}
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto();
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine();
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda();
		else comando = new ComandoNonValido();
		comando.setIO(io);
		return comando;
	}
}