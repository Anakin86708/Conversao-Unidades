/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converts;

/**
 * Responsible for creating the Mil Unit Class 
 * implementing the InterfaceConverter.
 * @author Guilherme
 */
public class ThousandthOfAnInch extends AbstractConverter {

    public ThousandthOfAnInch() {
        super("Length", "Mil");
    }

    @Override
    public double toBase(double input) {
        return input * 0.0000254;
    }
    
    @Override
    public double convert(double input) {
        return input * 39370;
    }
}
