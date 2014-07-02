/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.service;

import server.model.Device;

/**
 *
 * @author Jeff Bean
 */
public class ThermostatService
{
    private Device ac;
    private Device heat;
    private Integer temperature;
    
    public ThermostatService()
    {
	this.ac = new Device("T1", "cool", 0);
	this.heat = new Device("T2", "heat", 0);
	this.temperature = 78;
    }
    
    public String getStatus()
    {
	StringBuilder json = new StringBuilder("{");
	json.append("\"devices\": [");
	json.append(ac.toJSON());
	json.append(",");
	json.append(heat.toJSON());
	json.append("],");
	json.append("\"temperature\":");
	json.append(temperature);
	json.append("}");
	return json.toString();
    }
    
    public boolean updateStatus(String id, int status)
    {
	boolean success = false;
	
	if (id.equals(ac.getId()))
	{
	    ac.setStatus(status);
	    success = true;
	}
	else if (id.equals(heat.getId()))
	{
	    heat.setStatus(status);
	    success = true;
	}
	
	return success;
    }
    
   
}
