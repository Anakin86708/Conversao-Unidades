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
public class CubicHectometer extends AbstractConverter {

    public CubicHectometer() {
        super("Volume", "HM3");
    }

    @Override
    public double toBase(double input) {
        return input * 1E+9; 
    }

    @Override
    public double convert(double input) {
        return input * 1E-9; 
    }
}
