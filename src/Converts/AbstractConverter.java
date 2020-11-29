/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converts;

import java.util.Comparator;

/**
 *
 * @author silva
 */
public abstract class AbstractConverter implements Comparator<AbstractConverter> {
    
    private final String category;

    public AbstractConverter(String category) {
        this.category = category;
    }
    
    /**
     * Retorna a categoria da medida.
     * @return retorna a categoria
     */
    public String getCategory() {
        return this.category;
    }
    
    @Override
    public int compare(AbstractConverter o1, AbstractConverter o2) {
//        int compare = this.getCategory().compareTo(otherAbstractConverter.getCategory());
        int compare = o1.getCategory().compareTo(o2.getCategory());
        System.out.println("Convert " + o1.getCategory() + " to " + o2.getCategory() + " = " + compare);
        
//        if (compare == 0) {
//            // Pertence a mesma categoria
//            // Comparar com o nome da unidade
//            compare = this.toString().compareTo(otherAbstractConverter.toString());
//        }
        
        return compare;
    }
   
    
   /**
    * Recebe o input do usuário e o transforma para a medida base (m)
    * @param input
    * @return retorna o input em metros
    */
    public abstract double toBase(double input);
    
    /**
     * Recebe um valor em metros, e o transforma para a medida escolhida.
     * @param input
     * @return Retorna o valor convertido para a unidade escolhida.
     */
    public abstract double convert(double input);
}
