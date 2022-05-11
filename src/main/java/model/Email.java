package model;

import java.io.Serializable;

public class Email implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String firstName = "";
	private String lastName = "";
	private String emailAddress = "";
	
	public Email() {
		super();
	};
	
	public Email(String firstName, String lastName, String emailAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public boolean isValid() {
		if (isFirstNameValid() && isLastNameValid() && isEmailAddressValid()) {
			return true;
		}
		return false;
	}
	
	private boolean isFirstNameValid() {
		if (this.firstName == null || this.firstName.isEmpty()) {
			return false;
		}
		return true;
	}
	
	private boolean isLastNameValid() {
		if (this.lastName == null || this.lastName.isEmpty()) {
			return false;
		}
		return true;
	}
	
	private boolean isEmailAddressValid() {
		if (this.emailAddress == null || this.emailAddress.isEmpty()) {
			return false;
		}
		return true;
	}
	

}
