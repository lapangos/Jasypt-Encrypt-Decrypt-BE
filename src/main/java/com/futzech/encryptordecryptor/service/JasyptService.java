package com.futzech.encryptordecryptor.service;

import java.util.List;

import com.futzech.encryptordecryptor.request.JasyptRequest;

public interface JasyptService {

	public List<String> getAlgorithm();

	public String getEncryptedText(JasyptRequest request);

	public String getDecryptedText(JasyptRequest request);
}
