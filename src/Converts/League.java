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
public class League implements InterfaceConverter{
    private final String category;
    
    public League(){
        this.category = "length";
    }

    @Override
    public String toString() {
        return "League (land)";  /* NAO TENHO CTZ DO SHORT, N SEI SE É LAND */
    }
    
    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public double toBase(double input) {
        return input * 4828.03;
    }

    @Override
    public double convert(double input) {
        return input * 0.000207124 ;
    }
}
