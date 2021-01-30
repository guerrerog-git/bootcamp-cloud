package net.tecgurus.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.tecgurus.exchange.model.ExchangeValue;
import net.tecgurus.exchange.repository.IExchangeValueRepository;

@Service
public class ExchangeValueService {

	@Autowired
	private IExchangeValueRepository exchangeRepository;

	@Transactional(readOnly = true)
	public ExchangeValue getExchangeFromTo(String from, String to) {
		return exchangeRepository.findByFromAndTo(from, to);
	}
}
