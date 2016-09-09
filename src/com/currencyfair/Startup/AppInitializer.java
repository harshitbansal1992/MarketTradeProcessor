package com.currencyfair.Startup;

import java.io.IOException;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class AppInitializer
 */
@WebServlet("/AppInitializer")
public class AppInitializer extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
	  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppInitializer() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	public Map getBannedCountries(){
		//bannedCountries = ResourceBundl
		return null;
	}
}
