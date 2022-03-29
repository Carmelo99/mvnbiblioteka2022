package rs.ac.bg.fon.nprog.mvnbiblioteka2022.biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KnjigaTest {

	Knjiga k;
	
	@BeforeEach
	public void setUp() throws Exception {
		k = new Knjiga();
	}

	@AfterEach
	public void tearDown() throws Exception {
		k = null;
	}

	@Test
	public void testSetNaslov() {
		k.setNaslov("Naslov 1");
		
		assertEquals("Naslov 1", k.getNaslov());
	}
	
	@Test
	public void testSetNaslovPrazanString() {
		assertThrows(java.lang.IllegalArgumentException.class,
				() -> k.setNaslov("") );
	}
	
	@Test
	public void testSetNaslovNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> k.setNaslov(null) );
	}

	@ParameterizedTest
	@CsvSource({
		"1", "2", "12"
	})
	public void testSetIsbnDozvoljen(long isbn) {
		k.setIsbn(isbn);
		
		assertEquals(isbn, k.getIsbn());
	}

	@ParameterizedTest
	@CsvSource({
		"0", "-1", "-23232"
	})
	public void testSetISBNNedozvoljen(long isbn) {
		assertThrows(java.lang.IllegalArgumentException.class,
				() -> k.setIsbn(isbn) );
	}

	@Test
	public void testSetAutori() {
		Autor a1 = new Autor("Pera", "Peric");
		Autor a2 = new Autor("Mika", "Mikic");
		
		LinkedList<Autor> autori = new LinkedList<Autor>();
		autori.add(a1);
		autori.add(a2);
		
		k.setAutori(autori);
		
		assertEquals(autori, k.getAutori());
	}

	@Test
	public void testSetIzdavac() {
		k.setIzdavac("izdavac 1");
		
		assertEquals("izdavac 1", k.getIzdavac());
	}

	@Test
	public void testSetIzdavacPrazanString() {
		assertThrows(java.lang.IllegalArgumentException.class,
				() -> k.setIzdavac("") );
	}
	
	@Test
	public void testSetIzdavacNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> k.setIzdavac(null) );
	}

	@ParameterizedTest
	@CsvSource({
		"1", "2", "32"
	})
	public void testSetIzdanjeDozvoljen(int izdanje) {
		k.setIzdanje(izdanje);
	}

	@ParameterizedTest
	@CsvSource({
		"0", "-1", "-122"
	})
	public void testSetIzdanjeNedozvoljen(int izdanje) {
		assertThrows(java.lang.IllegalArgumentException.class,
				() -> k.setIzdanje(izdanje) );
	}

	@Test
	public void testToString() {
		Autor a1 = new Autor("Pera", "Peric");
		Autor a2 = new Autor("Mika", "Mikic");
		
		LinkedList<Autor> autori = new LinkedList<Autor>();
		autori.add(a1);
		autori.add(a2);
		
		k.setAutori(autori);
		k.setIsbn(1234);
		k.setNaslov("Naslov 1");
		k.setIzdanje(555);
		k.setIzdavac("Izdavac 1");
		
		String s = k.toString();
		assertTrue(s.contains("1234"));
		assertTrue(s.contains("Naslov 1"));
		assertTrue(s.contains("Izdavac 1"));
		assertTrue(s.contains("555"));
		assertTrue(s.contains("Pera"));
		assertTrue(s.contains("Peric"));
		assertTrue(s.contains("Mika"));
		assertTrue(s.contains("Mikic"));
	}

	@ParameterizedTest
	@CsvSource({
			"1234, 1234, true",
			"543, 4322, false"
	})
	public void testEqualsObject(long isbn1, long isbn2, boolean eq) {
		k.setIsbn(isbn1);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn(isbn2);
		
		assertEquals(eq, k.equals(k2));
	}

}
