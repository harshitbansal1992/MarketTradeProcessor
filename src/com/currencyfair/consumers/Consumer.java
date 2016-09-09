package com.currencyfair.consumers;

import com.currencyfair.requestObjects.RequestObject;
/**
 * 
 * @author Harshit_Bansal
 *
 */

public interface Consumer {
	/**
	 * 
	 * @param obj
	 * @return boolean true if message is consumed successfully
	 */
	public boolean consume(RequestObject obj);

}