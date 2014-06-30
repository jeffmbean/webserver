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
import java.util.logging.Logger;

class Handler implements HttpHandler
{

    @Override
    public void handle(HttpExchange exchange)
    {
	String response = "";
	String requestMethod = exchange.getRequestMethod().toUpperCase();
	
	switch (requestMethod)
	{
	    case "GET":
		
		break;
	    case "POST":
		break;
	}
	
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
}
