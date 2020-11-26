/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converts;

/**
 *
 * @author Leo
 */
public class Parsec implements InterfaceConverter{
    
    private final String category;
    
    public Parsec() 
    {
        this.category = "length";
    }
    
    @Override
    public String toString() {
        return "Parsec (pc)"; 
    }
    
    
    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public double toBase(double input) {
        return input * 3.086e+16;
    }

    @Override
    public double convert(double input) {
        return input * 3.24078e-17;
    }
}
