/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.controller;

/**
 *
 * @author Jeff_2
 */
public interface DeviceController
{
    public String getValue();
    public boolean update(String property, String value);
}
