/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import javax.swing.DefaultComboBoxModel;
import GUI.MainWindow;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Converts.AbstractConverter;

/**
 * Responsible for centralizing the logic of the program in relation 
 * to conversion and is responsible for creating combo models.
 * @author silva
 */
public class Controller {

    private MainWindow mainWindow;
    private Thread watcherThread;
    private FileWatcher watcher;
    private LoaderConverter loaderConverter;
    private List<AbstractConverter> filtredList;
    private static String pathToFolderString;  // Deve ser o único local contendo a string

    
    /**
     * Sets the main window, the path to the folder and creates a new
     * thread to monitor the program.
     * @param mainWindow Where the GUI will be running.
     * @param pathToFolderString The path where the classes for the conversion
     * are.
     */
    public Controller(MainWindow mainWindow, String pathToFolderString) {
        this.mainWindow = mainWindow;

        Controller.pathToFolderString = pathToFolderString;
        this.loaderConverter = new LoaderConverter();

        startWatchThread();
    }

    private void startWatchThread() {
        // Monitors through the file system on another thread
        this.watcher = new FileWatcher(this);
        this.watcherThread = new Thread(watcher);
        this.watcherThread.start();
        this.loaderConverter.loader();
    }
    
    public void restartWatchThread() {
        this.watcher.safeStop();
        try {
            this.watcherThread.join();
        } catch (InterruptedException ex) {
            System.err.println("Error while joining watch thread: " + ex.getMessage());
        }
        this.startWatchThread();
    }

    /**
     * Responsable for Filtred List.
     * @return the Filtred List.
     */
    public List<AbstractConverter> getFiltredList() {
        return filtredList;
    }

    /**
     * Gets the path where the conversion classes are.
     * @return The path itself.
     */
    
    public static String getPathToFolderString() {
        return Controller.pathToFolderString;
    }

    /**
     * Sets a new folder's path.
     * @param pathToFolderString The previous folder's path.
     */
    public void setPathToFolderString(String pathToFolderString) {
        Controller.pathToFolderString = pathToFolderString;
        this.watcher.reload();
    }

    /**
     * Responsable to create the Combo Box Model with the items. 
     * @return The model with the items inside the Combo Box Model 
     * (options to choice).
     */
    public DefaultComboBoxModel generateComboBoxModel() {
        Object[] items = loaderConverter.getLoadedObject();
        DefaultComboBoxModel model = new DefaultComboBoxModel(items);
        return model;
    }
    
    /**
     * Responsable for show the classes in the same category,
     * @param filter Define the category.
     * @return The Combo Box Model with the Filter inside the Array.
     */
    public DefaultComboBoxModel generateCobBoxModel(String filter) {
        this.filtredList = new ArrayList<>();
        for (AbstractConverter itemObject : loaderConverter.getLoadedObject()) {
            if (itemObject.getCategory().equals(filter)) {
                // Belongs to the same desired category
                filtredList.add(itemObject);
            }
        }
        return new DefaultComboBoxModel(filtredList.toArray());
    }

    /**
     * Converts the original value to the unit of measure's base.
     * @param value Input from the user.
     * @param inputConverter User's value converted.
     * @param expectedConverter The expected value after the conversion.
     * @return The converted value.
     */
    public Double convert(double value, AbstractConverter inputConverter, AbstractConverter expectedConverter) {
        try {
            return expectedConverter.convert(inputConverter.toBase(value));
        } catch (Exception e) {
            return 0.0;
        }
    }

    /**
     * Stops the monitoring over the classes.
     */
    @Override
    protected void finalize() {
        this.watcher.safeStop();
        try {
            this.watcherThread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Updates all the combo boxes.
     */
    public void updateAllComboBox() {
        this.updateComboBoxInputModel();
        this.updateComboBoxExpectedModel();
    }

    /**
     * Updates the list of units that can be selected by the user.
     */
    public void updateComboBoxInputModel() {
        this.mainWindow.getComboBoxInput().setModel(this.generateComboBoxModel());
    }

    /**
     * Sets the category and the output value.
     */
    public void updateComboBoxExpectedModel() {
        AbstractConverter interfaceConverter = mainWindow.getInputConverter();
        DefaultComboBoxModel outputModel = null;
        String actualCategory = null;
        try {
            actualCategory = interfaceConverter.getCategory();
            outputModel = this.generateCobBoxModel(actualCategory);
        } catch (NullPointerException nullPointerException) {
            outputModel = new DefaultComboBoxModel();
        }
        mainWindow.getComboBoxExpected().setModel(outputModel);
        mainWindow.changeUnit(actualCategory);
        mainWindow.changeClassesCounter();
    }
}
