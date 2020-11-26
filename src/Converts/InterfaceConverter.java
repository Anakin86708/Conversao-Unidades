/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converts;

/**
 *
 * @author silva
 */

/**
 * Teste de Javadoc
 * @author Leo
 */
public interface InterfaceConverter {

    /**
     * Retorna a categoria da medida.
     * @return retorna a categoria
     */
    String getCategory();
    
   /**
    * Recebe o input do usuário e o transforma para a medida base (m)
    * @param input
    * @return retorna o input em metros
    */
    
    public double toBase(double input);
    
    /**
     * Recebe um valor em metros, e o transforma para a medida escolhida.
     * @param input
     * @return Retorna o valor convertido para a unidade escolhida.
     */
    
    public double convert(double input);
    
}
