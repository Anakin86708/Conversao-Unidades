/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converts;

/**
 *
 * @author Guiskater
 */
public class Gram implements InterfaceConverter{
    private final String category;
    
    public Gram() {
        this.category = "mass";
    }
    
    @Override
    public String toString() {
        return "Gram (g)";
    }

    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public double toBase(double input) {
        return input;
    }

    @Override
    public double convert(double input) {
        return input;
    }
}
