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
		if (this.firstName != null && this.lastName != null && this.emailAddress != null &&
			!this.firstName.isEmpty() && !this.lastName.isEmpty() && !this.emailAddress.isEmpty()) {
			
			return true;
			
		}
		return false;
	}

}
