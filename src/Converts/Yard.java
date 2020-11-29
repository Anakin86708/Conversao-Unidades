/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converts;

/**
 *
 * @author Leo
 */
public class Yard extends AbstractConverter {

    public Yard() {
        super("length");
    }

    @Override
    public String toString() {
        return "Yard (yd)";
    }

    @Override
    public double toBase(double input) {
        return input * 0.9144;
    }

    @Override
    public double convert(double input) {
        return input * 1.09361;
    }

}
