package net.tecgurus.conversion.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.tecgurus.conversion.dto.CurrencyConversionDTO;

//@FeignClient(name="exchange-service", url="localhost:8000")
@FeignClient(name="SPRING-CLOUD-EXCHANGE-REST")
@RibbonClient(name="SPRING-CLOUD-EXCHANGE-REST")
public interface ICurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionDTO getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
