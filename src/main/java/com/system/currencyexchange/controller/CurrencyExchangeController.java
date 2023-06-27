package com.system.currencyexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.system.currencyexchange.model.CurrencyExchange;
import com.system.currencyexchange.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController{
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	@GetMapping(value="/currencyexchange/from/{from}/to/{to}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CurrencyExchange> getCurrencyExchangeFactor(@PathVariable String from, @PathVariable String to) {
		 CurrencyExchange currencyExchange= currencyExchangeService.getExchangeRate(from,to);
		 return ResponseEntity.ok(currencyExchange);
	}
}
