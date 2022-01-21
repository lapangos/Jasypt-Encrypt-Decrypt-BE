package com.futzech.encryptordecryptor.response;

import java.util.List;

public class JasyptResponse {

	private List<String> algorithm;
	private String encryptedString;
	private String decryptedString;

	public JasyptResponse() {}
			
	public JasyptResponse(List<String> algorithm, String encryptedString, String decryptedString) {
		super();
		this.algorithm = algorithm;
		this.encryptedString = encryptedString;
		this.decryptedString = decryptedString;
	}

	public List<String> getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(List<String> algorithm) {
		this.algorithm = algorithm;
	}

	public String getEncryptedString() {
		return encryptedString;
	}

	public void setEncryptedString(String encryptedString) {
		this.encryptedString = encryptedString;
	}

	public String getDecryptedString() {
		return decryptedString;
	}

	public void setDecryptedString(String decryptedString) {
		this.decryptedString = decryptedString;
	}

	@Override
	public String toString() {
		return "JasyptResponse [algorithm=" + algorithm + ", encryptedString=" + encryptedString + ", decryptedString="
				+ decryptedString + "]";
	}

}
