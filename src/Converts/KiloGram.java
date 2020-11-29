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
public class KiloGram extends AbstractConverter {

    public KiloGram() {
        super("mass");
    }

    @Override
    public String toString() {
        return "Kilogram (kg)";
    }

    @Override
    public double toBase(double input) {
        return input * 1000;
    }

    @Override
    public double convert(double input) {
        return input * 0.001;
    }
}
