package com.system.currencyexchange.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.system.currencyexchange.model.CurrencyExchange;
import com.system.currencyexchange.repository.CurrencyExchangeRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CurrencyExchangeServiceTest {
	
	private CurrencyExchange expectedCurrencyExchange;
	
	@BeforeEach
	public void setup() {
		expectedCurrencyExchange = CurrencyExchange.builder().id(1000L).to("INR").from("GBP").exchangeRate(new BigDecimal("100.0")).build();
	}

	@MockBean
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	@Test
	public void getExchangeRateTest() {
		Mockito.when(currencyExchangeRepository.findByFromAndTo("GBP", "INR")).thenReturn(expectedCurrencyExchange);
		CurrencyExchange actualCurrencyExchange = currencyExchangeService.getExchangeRate("GBP", "INR");
		assertEquals(expectedCurrencyExchange, actualCurrencyExchange);
	}
}
