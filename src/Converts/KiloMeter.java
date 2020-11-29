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
public class KiloMeter extends AbstractConverter {
    
    public KiloMeter() {
        super("length");
    }
    
    @Override
    public String toString() {
        return "Kilometer (km)";
    }
    
    @Override
    public double toBase(double input) {
        return input * 1000;
    }
    
    public double convert(double input) {
        return input * 0.001;
    }
}
