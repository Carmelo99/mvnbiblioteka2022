package rs.ac.bg.fon.nprog.mvnbiblioteka2022.biblioteka;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import rs.ac.bg.fon.nprog.mvnbiblioteka2022.biblioteka.interfejs.BibliotekaInterfejsTest;

public class BibliotekaTest extends BibliotekaInterfejsTest {

	@BeforeEach
	void setUp() throws Exception {
		biblioteka = new Biblioteka();
	}

	@AfterEach
	void tearDown() throws Exception {
		biblioteka = null;
	}

}
