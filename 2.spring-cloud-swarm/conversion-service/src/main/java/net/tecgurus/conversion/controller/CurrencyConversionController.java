package net.tecgurus.conversion.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.tecgurus.conversion.dto.CurrencyConversionDTO;
import net.tecgurus.conversion.proxy.ICurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private ICurrencyExchangeServiceProxy proxy;
	
	@GetMapping(value="/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}", produces=MediaType.APPLICATION_JSON_VALUE)
	public CurrencyConversionDTO convert(@PathVariable("from") String from, @PathVariable("to") String to, 
			@PathVariable("quantity") double quantity) {
		
		
		CurrencyConversionDTO response = new CurrencyConversionDTO();
		
		response = proxy.getExchangeValue(from, to);
		
		//Conversion, multiplicar quantity * multiple
		response.setTotal(quantity * response.getConversionMultiple()); 
		
		return response;
	}
}
