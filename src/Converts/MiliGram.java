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
public class MiliGram extends AbstractConverter {

    public MiliGram() {
        super("mass");
    }

    @Override
    public String toString() {
        return "Miligram (mg)";
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
