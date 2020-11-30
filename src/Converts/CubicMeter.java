/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converts;

/**
 *
 * @author enzoj
 */

public class CubicMeter extends AbstractConverter {

    public CubicMeter() {
        super("Volume", "M3");
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
