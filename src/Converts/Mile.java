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
public class Mile implements InterfaceConverter {
    private final String category;
    
    public Mile(){
        this.category = "length";
    }
    
    @Override
    public String toString() {
        return "Mile (mi)";
    }
    
    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public double toBase(double input) {
        return input * 1609.34;
    }

    @Override
    public double convert(double input) {
        return input * 0.000621371;
    }
    
}
