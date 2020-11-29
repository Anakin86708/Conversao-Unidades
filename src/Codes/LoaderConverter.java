/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Converts.InterfaceConverter;
import java.util.List;

/**
 *
 * @author silva
 */
public class LoaderConverter {

    private String pathToFolderString;
    private List<InterfaceConverter> loadedObject = new ArrayList<>();

    /**
     * The method only allocates what exists in the String.
     * @param pathToFolderString String to be converted. 
     */
    public LoaderConverter(String pathToFolderString) {
        this.pathToFolderString = pathToFolderString;
    }

    /**
     * Responsable for conversion (InterfaceConverter), 
     * @return an array of all class objects found.
     */
    public InterfaceConverter[] getLoadedObject() {
        return loadedObject.toArray(new InterfaceConverter[0]);
    }

    /**
     * Responsable for loading all available classes for the first time 
     * and all Objects into the arrayList.
     */
    public void loader() {
        String packageString = "Converts";
        File[] filesFromFolder = getFilesFromFolder();
        for (File classFile : filesFromFolder) {
            try {
                String classString = classFile.getName().replace(".java", "");                
                Object o = Class.forName(packageString + "." + classString).getConstructor().newInstance();
                InterfaceConverter converter = (InterfaceConverter) o;
                addToLoaded(converter);
                
            } catch (ClassNotFoundException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(LoaderConverter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchMethodException ex) {
                // Method was not found because it has a interface 
            }
        }
    }
    
    /**
     * Place only one object per class inside the ArrayList,
     * preventing duplicates.
     * @param obj Object to be compared.
     */
    private void addToLoaded(InterfaceConverter obj) {
        String classString = obj.getClass().getName();
        for (InterfaceConverter objDefault: this.loadedObject) {
            if (objDefault.getClass().getName().equals(classString)) {
                return;  // It´s already inside the arrayList   
            }
        }
        // Otherwise, addd into arrayList 
        this.loadedObject.add(obj);
    }
    
    /**
     * Reads all .java files within a folder. 
     * @return Array of classes files to be loaded.
     */
    private File[] getFilesFromFolder() {
        File folder = new File(this.pathToFolderString);
        FilenameFilter filterName = generateFilenameFilter(".java");
        return folder.listFiles(filterName);
    }

    /**
     * Files filter
     * @param filterString Name that wish to be filtered.
     * @return boolean indicating if the file matches the filter.
     */
    private FilenameFilter generateFilenameFilter(String filterString) {
        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String filter = filterString.toLowerCase();
                return filter.endsWith(".java");
            }
        };
    }
}
