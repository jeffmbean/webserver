/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.controller;

import java.util.*;
import server.model.Device;
import server.service.ThermostatService;

/**
 *
 * @author Jeff Bean
 */
public class ThermostatControllerImpl implements DeviceController
{  
    private static final ThermostatControllerImpl INSTANCE = new ThermostatControllerImpl();
    
    private ThermostatService service;
    

    private ThermostatControllerImpl()
    {
	this.service = new ThermostatService();
    }
    
    public static ThermostatControllerImpl getInstance()
    {
	return INSTANCE;
    }

    @Override
    public String getStatus()
    {
	return service.getStatus();
    }

    @Override
    public String update(Map<String,List<String>> parameters)
    {
	String json = "{\"success\":\"false\"}";
	String action = "";
	
	if (parameters.containsKey("action"))
	{
	    action = parameters.get("action").get(0);
	}
	
	switch (action)
	{
	    case "turnOn":
		break;
	    case "turnOff":
		break;
	    case "increaseTemp":
		break;
	    case "decreaseTemp":
		break;
	}
	
	return json;
    }
    
}
