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
public class LightYear extends AbstractConverter {

    public LightYear() {
        super("Length", "LY");
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
