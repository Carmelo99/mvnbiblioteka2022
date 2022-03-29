package rs.ac.bg.fon.nprog.mvnbiblioteka2022.biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutorTest {

	Autor a;
	
	@BeforeEach
	public void setUp() throws Exception {
		a = new Autor();
	}

	@AfterEach
	public void tearDown() throws Exception {
		a = null;
	}

	@Test
	public void testSetIme() {
		a.setIme("Pera");
		
		assertEquals("Pera", a.getIme() );
	}
	
	@Test
	public void testSetImePrazanString() {
		assertThrows(java.lang.IllegalArgumentException.class,
				() -> a.setIme("") );
	}
	
	@Test
	public void testSetImeNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> a.setIme(null) );
	}

	@Test
	public void testSetPrezime() {
		a.setPrezime("Peric");
		
		assertEquals("Peric", a.getPrezime());
	}
	
	@Test
	public void testSetPrezimePrazanString() {
		assertThrows(java.lang.IllegalArgumentException.class,
				() -> a.setPrezime("") );
	}
	
	@Test
	public void testSetPrezimeNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> a.setPrezime(null) );
	}

	@Test
	public void testToString() {
		a.setIme("Zika");
		a.setPrezime("Zikic");
		
		String s = a.toString();
		
		assertTrue(s.contains("Zika"));
		assertTrue(s.contains("Zikic"));
	}

	@ParameterizedTest
	@CsvSource({
			"Pera, Peric, Pera, Peric, true",
			"Pera, Peric, Pera, Tomic, false",
			"Pera, Peric, Zika, Peric, false",
			"Pera, Peric, Mika, Mikic, false"
	})
	public void testEqualsObject(String ime1, String prezime1,
			String ime2, String prezime2, boolean equals) {
		
		a.setIme(ime1);
		a.setPrezime(prezime1);
		
		Autor b = new Autor();
		b.setIme(ime2);
		b.setPrezime(prezime2);
		
		assertEquals(equals, a.equals(b) );		
	}
	
	@Test
	@DisplayName("testiranje konstruktora sa dva parametra")
	public void testAutorStringString() {
		a = new Autor("Laza", "Lazic");
		
		assertEquals("Laza", a.getIme());
		assertEquals("Lazic", a.getPrezime());
	}

}
