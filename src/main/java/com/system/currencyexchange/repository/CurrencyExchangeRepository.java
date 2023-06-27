package com.system.currencyexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.currencyexchange.model.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{

	public CurrencyExchange findByFromAndTo(String from, String to);
}
