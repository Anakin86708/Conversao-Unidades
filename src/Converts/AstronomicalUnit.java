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
public class AstronomicalUnit extends AbstractConverter{
    
    public AstronomicalUnit(){
        super("length");
    }
    
    @Override
    public String toString() {
        return "Astronomical Unit (au)"; 
    }

    @Override
    public double toBase(double input) {
        return input * 1.496e+11;
    }

    @Override
    public double convert(double input) {
        return input * 6.68459e-12;
    }

}
