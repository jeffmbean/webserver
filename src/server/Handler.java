/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import server.controller.DeviceController;
import server.controller.LightingControllerImpl;
import server.controller.NullDeviceControllerImpl;
import server.controller.SecurityControllerImpl;
import server.controller.ThermostatControllerImpl;

class Handler implements HttpHandler
{
    @Override
    public void handle(HttpExchange exchange)
    {
	String response = "";
	String requestMethod = exchange.getRequestMethod().toUpperCase();
		
	if ("GET".equals(requestMethod))
	{
	    String path = exchange.getRequestURI().getPath();
	    DeviceController controller = getController(path);
	    response = controller.getStatus();
	
	    Headers responseHeaders = exchange.getResponseHeaders();
	    responseHeaders.set("Content-Type", "application/json");

	    try (OutputStream responseBody = exchange.getResponseBody())
	    {
		exchange.sendResponseHeaders(200, 0);
		responseBody.write(response.getBytes());
	    }
	    catch (Exception ex)
	    {
		Logger.getLogger("Server").info(ex.getMessage());
	    }
	}
	else
	{
	    try (OutputStream responseBody = exchange.getResponseBody())
	    {
		exchange.sendResponseHeaders(404, 0);
		responseBody.write(response.getBytes());
	    }
	    catch (Exception ex)
	    {
		Logger.getLogger("Server").info(ex.getMessage());
	    }
	}
    }
    
    /**
     * 
     * @param path
     * @return 
     */
    private DeviceController getController(String path)
    {
	DeviceController controller = new NullDeviceControllerImpl();
	
	if (path.matches("/lighting.*"))
	{
	    controller = LightingControllerImpl.getInstance();
	}
	else if (path.matches("/thermostat.*"))
	{
	    controller = ThermostatControllerImpl.getInstance();
	}
	else if (path.matches("/security.*"))
	{
	    controller = SecurityControllerImpl.getInstance();
	}
	
	return controller;
    }
    
    /**
     * 
     * @param params
     * @return 
     */
    private Map<String,List<String>> extractParameters(String params)
    {
	Map<String,List<String>> parameters = new HashMap<>();
	String[] pairs = params.split("&");
	
	for (String pair : pairs)
	{
	    String[] keyValue = pair.split("=");
	    String key = "";
	    String value = "";
	    
	    if (keyValue.length > 1)
	    {
		key = keyValue[0];
		value = keyValue[1];
	    }
	    else if (keyValue.length == 1)
	    {
		key = keyValue[0];
	    }
	    
	    List<String> values = new ArrayList<>();
	    
	    if (parameters.containsKey(key))
	    {
		values = parameters.get(key);
	    }
	    
	    values.add(value);
	    parameters.put(key, values);
	}	
	
	return parameters;
    }
}
