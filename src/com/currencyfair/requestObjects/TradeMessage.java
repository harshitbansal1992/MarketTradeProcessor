package com.currencyfair.requestObjects;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author Harshit_Bansal
 *
 */

public class TradeMessage implements RequestObject{
	
	private int userId;
	private String currencyFrom;
	private String currencyTo;
	private float amountSell;
	private float amountBuy;
	private float rate;
	private String timePlaced;
	private String originatingCountry;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCurrencyFrom() {
		return currencyFrom;
	}
	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}
	public String getCurrencyTo() {
		return currencyTo;
	}
	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}
	public float getAmountSell() {
		return amountSell;
	}
	public void setAmountSell(float amountSell) {
		this.amountSell = amountSell;
	}
	public float getAmountBuy() {
		return amountBuy;
	}
	public void setAmountBuy(float amountBuy) {
		this.amountBuy = amountBuy;
	}
	public float getRate() {
		return rate;		
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public String getTimePlaced() {
		return timePlaced;
	}
	public void setTimePlaced(String timePlaced) {
		this.timePlaced = timePlaced;
	}
	public String getOriginatingCountry() {
		return originatingCountry;
	}
	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}	
}