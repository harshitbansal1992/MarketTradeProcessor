package com.currencyfair.consumers;

import java.util.ArrayList;
import java.util.List;

import com.currencyfair.connector.GenericConnector;
import com.currencyfair.requestObjects.RequestObject;
import com.currencyfair.requestObjects.TradeMessage;
import com.currencyfair.utility.Constants;
/**
 * End point for a request calls this Consumer which has property connectorType 
 * to determine which way you want to save the message
 * 
 * Based on the value of this property, it loads the corresponding connector class and saves the message
 * @author Harshit_Bansal
 *
 */
public class TradeMessageConsumer implements Consumer {

	String connectorType = Constants.FILE_CONNECTOR;  
	static List l = new ArrayList();
	String base_package = "com.currencyfair.connector.";
	static{
		
		l.add("IQ");
		l.add("TR");
		
	}
	 
	
	@Override
	public boolean consume(RequestObject obj) {
		// TODO Auto-generated method stub
		boolean consumed = false;
		TradeMessage messageObj = (TradeMessage)obj;		
		if(!l.contains(messageObj.getOriginatingCountry())){
			try {
				//GenericConnector connect = (GenericConnector)Class.forName(connectorType);
				GenericConnector newObject = (GenericConnector)Class.forName(base_package+connectorType).newInstance();
				newObject.saveObj(obj);
				consumed = true;
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return consumed;
	}
}