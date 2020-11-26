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
public class DecaGram implements InterfaceConverter{
    private final String category;
    
    public DecaGram() {
        this.category = "mass";
    }
    
    @Override
    public String toString() {
        return "Decagram (dag)";
    }

    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public double toBase(double input) {
        return input * 10;
    }

    @Override
    public double convert(double input) {
        return input * 0.1;
    }
}
