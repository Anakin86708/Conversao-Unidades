/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import Converts.InterfaceConverter;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author silva
 */
public class Controller {
    LoaderConverter loaderConverter;

    public Controller(String pathToFolderString) {
        this.loaderConverter = new LoaderConverter(pathToFolderString);
        this.loaderConverter.loader();
    }
    
    
    
    public DefaultComboBoxModel generateComboBoxModel() {
        resources.InterfaceConverter[] items = loaderConverter.getLoadedObject();
        DefaultComboBoxModel model = new DefaultComboBoxModel(items);
        return model;
    }
}
