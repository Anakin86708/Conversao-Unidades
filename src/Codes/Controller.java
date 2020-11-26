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
 *
 * @author silva
 */
public class Controller {
    private LoaderConverter loaderConverter;
    private List<InterfaceConverter> filtredList;

    public Controller(String pathToFolderString) {
        this.loaderConverter = new LoaderConverter(pathToFolderString);
        this.loaderConverter.loader();
    }

    public List<InterfaceConverter> getFiltredList() {
        return filtredList;
    }
       
    public DefaultComboBoxModel generateComboBoxModel() {
        Object[] items = loaderConverter.getLoadedObject();
        DefaultComboBoxModel model = new DefaultComboBoxModel(items);
        return model;
    }
    
    public DefaultComboBoxModel generateCobBoxModel(String filter) {
        this.filtredList = new ArrayList<>();
        for (InterfaceConverter itemObject: loaderConverter.getLoadedObject()) {
            if (itemObject.getCategory().equals(filter)) {
                // Pertence a mesma categoria desejada
                filtredList.add(itemObject);
            }
        }
        return new DefaultComboBoxModel(filtredList.toArray());
    }

    public Double convert(double value,InterfaceConverter inputConverter, InterfaceConverter expectedConverter) {
        return expectedConverter.convert(inputConverter.toBase(value));
    }
}
