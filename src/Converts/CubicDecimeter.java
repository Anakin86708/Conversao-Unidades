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
public class CubicDecimeter implements InterfaceConverter{
    private final String category;

    public CubicDecimeter() {
        this.category = "volume";
    }
    
    @Override
    public String toString() {
        return "Cubic Decimeter (dm3)";
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public double toBase(double input) {
        return input *1; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double convert(double input) {
       return input * 1; //To change body of generated methods, choose Tools | Templates.
    }
    
}

 
