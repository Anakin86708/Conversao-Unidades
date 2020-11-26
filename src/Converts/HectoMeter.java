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
public class HectoMeter implements InterfaceConverter {
    private final String category;
    
    public HectoMeter() {
        this.category = "lenght";
    }
    
    @Override
    public String toString() {
        return "Hectometers (hm)";
    }

    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public double toBase(double input) {
        return input * 100;
    }

    @Override
    public double convert(double input) {
        return input * 0.01;
    }
}
