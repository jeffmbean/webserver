/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.model;

import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author Jeff Bean
 */
public class Device
{
    private String id;
    private String name;
    private int status;

    /**
     * Constructor.
     * @param id
     * @param name
     * @param status 
     */
    public Device(String id, String name, int status)
    {
	this.id = id;
	this.name = name;
	this.status = status;
    }

    public String getId()
    {
	return id;
    }

    public void setId(String id)
    {
	this.id = id;
    }

    public String getName()
    {
	return name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    public int getStatus()
    {
	return status;
    }

    public void setStatus(int status)
    {
	this.status = status;
    }

    public String toJSON()
    {
	StringBuilder json = new StringBuilder("{");
	json.append("\"id\":\"");
	json.append(id);
	json.append("\", \"name\":\"");
	json.append(name);
	json.append("\", \"status\":");
	json.append(status);
	json.append("}");
	return json.toString();
    }
}
