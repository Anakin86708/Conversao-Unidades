/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converts;

/**
 * Responsible for creating the League Unit Class 
 * implementing the InterfaceConverter.
 * @author Leo
 */
public class League implements InterfaceConverter{
    private final String category;
    
    /**
     * Put this unit in the category: length.
     */
    public League(){
        this.category = "length";
    }

    /**
     * Responsable to show the option the user, 
     * @return the message inside the Combo Box Model. 
     */
    @Override
    public String toString() {
        return "League (land)";  /* NAO TENHO CTZ DO SHORT, N SEI SE É LAND */
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
        return input * 4828.03;
    }

    /**
     * Responsable for tranformation for this Unit with 
     * @param input User's Input 
     * @return the result of the input multiplied the constant.
     */
    @Override
    public double convert(double input) {
        return input * 0.000207124 ;
    }
}
