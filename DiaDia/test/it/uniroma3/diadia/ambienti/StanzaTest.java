package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
 * classe di test Stanza
 */
class StanzaTest {
	private Stanza stanza;
    private Attrezzo spada;
	
	@BeforeEach
	
	public void setUp() throws Exception {
		this.stanza=new Stanza("n11");	
		this.spada=new Attrezzo ("spada",10);
	}

	
	@Test
	void testHasAttrezzoStanzaVuota () {
		assertFalse(this.stanza.hasAttrezzo("spada"));
	}
	
	@Test
	void testHasAttrezzo() {
		assertFalse(this.stanza.hasAttrezzo("spada"));
		this.stanza.addAttrezzo(this.spada);
		assertTrue(this.stanza.hasAttrezzo("spada"));
	}
	
	@Test
	void testRemoveAttrezzo() {
		assertFalse(this.stanza.removeAttrezzo(spada));
		this.stanza.addAttrezzo(this.spada);
		assertTrue(this.stanza.removeAttrezzo(spada));
	}
}