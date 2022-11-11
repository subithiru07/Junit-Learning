package com.contact;



public class Contact {

	private String firstname ;
	public String getFirstname() {
		return firstname;
	}

	public String getLastnamee() {
		return lastnamee;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	private String lastnamee;
	private String phoneNumber;
	
	public Contact(String firstname, String lastnamee, String phoneNumber) {
		super();
		this.firstname = firstname;
		this.lastnamee = lastnamee;
		this.phoneNumber = phoneNumber;
	}
	
	public void validateFirstName() {
		if(this.firstname.isBlank()) 
			throw new RuntimeException("Firstname is null");
		
	}
	public void validateLastName() {
		if(this.lastnamee.isBlank())
			throw new RuntimeException("Lastname is null");
	}
	public void validatePhoneNumber() {
		if(this.phoneNumber.length()!=10) {
			throw new RuntimeException("Phone Number should be 10 digit");
			
		}
		
//		if (this.phoneNumber.matches("\\d+")) {
//			throw new RuntimeException("Phone Number should contains only number");
//			
//		}
		if(!this.phoneNumber.startsWith("0")) {
			throw new RuntimeException("Phonw Number should starts with Zero");
		}
	}
	

}
