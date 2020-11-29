/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converts;

/**
 * Responsible for creating the Deca Gram Unit Class 
 * implementing the InterfaceConverter. 
 * @author Guiskater
 */
public class DecaGram implements InterfaceConverter{
    private final String category;
    
    /**
     * Put this unit in the category: mass.
     */
    public DecaGram() {
        this.category = "mass";
    }
    
    /**
     * Responsable to show the option the user, 
     * @return the message inside the Combo Box Model.
     */
    @Override
    public String toString() {
        return "Decagram (dag)";
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
        return input * 10;
    }

    /**
     * Responsable for tranformation for this Unit with 
     * @param input User's Input 
     * @return the result of the input multiplied the constant.
     */
    @Override
    public double convert(double input) {
        return input * 0.1;
    }
}
