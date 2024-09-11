package com.example.prueba.entity;

public class User {

	private String documentType;
	private String documentNumber;
	private String firstName;
    private String middleName;
    private String lastName;
    private String secondLastName;
    private String phoneNumber;
    private String address;
    private String city;

    
    
    public User(String documentType, String documentNumber, String firstName, String middleName, String lastName,
			String secondLastName, String phoneNumber, String address, String city) {
		this.documentType = documentType;
		this.documentNumber = documentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.secondLastName = secondLastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
}
