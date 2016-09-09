package com.currencyfair.endpoint;

import java.io.IOException;
import java.util.StringTokenizer;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.currencyfair.Validator.Validator;
import com.currencyfair.consumers.TradeMessageConsumer;
import com.currencyfair.requestObjects.TradeMessage;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/endpoint")
public class TradeMessageEndpoint {
	
	ObjectMapper mapper = new ObjectMapper();
	
	 @POST	
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Path("/tradeMessage")	 
	 public String consume(String json) throws JsonParseException, JsonMappingException, IOException{
		 
		TradeMessage tradeMessage = mapper.readValue(json, TradeMessage.class);		 
		String response = "Not Consumed"; 
		//TradeMessage tradeMessage = parseMessage(json);
		if(tradeMessage!=null){
			
			//checking validity for the values			
			if(Validator.validateString(tradeMessage.getCurrencyFrom()) && 
					Validator.validateString(tradeMessage.getCurrencyTo()) &&
					Validator.validateString(tradeMessage.getCurrencyFrom()) &&
					Validator.validateString(tradeMessage.getOriginatingCountry()) &&
					Validator.validateFloatPositve(tradeMessage.getAmountBuy()) &&
					Validator.validateFloatPositve(tradeMessage.getAmountSell()) &&
					Validator.validateFloatPositve(tradeMessage.getRate()) &&
					Validator.validateString(tradeMessage.getTimePlaced())
						){
					TradeMessageConsumer consumer = new TradeMessageConsumer();
					boolean consumed = consumer.consume(tradeMessage);
					
					if(consumed){
						response = "Consumed Successfully";
					}	
				}else{
					response = "Inappropriate Data";
				}
		}else{
			response = "Inappropriate Data";
		}		
		
		return response;
	 }
	 
	 
	 public TradeMessage parseMessage(String json){
		 TradeMessage message = null;
		 try{

			 boolean valid = true;
			 json = json.replace("\"", "");
			 json = json.replace("{", "");
			 json = json.replace("}", "").trim();
			//initializing variables outside the loop
			 String token = "";
			 String oeKey = "";
			 StringTokenizer jsonElements = new StringTokenizer(json, ",");
				if(jsonElements.countTokens() == 8){
					//since all fields are mandatory.... hardcoding here
					//ideally will use framework like jackson or some other 
					message = new TradeMessage();
					while(jsonElements.hasMoreTokens() && valid ){
						token = jsonElements.nextToken().trim();
						StringTokenizer keyValue = new StringTokenizer(token, ":");
						int count = keyValue.countTokens();
						if(count ==2 ||  token.startsWith("timePlaced")){
							oeKey = keyValue.nextToken().trim();
							
							switch(oeKey){
								case "userId":{
									message.setUserId(Integer.parseInt(keyValue.nextToken().trim()));
									break;	
								}
								case "currencyFrom":{
									message.setCurrencyFrom(keyValue.nextToken().trim());
									break;	
								}
								case "currencyTo":{
									message.setCurrencyTo(keyValue.nextToken().trim());
									break;	
								}
								case "amountSell":{
									message.setAmountSell(Float.parseFloat(keyValue.nextToken().trim()));
									break;	
								}
								case "amountBuy":{
									message.setAmountBuy(Float.parseFloat(keyValue.nextToken().trim()));
									break;	
								}
								case "rate":{
									message.setRate(Float.parseFloat(keyValue.nextToken().trim()));
									break;	
								}
								case "timePlaced":{
									message.setTimePlaced(keyValue.nextToken().trim());
									break;	
								}							
								case "originatingCountry":{
									message.setOriginatingCountry(keyValue.nextToken().trim());
									break;	
								}
								default:
									valid = false;
									break;
							}											
						}else{
							valid = false;
							break;
						}
					}			
				}else{
					valid = false;
				}
			if(!valid){
				message = null;
			}

		 }catch(Exception e){
			 System.out.println(e);
			 message = null;
		 }
		return message;
	 }	 		
}