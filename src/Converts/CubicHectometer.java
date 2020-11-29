/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converts;

/**
 * Responsible for creating the Cubic Hectometer Unit Class 
 * implementing the InterfaceConverter. 
 * @author enzoj
 */
public class CubicHectometer implements InterfaceConverter{
    private final String category;
    /**
     * Put this unit in the category: volume.
     */
    public CubicHectometer() {
        this.category = "volume";
    }
    /**
     * Responsable to show the option the user, 
     * @return the message inside the Combo Box Model. 
     */
    @Override
    public String toString() {
        return "Cubic Hectometer (hm3)";
    }
    
    /**
     * Responsable to show the option the user
     * @return the category. 
     */
    @Override
    public String getCategory() {
        return this.category;
    }

    /**
     * Responsable for transformation this Unit for the Base Unit (Meters).
     * @param input User's input. 
     * @return the result of the input multiplied the constant.
     */
    @Override
    public double toBase(double input) {
        return input *1E+9; 
    }
    /**
     * Responsable for tranformation for this Unit with 
     * @param input User's Input 
     * @return the result of the input multiplied the constant.
     */
    @Override
    public double convert(double input) {
       return input * 1E-9; 
    }
}


