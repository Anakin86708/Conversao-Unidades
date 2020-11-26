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
public class DeciMeter implements InterfaceConverter {
    private final String category;
    
    public DeciMeter() {
        this.category = "length";
    }
    
    @Override
    public String toString() {
        return "Decimeters (dm)";
    }

    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public double toBase(double input) {
        return input * 0.1;
    }

    @Override
    public double convert(double input) {
        return input * 10;
    }
}
