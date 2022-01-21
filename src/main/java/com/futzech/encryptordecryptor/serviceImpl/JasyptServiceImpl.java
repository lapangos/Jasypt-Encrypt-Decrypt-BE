package com.futzech.encryptordecryptor.serviceImpl;

import java.security.Provider;
import java.security.Security;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futzech.encryptordecryptor.config.JasyptConfig;
import com.futzech.encryptordecryptor.request.JasyptRequest;
import com.futzech.encryptordecryptor.service.JasyptService;

@Service
public class JasyptServiceImpl implements JasyptService {

	private static final Logger logger = LoggerFactory.getLogger(JasyptServiceImpl.class);

	@Autowired
	JasyptConfig jasyptConfig;

	public List<String> getAlgorithm() {
		List<String> algorithms = Arrays.stream(Security.getProviders())
				.flatMap(provider -> provider.getServices().stream())
				.filter(service -> "Cipher".equals(service.getType())).map(Provider.Service::getAlgorithm)
				.collect(Collectors.toList());

		logger.info("algorithms - {}", algorithms);

		return algorithms;
	}

	@Override
	public String getEncryptedText(JasyptRequest request) {
		if (request.getAlgorithm().isEmpty()) {
			request.setAlgorithm("PBEWithHmacSHA512AndAES_256");
		}
		SimpleStringPBEConfig config = setConfig(request.getPassword(), request.getAlgorithm());
		config.setKeyObtentionIterations("1000");
		config.setPoolSize("1");
		config.setProviderName("SunJCE");
		config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
		config.setStringOutputType("base64");
		StringEncryptor stringEncryptor = jasyptConfig.stringEncryptor(config);
		String encryptedText = stringEncryptor.encrypt(request.getPlainText());

		logger.info("encryptedText - {}", encryptedText);

		return encryptedText;
	}

	@Override
	public String getDecryptedText(JasyptRequest request) {
		if (request.getAlgorithm().isEmpty()) {
			request.setAlgorithm("PBEWithHmacSHA512AndAES_256");
		}
		SimpleStringPBEConfig config = setConfig(request.getPassword(), request.getAlgorithm());
		config.setKeyObtentionIterations("1000");
		config.setPoolSize("1");
		config.setProviderName("SunJCE");
		config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
		config.setStringOutputType("base64");

		StringEncryptor stringEncryptor = jasyptConfig.stringEncryptor(config);
		String decryptedText = stringEncryptor.decrypt(request.getPlainText());

		logger.info("decryptedText - {}", decryptedText);

		return decryptedText;
	}

	public SimpleStringPBEConfig setConfig(String password, String algorithm) {
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		config.setPassword(password);
		config.setAlgorithm(algorithm);

		return config;
	}
}
