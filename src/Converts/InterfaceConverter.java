/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converts;

/**
 *
 * @author silva
 */
public interface InterfaceConverter {

    String getCategory();
    
    public double toBase(double input);
    
    public double convert(double input);
    
}
