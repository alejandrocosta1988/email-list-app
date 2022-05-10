package model;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EmailTest {

	@Test
	void isValidReturnsFalseWhenFirstNameIsNotProvided() {
		
		Email email = new Email();
		email.setLastName("Costa");
		email.setEmailAddress("contato@alejandrocosta.dev.br");
		
		assertFalse(email.isValid());
		
	}
	
	@Test
	void isValidReturnsTrueWhenAllFieldsAreProvided() {
		
		Email email = new Email("Alejandro", "Costa", "contato@alejandrocosta.dev.br");
		
		assertTrue(email.isValid());
		
	}

}
