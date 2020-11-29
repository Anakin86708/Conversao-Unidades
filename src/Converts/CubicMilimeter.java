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
public class CubicMilimeter extends AbstractConverter {

    public CubicMilimeter() {
        super("volume");
    }

    @Override
    public String toString() {
        return "Cubic Milimeter (mm3)";
    }

    @Override
    public double toBase(double input) {
        return input * 1E-6; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double convert(double input) {
        return input * 1E+6; //To change body of generated methods, choose Tools | Templates.
    }

}
