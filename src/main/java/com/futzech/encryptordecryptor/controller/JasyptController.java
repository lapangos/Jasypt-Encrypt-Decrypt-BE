package com.futzech.encryptordecryptor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.futzech.encryptordecryptor.request.JasyptRequest;
import com.futzech.encryptordecryptor.response.JasyptResponse;
import com.futzech.encryptordecryptor.serviceImpl.JasyptServiceImpl;

@RestController
@CrossOrigin("*")
public class JasyptController {

	@Autowired
	JasyptServiceImpl jasyptServiceImpl;

	private static final Logger logger = LoggerFactory.getLogger(JasyptController.class);

	@GetMapping("/getAlgorithm")
	public JasyptResponse getAlgorithm() {
		logger.info("Started: JasyptController.getAlgorithm() - ");
		List<String> algorithms = jasyptServiceImpl.getAlgorithm();
		JasyptResponse response = new JasyptResponse();
		response.setAlgorithm(algorithms);
		logger.info("Ended: JasyptController.getAlgorithm() - ");
		return response;
	}

	@PostMapping("/getEncryptedText")
	public JasyptResponse getEncryptedText(@RequestBody JasyptRequest request) {
		logger.info("Started: JasyptController.getEncryptedText() - ");
		String encryptedText = jasyptServiceImpl.getEncryptedText(request);
		logger.info("Ended: JasyptController.getEncryptedText() - ");
		JasyptResponse response = new JasyptResponse();
		response.setEncryptedString(encryptedText);
		return response;
	}

	@PostMapping("/getDecryptedText")
	public JasyptResponse getDecryptedText(@RequestBody JasyptRequest request) {
		logger.info("Started: JasyptController.getDecryptedText() - ");
		String decryptedText = jasyptServiceImpl.getDecryptedText(request);
		logger.info("Ended: JasyptController.getDecryptedText() - ");
		JasyptResponse response = new JasyptResponse();
		response.setDecryptedString(decryptedText);
		return response;
	}
}
