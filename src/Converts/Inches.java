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
public class Inches extends AbstractConverter {

    public Inches() {
        super("Length", "IN");
    }

    @Override
    public double toBase(double input) {
        return input * 0.0254;
    }

    @Override
    public double convert(double input) {
        return input * 39.37008;
    }
}
