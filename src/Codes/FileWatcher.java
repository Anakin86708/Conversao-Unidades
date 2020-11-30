/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Will keep running as long as the program is executing, looking for changes in
 * the classes updating them.
 *
 * @author silva
 */
public class FileWatcher implements Runnable {

    private volatile Boolean keepRunning;
    private WatchKey watchKey;
    private final Controller asssociatedController;

    /**
     * Reports that the program is running, and associate a controller.
     *
     * @param associatedController It is the object from the Controller class.
     */
    public FileWatcher(Controller associatedController) {
        this.keepRunning = true;
        this.asssociatedController = associatedController;
    }

    /**
     * Watches the directory for changes to the classes.
     */
    private void watcherClassChanges() {
        try {
            Path path = FileSystems.getDefault().getPath(Controller.getPathToFolderString());
            WatchService watcher = FileSystems.getDefault().newWatchService();
            watchKey = path.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
            WatchKey key = watcher.take();

            // Only continues when one of the above events is recorded
            if (keepRunning) {
                this.updateClasses();
            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Updates the combo box.
     */
    private void updateClasses() {
        this.asssociatedController.updateAllComboBox();
    }

    /**
     * Keep watching the directory as long as the programing is running.
     */
    @Override
    public void run() {
        while (this.keepRunning) {
            this.watcherClassChanges();
        }
    }

    /**
     * Reloads the classe's path.
     */
    public void reload() {
        System.out.println("Reloaded path to classes");
        watchKey.cancel();
        updateClasses();
    }

    /**
     * Changes the keepRunning to false, so the program will stop watching the
     * directory.
     */
    public void safeStop() {
        this.keepRunning = false;
        reload();
    }
}
