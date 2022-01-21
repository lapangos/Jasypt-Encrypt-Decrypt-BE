package com.futzech.encryptordecryptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@CrossOrigin("*")
public class WebMainController {

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
}
