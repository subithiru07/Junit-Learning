package com.contact;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContactManger {
	
	Map<String,Contact> contactlist = new ConcurrentHashMap<String,Contact>();
	
	public void addContact(String firstName, String lastName, String phoneNumber) {
		Contact contact = new Contact(firstName,lastName,phoneNumber);
		validateContact(contact);
		checkifContactAlreadyExists(contact);
		contactlist.put(generateKey(contact), contact);
		
		
	}
	
	
	public String generateKey(Contact contact) {
		return String.format("%s-%s", contact.getFirstname(),contact.getLastnamee());
	}
	
	public void validateContact(Contact contact) {
		contact.validateFirstName();
		contact.validateLastName();
		contact.validatePhoneNumber();
	}
	
	private void checkifContactAlreadyExists(Contact contact) {
		if(contactlist.containsKey(generateKey(contact)))
			throw new RuntimeException("Contact Already exist");
	}
	
	public Collection<Contact> getAllContacts(){
		return contactlist.values();
	}
	
	

}
