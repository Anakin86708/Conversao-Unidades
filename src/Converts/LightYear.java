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
public class LightYear implements InterfaceConverter{
    
    private final String category;
    
    public LightYear(){
        this.category = "length";
    }

    @Override
    public String toString() {
        return "Light Year (ly)"; 
    }
    
    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public double toBase(double input) {
        return input * 9.461e+15;
    }

    @Override
    public double convert(double input) {
        return input * 1.057e-16;
    }
}
