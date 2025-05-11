package it.uniroma3.diadia.IOConsole;

public interface IO {
	public void mostraMessaggio(String messaggio);
	public String leggiRiga();
	public String[] GetComandoEParametro(String istruzione);
}