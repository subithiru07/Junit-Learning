package com.contact.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.contact.ContactManger;

class ContactManagerTest {

	@Test
	@DisplayName("Positive seceniro")
	void testAddContact() {
		ContactManger contactManager = new ContactManger();
		contactManager.addContact("Thiru", "Baskaran", "0754064848");
		Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
		Assertions.assertEquals(1, contactManager.getAllContacts().size());
		
		Assertions.assertTrue(contactManager.getAllContacts().stream().
				filter(contacts -> contacts.getFirstname().equals("Thiru")
						&& contacts.getLastnamee().equals("Baskaran")
						&& contacts.getPhoneNumber().equals("0754064848")
						).findAny().isPresent());
		
	}
	
	@Test
	@DisplayName("Should not creatw Contact when Firstname is Null")
	public void shouldThrowRuntimeExceptionwhenFirstNameIsNull() {
		ContactManger contactManager = new ContactManger();
		Assertions.assertThrows(RuntimeException.class, ()->{
			contactManager.addContact(null, "Baskaran", "0754064848");
		});
		
		
	}
	
	@Test
	@DisplayName("Should not creatw Contact when Lastname is Null")
	public void shouldThrowRuntimeExceptionwhenLastNameIsNull() {
		ContactManger contactManager = new ContactManger();
		Assertions.assertThrows(RuntimeException.class, ()->{
			contactManager.addContact("Thiru", null, "0754064848");
		});
		
		
	}
	@Test
	@DisplayName("Should not creatw Contact when Lastname is Null")
	public void shouldThrowRuntimeExceptionwhenPhoneNumberIsNull() {
		ContactManger contactManager = new ContactManger();
		Assertions.assertThrows(RuntimeException.class, ()->{
			contactManager.addContact("Thiru", "Baskaran", null);
		});
		
		
	}
	
	
	
	@DisplayName("ParameterizedTest")
	@ParameterizedTest
	@ValueSource(strings = {"0994433477","0994455334"})
	void testAddContactValue(String phone) {
		ContactManger contactManager = new ContactManger();
		contactManager.addContact("Thiru", "Baskaran", phone);
		Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
		Assertions.assertEquals(1, contactManager.getAllContacts().size());
		
		
		
	}
	@DisplayName("ParameterizedTest")
	@ParameterizedTest
	@CsvSource({"Subin", "Thiru"})
	void testAddContactCSVValue(String name) {
		ContactManger contactManager = new ContactManger();
		contactManager.addContact(name, "Baskaran", "0754064848");
		Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
		Assertions.assertEquals(1, contactManager.getAllContacts().size());
		
		
		
	}
	
	
	
	
	

}
