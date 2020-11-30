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
public class Gram extends AbstractConverter {

    public Gram() {
        super("Mass", "G");
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
