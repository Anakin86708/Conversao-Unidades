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
public class League extends AbstractConverter {

    public League() {
        super("Length", "Land");
    }

    @Override
    public double toBase(double input) {
        return input * 4828.03;
    }

    @Override
    public double convert(double input) {
        return input * 0.000207124;
    }
}
