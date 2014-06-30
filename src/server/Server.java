/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import com.sun.net.httpserver.HttpServer;

public class Server
{
    private static final int PORT = 8080;
    private static final String HOSTNAME = "127.0.0.1";
    private static final int NUM_OF_THREADS = 10;
    
    /**
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException
    {
	InetSocketAddress socket = new InetSocketAddress(HOSTNAME, PORT);
	HttpServer server = HttpServer.create(socket, 0);
	server.setExecutor(Executors.newFixedThreadPool(NUM_OF_THREADS));
	server.createContext("/", new Handler());
	server.start();
    }
}
