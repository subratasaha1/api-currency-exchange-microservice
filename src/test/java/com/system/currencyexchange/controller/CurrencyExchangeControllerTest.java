package com.system.currencyexchange.controller;

import static  org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.system.currencyexchange.service.CurrencyExchangeService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CurrencyExchangeControllerTest{
	
	private MockMvc mvc;
	
	@Autowired
	private CurrencyExchangeController currencyExchangeController;
	
	@MockBean
	private CurrencyExchangeService currencyExchangeService;
	
	private MockHttpServletRequestBuilder getRequestMock(MockHttpServletRequestBuilder builder)
	{		
		return builder.accept(MediaType.APPLICATION_JSON);
	}

	@BeforeEach
	void setup() 
	{
		mvc = MockMvcBuilders.standaloneSetup(currencyExchangeController).build();
	}
	@Test
	public void getCurrencyExchangeFactorTest() throws Exception {
		mvc.perform(getRequestMock(MockMvcRequestBuilders.get("/currencyexchange/from/GBP/to/INR"))).andDo(print()).andExpect(status().isOk());
	}
}
