package com.currencyfair.connector;

/**
 * This class declare options for connectors
 * As of now we have size 1 for file path
 * In case any other connector option is introduced, its option will be added by increasing size of array
 * and declaring a constant to give its index
 * @author Harshit_Bansal
 *
 */
public class ConnectorParams {
	
	public final static int filePath = 0;	
	public final static String[] connectOptions = new String[1]; 
}
