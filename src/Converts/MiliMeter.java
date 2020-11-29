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
public class MiliMeter extends AbstractConverter {

    public MiliMeter() {
        super("length");
    }

    @Override
    public String toString() {
        return "Milimeters (mm)";
    }

    @Override
    public double toBase(double input) {
        return input * 0.001;
    }

    @Override
    public double convert(double input) {
        return input * 1000;
    }
}
