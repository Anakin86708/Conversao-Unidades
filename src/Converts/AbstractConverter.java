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

    /**
     * Sets a category and a name.
     * @param category Category that will be shown in the GUI and will be use
     * to sort and select compatible units.
     * @param name Name that will be shown in the GUI.
     */
    public AbstractConverter(String category, String name) {
        this.category = Language.getResourceBundle().getString(category);
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
     * Represents the object as a String.
     * @return Unit name associated with the class.
     */
    public String toString() {
        return this.name; 
    }
    
   /**
    * Receives user input and transforms it to the base measure.
    * @param input User's input.
    * @return the input in the base measure.
    */
    abstract public double toBase(double input);
    
    /**
     * It receives a value in the chosen measure bases, and transforms it to 
     * the chosen measure.
     * @param input User's Input
     * @return the converted value for the chosen unit.
     */
    abstract public double convert(double input);
    
}
