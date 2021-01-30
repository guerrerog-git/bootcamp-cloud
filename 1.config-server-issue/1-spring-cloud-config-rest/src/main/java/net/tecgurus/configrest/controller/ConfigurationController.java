package net.tecgurus.configrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.tecgurus.configrest.dto.ConfigurationDTO;

@RestController
public class ConfigurationController {

	@Autowired
	private ConfigurationDTO configuration;
	
	@GetMapping("/configuration")
	public ConfigurationDTO getConfig() {
		return configuration;
	}
	
}
