/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converts;

import Codes.Language;

/**
 *
 * @author silva
 */

/**
 * Teste de Javadoc
 * @author Leo
 */
public abstract class AbstractConverter {
    
    private final String category;
    private final String name;

    public AbstractConverter(String category, String name) {
        this.category = Language.getResourceBundle().getString(category);;
        this.name = Language.getResourceBundle().getString(name);
    }
    
    /**
     * Retorna a categoria da medida.
     * @return retorna a categoria
     */
    public String getCategory() {
        return this.category;
    }
    
    /**
     * Representa o objeto como String
     * @return Nome da unidade associada a classe
     */
    public String toString() {
        return this.name; 
    }
    
   /**
    * Recebe o input do usuário e o transforma para a medida base (m)
    * @param input
    * @return retorna o input em metros
    */
    
    abstract public double toBase(double input);
    
    /**
     * Recebe um valor em metros, e o transforma para a medida escolhida.
     * @param input
     * @return Retorna o valor convertido para a unidade escolhida.
     */
    
    abstract public double convert(double input);
    
}
