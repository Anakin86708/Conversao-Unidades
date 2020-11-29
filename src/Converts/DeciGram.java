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
public class DeciGram extends AbstractConverter {

    public DeciGram() {
        super("mass");
    }

    @Override
    public String toString() {
        return "Decigram (dg)";
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
