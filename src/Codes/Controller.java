/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import javax.swing.DefaultComboBoxModel;
import Converts.InterfaceConverter;
import GUI.MainWindow;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author silva
 */
public class Controller {

    private MainWindow mainWindow;
    private Thread watcherThread;
    private FileWatcher watcher;
    private LoaderConverter loaderConverter;
    private List<InterfaceConverter> filtredList;
    private static String pathToFolderString;  // Deve ser o único local contendo a string

    public Controller(MainWindow mainWindow, String pathToFolderString) {
        this.mainWindow = mainWindow;

        Controller.pathToFolderString = pathToFolderString;
        this.loaderConverter = new LoaderConverter();

        // Monitora pelo sistema de arquivos em outra thread
        this.watcher = new FileWatcher(this);
        this.watcherThread = new Thread(watcher);
        this.watcherThread.start();
        this.loaderConverter.loader();
    }

    public List<InterfaceConverter> getFiltredList() {
        return filtredList;
    }

    public static String getPathToFolderString() {
        return Controller.pathToFolderString;
    }

    public void setPathToFolderString(String pathToFolderString) {
        // Permite alteração da pasta, mas necessita alterar o watcher também
        Controller.pathToFolderString = pathToFolderString;
        this.watcher.reload();
    }

    public DefaultComboBoxModel generateComboBoxModel() {
        Object[] items = loaderConverter.getLoadedObject();
        DefaultComboBoxModel model = new DefaultComboBoxModel(items);
        return model;
    }

    public DefaultComboBoxModel generateCobBoxModel(String filter) {
        this.filtredList = new ArrayList<>();
        for (InterfaceConverter itemObject : loaderConverter.getLoadedObject()) {
            if (itemObject.getCategory().equals(filter)) {
                // Pertence a mesma categoria desejada
                filtredList.add(itemObject);
            }
        }
        return new DefaultComboBoxModel(filtredList.toArray());
    }

    public Double convert(double value, InterfaceConverter inputConverter, InterfaceConverter expectedConverter) {
        return expectedConverter.convert(inputConverter.toBase(value));
    }

    @Override
    protected void finalize() {
        this.watcher.safeStop();
        try {
            this.watcherThread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateAllComboBox() {
        this.updateComboBoxInputModel();
        this.updateComboBoxExpectedModel();
    }

    /**
     * Atualiza a lista de unidades que podem ser selecionadas pelo usuário
     */
    public void updateComboBoxInputModel() {
        this.mainWindow.getComboBoxInput().setModel(this.generateComboBoxModel());
    }

    public void updateComboBoxExpectedModel() {
        InterfaceConverter interfaceConverter = mainWindow.getInputConverter();
        String actualCategory = interfaceConverter.getCategory();
        DefaultComboBoxModel outputModel = this.generateCobBoxModel(actualCategory);
        mainWindow.getComboBoxExpected().setModel(outputModel);
        mainWindow.changeUnit(actualCategory);
        mainWindow.changeClassesCounter();
    }
}
