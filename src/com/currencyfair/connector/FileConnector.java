package com.currencyfair.connector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.currencyfair.Validator.Validator;
import com.currencyfair.requestObjects.RequestObject;
import com.currencyfair.requestObjects.TradeMessage;
import com.currencyfair.utility.Constants;

public class FileConnector implements GenericConnector{
		
	private static final long serialVersionUID = 5153999142034970322L;	
	
	FileOutputStream fos = null;
	FileInputStream fis = null;
	BufferedReader br = null ;
	//these parameters to come from Connector Params
	//String path = "C:\\Users\\harshit_bansal\\Desktop\\Eclipse Workspace\\MarketTradeProcessor\\data.csv";
	String path = "file.csv";
	/*
	static Map objectProperties;
		
	Thought of making it a generic API 

	initialising all the properties of the objects here 
	we can also make an xml/json for each class defining all the properties of a class 
	as the applications grows big
	
	static{
		objectProperties = new HashMap<String, List>();
		List tradeMessage = new ArrayList<String>();
		tradeMessage.add("userId");
		tradeMessage.add("currencyFrom");
		tradeMessage.add("currencyTo");
		tradeMessage.add("amountSell");
		tradeMessage.add("amountBuy");
		tradeMessage.add("rate");
		tradeMessage.add("timePlaced");
		tradeMessage.add("originatingCountry");		
		objectProperties.put("TradeMessage", tradeMessage);
	}
	*/
	public FileConnector() {
		// TODO Auto-generated constructor stub
		init();		
	}	
	
	public void init(){
		try {			
			fos = new FileOutputStream(new File(path),true) ;
			//out = new ObjectOutputStream(fileOut);
			fis = new FileInputStream(path);			 
			br = new BufferedReader(new InputStreamReader(fis));
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void executeRequest(Object obj) {
		// TODO Auto-generated method stub
	
	}
	/**
	 * Actually wanted to make it generic as i initialized 
		properties of the class above but time did not permit
		
		So just making it working only for TradeMessage
		I hope you get the approach what i was looking for. 
	
		or otherwise we could have a separate class for each request Type Object
		
	 */
	@Override
	public void saveObj(RequestObject obj){
		// TODO Auto-generated method stub
 		TradeMessage message = (TradeMessage)obj;
 		
		try
        {
        	//Using StringBuffer instead of String
                StringBuffer oneLine = new StringBuffer();
            //instead of calling a method twice took it into a variable
                int userId = message.getUserId();
                oneLine.append( userId <=0 ? "" : userId);
                oneLine.append(Constants.CSV_SEPARATOR);
                
                String country = message.getOriginatingCountry();               
                oneLine.append(!Validator.validateString(country)? "" : country);
                oneLine.append(Constants.CSV_SEPARATOR);
                
                String currencyFrom= message.getCurrencyFrom();               
                oneLine.append(!Validator.validateString(currencyFrom)? "" : currencyFrom);
                oneLine.append(Constants.CSV_SEPARATOR);
                
                String currencyTo= message.getCurrencyTo();               
                oneLine.append(!Validator.validateString(currencyTo)? "" : currencyTo);
                oneLine.append(Constants.CSV_SEPARATOR);
                
                float amountSell= message.getAmountSell();               
                oneLine.append(amountSell);
                oneLine.append(Constants.CSV_SEPARATOR);
                
                float amountBuy= message.getAmountBuy();               
                oneLine.append(amountBuy);
                oneLine.append(Constants.CSV_SEPARATOR);
                
                float rate = message.getRate();               
                oneLine.append(rate);
                oneLine.append(Constants.CSV_SEPARATOR);
                
                String time = message.getTimePlaced();               
                oneLine.append(!Validator.validateString(time)? "" : time);
                oneLine.append("\n");
                
                //System.out.println(oneLine.toString());
                fos.write(oneLine.toString().getBytes());
                
                fos.flush();
    	        fos.close();                  
            
        }
		//handling specific exceptions
        catch (UnsupportedEncodingException e) {
        	e.printStackTrace();        	
        }
        catch (FileNotFoundException e){
        	e.printStackTrace();
        }
        catch (IOException e){
        	e.printStackTrace();        
        }finally{        
        	
            try {
                if(fos != null)
                    fos.close();
            } catch (IOException e) {
           
            	e.printStackTrace();
            }
        }
	}
/*	
	public void saveObj(RequestObject obj, List properties) {
		// TODO Auto-generated method stub
		try
	      {	                  
	         out.writeObject(obj);
	         out.close();
	         fileOut.close();
	
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
*/	
	@Override
	public List<RequestObject> getObj() {
		// TODO =Auto-generated method stub
		ArrayList<RequestObject> messages = new ArrayList();
		TradeMessage message ;
		try {			
			String line;	
			//Read File Line By Line
			while ((line = br.readLine()) != null)   {			  
			  //System.out.println (strLine);				
				message = (TradeMessage)mapCsvToObj(line);
				messages.add(message);				
			}
		}catch(FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{		
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Close the input stream
		System.out.println(messages.size());
		
		return messages;
	}	
	public static void main(String[] args) {
		FileConnector c = new FileConnector();
		c.getObj();
	}
	
	public RequestObject mapCsvToObj(String line){
		TradeMessage message = null;
		String properties[] = null;
		
		if(line!=null){//checking to make the code non-breakable
			properties = line.split(Constants.CSV_SEPARATOR);
			//StringTokenizer token = new StringTokenizer(line,Constants.CSV_SEPARATOR); 
						
		}
			if(properties!=null){
				message = new TradeMessage();
				message.setUserId(Integer.parseInt(properties[0]));
				message.setOriginatingCountry(properties[1]);
				message.setCurrencyFrom(properties[2]);
				message.setCurrencyTo(properties[3]);
				message.setAmountSell(Float.parseFloat(properties[4]));
				message.setAmountBuy(Float.parseFloat(properties[5]));
				message.setRate(Float.parseFloat(properties[6]));
				message.setTimePlaced(properties[7]);
				
				//In the generic API, order of the properties would be same as in csv on disk and in the xml/json file in the application
			}		
		return message;
	}
}