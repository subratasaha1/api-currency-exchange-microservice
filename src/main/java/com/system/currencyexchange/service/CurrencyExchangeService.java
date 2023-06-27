package com.system.currencyexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.currencyexchange.model.CurrencyExchange;
import com.system.currencyexchange.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService{
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	public CurrencyExchange getExchangeRate(String from, String to) {
		return this.currencyExchangeRepository.findByFromAndTo(from, to);
	}
}
