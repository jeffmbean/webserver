/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Handler implements HttpHandler
{
	private static final String FILE_PATH = "";
	
    @Override
    public void handle(HttpExchange exchange)
    {
		Path path = Paths.get(FILE_PATH + exchange.getRequestURI().getPath());
		byte[] response;
		
		try
		{
			response = Files.readAllBytes(path);
		}
		catch (IOException ex)
		{
			response = new byte[1];
			System.err.println("Error reading file: "+ path.toString());
		}
		

		Headers responseHeaders = exchange.getResponseHeaders();
		responseHeaders.set("Content-Type", "application/json");

		try (OutputStream responseBody = exchange.getResponseBody())
		{
			exchange.sendResponseHeaders(200, 0);
			responseBody.write(response);
		}
		catch (Exception ex)
		{
			System.err.println("Error writing file: "+ path.toString());
		}
    }
}
