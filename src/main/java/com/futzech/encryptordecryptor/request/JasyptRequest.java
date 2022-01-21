package com.futzech.encryptordecryptor.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class JasyptRequest {

	private String plainText;
	private String password;
	private String algorithm;
			
	public JasyptRequest(String plainText, String password, String algorithm) {
		super();
		this.plainText = plainText;
		this.password = password;
		this.algorithm = algorithm;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	public String getPlainText() {
		return plainText;
	}

	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}

	@Override
	public String toString() {
		return "JasyptRequest [plainText=" + plainText + ", password=" + password + ", algorithm=" + algorithm + "]";
	}

}
