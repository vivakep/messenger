package com.bsm.rest.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExceptionModel {

	private String message, docURI;
	private int errorNumber;

	public ExceptionModel(String message, String docURI, int errorNumber) {
		super();
		this.message = message;
		this.docURI = docURI == null ? "" : docURI;
		this.errorNumber = errorNumber;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDocURI() {
		return docURI;
	}

	public void setDocURI(String docURI) {
		this.docURI = docURI;
	}

	public int getErrorNumber() {
		return errorNumber;
	}

	public void setErrorNumber(int errorNumber) {
		this.errorNumber = errorNumber;
	}
}
