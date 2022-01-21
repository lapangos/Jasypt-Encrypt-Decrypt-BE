package com.futzech.encryptordecryptor.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.stereotype.Component;

@Component
public class JasyptConfig {

	public StringEncryptor stringEncryptor(SimpleStringPBEConfig config) {
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		encryptor.setConfig(config);
		return encryptor;
	}

}
