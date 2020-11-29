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
public class Parsec extends AbstractConverter{

    public Parsec() 
    {
        super("Length", "PC");
    }
    
    @Override
    public double toBase(double input) {
        return input * 3.086e+16;
    }

    @Override
    public double convert(double input) {
        return input * 3.24078e-17;
    }
}
