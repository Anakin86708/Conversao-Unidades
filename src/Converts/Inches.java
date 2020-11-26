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
public class Inches implements InterfaceConverter{
    
    private final String categoty;

    public Inches() {
        this.categoty = "length";
    }

    @Override
    public String toString() {
        return "Inches (in)";
    }
    
    @Override
    public double toBase(double input) {
        return input * 0.0254;
    }
    
    @Override
    public double convert(double input) {
        return input * 39.37008;
    }
    

    @Override
    public String getCategory() {
        return this.categoty;
    }
    
}
