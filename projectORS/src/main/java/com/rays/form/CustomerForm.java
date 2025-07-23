package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.rays.common.BaseForm;
import com.rays.dto.CustomerDTO;

public class CustomerForm extends BaseForm {

	@NotEmpty(message = "Please enter client name")
	@Size(min = 3, max = 15, message = "Client name must be between 3 and 15 characters")
	@Pattern(regexp = "^[A-Za-z ]+$", message = "Only letters are allowed")
	private String clientName;


	@NotEmpty(message = "Please enter location")
	@Size(min = 3, max = 15, message = "Location must be between 3 and 15 characters")
	@Pattern(regexp = "^[A-Za-z ]+$", message = "Only letters are allowed")
	private String location;

	@NotNull(message = "Please enter contact number")
	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Number must start with 6-9 and be 10 digits")
	private String contactNumber;


	@NotEmpty(message = "please enter importance")
	private String importance;

	
	

	public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getImportance() {
		return importance;
	}

	@Override
	public CustomerDTO getDto() {

		CustomerDTO dto = initDTO(new CustomerDTO());
		dto.setClientName(clientName);
		dto.setLocation(location);
		dto.setContactNumber(contactNumber);
		dto.setImportance(importance);
		return dto;
	}


	public void setImportance(String importance) {
		this.importance = importance;
	}

}