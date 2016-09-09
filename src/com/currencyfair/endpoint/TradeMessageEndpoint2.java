package com.currencyfair.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import com.currencyfair.requestObjects.TradeMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Path("/endpoint")
@Provider
@Consumes(MediaType.APPLICATION_JSON) // NOTE: required to support "non-standard" JSON variants
@Produces(MediaType.APPLICATION_JSON)
public class TradeMessageEndpoint2 extends JacksonJsonProvider {
//    @Override
//    protected ObjectMapper _locateMapperViaProvider(Class<TradeMessage> type, MediaType mediaType) {
//    	
//        //return new MyCustomObjectMapper();
//    	return null;
//    }
    
}