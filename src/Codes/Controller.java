/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import Converts.InterfaceConverter;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import Converts.InterfaceConverter;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for centralizing the logic of the program in relation 
 * to conversion and is responsible for creating combobo models.
 * @author silva
 */
public class Controller {
    private LoaderConverter loaderConverter;
    private List<InterfaceConverter> filtredList;

    /**
     * Responsable to loaded the String.
     * @param pathToFolderString to be loaded.
     */
    public Controller(String pathToFolderString) {
        this.loaderConverter = new LoaderConverter(pathToFolderString);
        this.loaderConverter.loader();
    }

    /**
     * Responsable for Filtred List.
     * @return the Filtred List.
     */
    public List<InterfaceConverter> getFiltredList() {
        return filtredList;
    }
       
    /**
     * Responsable to create the Combo Box Model with the items. 
     * @return the model with the items inside the Combo Box Model (options to choice).
     */
    public DefaultComboBoxModel generateComboBoxModel() {
        Object[] items = loaderConverter.getLoadedObject();
        DefaultComboBoxModel model = new DefaultComboBoxModel(items);
        return model;
    }
    
    /**
     * Responsable for show the classes in the same category,
     * @param filter define the category.
     * @return the Combo Box Model with the Filter inside the Array.
     */
    public DefaultComboBoxModel generateCobBoxModel(String filter) {
        this.filtredList = new ArrayList<>();
        for (InterfaceConverter itemObject: loaderConverter.getLoadedObject()) {
            if (itemObject.getCategory().equals(filter)) {
                // Belongs to the same desired category
                filtredList.add(itemObject);
            }
        }
        return new DefaultComboBoxModel(filtredList.toArray());
    }

    /**
     *
     * @param value
     * @param inputConverter
     * @param expectedConverter
     * @return
     */
    public Double convert(double value,InterfaceConverter inputConverter, InterfaceConverter expectedConverter) {
        return expectedConverter.convert(inputConverter.toBase(value));
    }
}
