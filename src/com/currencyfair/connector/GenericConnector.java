package com.currencyfair.connector;

import java.util.List;

import com.currencyfair.requestObjects.RequestObject;

public interface GenericConnector {

	public void saveObj(RequestObject Obj);
	
	public List<RequestObject> getObj();
}
