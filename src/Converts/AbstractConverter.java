/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converts;

import Codes.Language;

/**
 *
 * @author silva
 */

/**
 * Responsible for making the necessary interface for the conversion.
 * @author Leo
 */
public abstract class AbstractConverter {
    
    private final String category;
    private final String name;

    public AbstractConverter(String category, String name) {
        this.category = Language.getResourceBundle().getString(category);;
        this.name = Language.getResourceBundle().getString(name);
    }
    
    /**
     * Measure Category
     * @return Measure Category
     */
    public String getCategory() {
        return this.category;
    }
    
    /**
     * Representa o objeto como String
     * @return Nome da unidade associada a classe
     */
    public String toString() {
        return this.name; 
    }
    
   /**
    * Receives user input and transforms it to the base measure (m)
    * @param input User's input
    * @return the input in meters
    */
    
    abstract public double toBase(double input);
    
    /**
     * It receives a value in meters, and transforms it to the chosen measure.
     * @param input User's Input
     * @return the converted value for the chosen unit.
     */
    
    abstract public double convert(double input);
    
}
