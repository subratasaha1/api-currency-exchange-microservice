package com.system.currencyexchange.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "id", "from", "to", "exchangeRate" })
@Entity
@Data
@Builder
public class CurrencyExchange {

	/*
	 * public CurrencyExchange(String from, String to, BigDecimal exchangeRate, Long
	 * id) { super(); this.from = from; this.to = to; this.exchangeRate =
	 * exchangeRate; this.id = id; }
	 */

	/*
	 * public CurrencyExchange() {
	 * 
	 * }
	 */
	@Column(name = "from_currency")
	private String from;
	@Column(name = "to_currency")
	private String to;
	private BigDecimal exchangeRate;
	private String enviornment;
	@Id
	private Long id;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * @Override public String toString() { return "CurrencyExchange [from=" + from
	 * + ", to=" + to + ", exchangeRate=" + exchangeRate + ", id=" + id + "]"; }
	 */
}
