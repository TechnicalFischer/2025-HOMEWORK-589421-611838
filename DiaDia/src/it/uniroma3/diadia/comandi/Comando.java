package it.uniroma3.diadia.comandi;

//import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole.IO;

public interface Comando {
	public void esegui(Partita partita);
	public void setParametro(String parametro);	
	public String getNome();
	public String getParamero();
	public void setIO(IO io);
	
}
