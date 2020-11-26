/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converts;

/**
 *
 * @author Guilherme
 */
public class Mil implements InterfaceConverter{
    private final String category;
    
    public Mil() {
        this.category  = "lenght";
    }
    
    @Override
    public String toString() {
        return "Mil (mil)";
    }
    
    @Override
    public String getCategory() {
        return this.category;
    }
    
    @Override
    public double toBase(double input) {
        return input * 0.0000254;
    }
    
    public double convert(double input) {
        return input * 39370;
    }
}
