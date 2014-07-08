/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Handler implements HttpHandler
{

    private static final String FILE_PATH = "data/";

    /**
     * This function extracts the file path from the URL. It then opens and
     * returns it as the response. It sends the contents of the and lets the AJAX
     * call or browser determine how to render the content that is returned.
     * @param exchange
     */
    @Override
    public void handle(HttpExchange exchange)
    {
	String requestMethod = exchange.getRequestMethod().toUpperCase();

	if (null != requestMethod && "GET".equals(requestMethod))
	{
	    Path path = Paths.get(FILE_PATH + exchange.getRequestURI().getPath());

	    try (OutputStream responseBody = exchange.getResponseBody())
	    {
		byte[] response = Files.readAllBytes(path);
		exchange.sendResponseHeaders(200, 0);
		responseBody.write(response);
	    }
	    catch (IOException ex)
	    {
		System.err.println("Page Not Found");
	    }
	}
	else
	{
	    try
	    {
		exchange.sendResponseHeaders(404, 0);
	    }
	    catch (IOException ex)
	    {
		System.err.println("Page Not Found");
	    }
	}
    }
}
