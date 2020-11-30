/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import Converts.AbstractConverter;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author silva
 */
public class LoaderConverter {

    private List<AbstractConverter> loadedObject;

    public AbstractConverter[] getLoadedObject() {
        this.loader();
        Collections.sort(loadedObject, new Comparator<AbstractConverter>() {
            @Override
            public int compare(AbstractConverter o1, AbstractConverter o2) {
                int compare = o1.getCategory().compareTo(o2.getCategory());
                System.out.println("Convert " + o1.getCategory() + " to " + o2.getCategory() + " = " + compare);

                if (compare == 0) {
                    // Belongs to the same category
                    // Compare with toString
                    compare = o1.toString().compareTo(o2.toString());
                }
                return compare;
            }
        });
        return loadedObject.toArray(new AbstractConverter[0]);
    }

    /**
     * Responsable for loading all available classes for the first time and all
     * Objects into the arrayList.
     */
    public void loader() {
        this.loadedObject = new ArrayList<>();
        String[] splitPath = Controller.getPathToFolderString().split("/");
        String packageString = splitPath[splitPath.length-1];
        File[] filesFromFolder = getFilesFromFolder();
        if (filesFromFolder != null) {
            for (File classFile : filesFromFolder) {
                try {
                    String classString = classFile.getName().replace(".java", "");
                    Object o = Class.forName(packageString + "." + classString).getConstructor().newInstance();
                    AbstractConverter converter = (AbstractConverter) o;
                    addToLoaded(converter);

                } catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException ex) {
                    Logger.getLogger(LoaderConverter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException | InvocationTargetException ex) {
                    // Method was not found because it was a abstract class
                    // Just ignore and continue exection
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"Error loading class: " + ex.getMessage());
                    return;
                }
            }
        }
    }

    /**
     * Put only one object per class inside the ArrayList, preventing
     * duplicates.
     *
     * @param obj Object to be compared.
     */
    private void addToLoaded(AbstractConverter obj) {
        String classString = obj.getClass().getName();
        for (AbstractConverter objDefault : this.loadedObject) {
            if (objDefault.getClass().getName().equals(classString)) {
                return;  // It´s already inside the arrayList   
            }
        }
        // Otherwise, add into arrayList 
        this.loadedObject.add(obj);
    }

    /**
     * Reads all .java files within a folder.
     *
     * @return Array of classes files to be loaded.
     */
    private File[] getFilesFromFolder() {
        File folder = new File(Controller.getPathToFolderString());
        FilenameFilter filterName = generateFilenameFilter(".java");
        return folder.listFiles(filterName);
    }

    /**
     * Files filter
     *
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
