/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import server.model.Device;

/**
 *
 * @author Jeff Bean
 */
public class SecurityControllerImpl implements DeviceController
{
    private static final SecurityControllerImpl INSTANCE = new SecurityControllerImpl();
    
    private Map<String,Device> devices;
    private Integer temperature;

    private SecurityControllerImpl()
    {
	this.devices = new HashMap<>();
	this.temperature = 78;
    }
    
    public static SecurityControllerImpl getInstance()
    {
	return INSTANCE;
    }

    @Override
    public String getStatus()
    {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(Map<String,List<String>> parameters)
    {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
