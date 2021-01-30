package net.tecgurus.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.tecgurus.exchange.model.ExchangeValue;

public interface IExchangeValueRepository extends JpaRepository<ExchangeValue, Integer>{

	//Consultas declarativas, SELECT * FROM exchange_value WHERE currency_from='USD' and currency_to = 'MXN'
	public ExchangeValue findByFromAndTo(String from, String to); 
}
