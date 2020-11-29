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

/**
 * Responsible for making the necessary interface for the conversion.
 * @author Leo
 */
public interface InterfaceConverter {

    /**
     * Measure Category
     * @return Measure Category
     */
    String getCategory();
    
   /**
    * Receives user input and transforms it to the base measure (m)
    * @param input User's input
    * @return the input in meters
    */
    
    public double toBase(double input);
    
    /**
     * It receives a value in meters, and transforms it to the chosen measure.
     * @param input User's Input
     * @return the converted value for the chosen unit.
     */
    
    public double convert(double input);
    
}
