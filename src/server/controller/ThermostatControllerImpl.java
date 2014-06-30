/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.controller;

import server.model.Device;

/**
 *
 * @author Jeff Bean
 */
public class ThermostatControllerImpl implements DeviceController
{
    private Device ac;
    private Device furnace;
    private Integer temperature;
    
    

    @Override
    public String getValue()
    {
	return temperature.toString();
    }

    @Override
    public boolean update(String property, String value)
    {
	boolean success = false;
	
	switch (property)
	{
	    case "ac":
		success = true;
		break;
	    case "furnace":
		success = true;
		break;
	    case "off":
		success = true;
		break;
	}
	
	return success;
    }
    
}
