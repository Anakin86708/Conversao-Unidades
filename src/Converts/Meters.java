/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converts;

/**
 *
 * @author silva
 */
public class Meters extends AbstractConverter {

    public Meters() {
        super("length");
    }

    @Override
    public String toString() {
        return "Meters (m)";
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
