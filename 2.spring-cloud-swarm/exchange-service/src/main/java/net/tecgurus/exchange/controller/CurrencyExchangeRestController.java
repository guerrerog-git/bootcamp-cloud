package net.tecgurus.exchange.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.tecgurus.exchange.model.ExchangeValue;
import net.tecgurus.exchange.service.ExchangeValueService;

@RestController
public class CurrencyExchangeRestController {

	@Autowired
	private ExchangeValueService service;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value="/currency-exchange/from/{from}/to/{to}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public ExchangeValue getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) {
		ExchangeValue exchangeValue = service.getExchangeFromTo(from, to);
		if(exchangeValue != null) {
			exchangeValue.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
		}
		
//		Map<String, Object> map = new HashMap();
//        for(Iterator it = ((AbstractEnvironment) environment).getPropertySources().iterator(); it.hasNext(); ) {
//            PropertySource propertySource = (PropertySource) it.next();
//            if (propertySource instanceof MapPropertySource) {
//                map.putAll(((MapPropertySource) propertySource).getSource());
//            }
//        }
//        System.out.println(map);
		return exchangeValue;
	}
}
