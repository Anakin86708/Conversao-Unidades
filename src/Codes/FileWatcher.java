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
 * https://docs.oracle.com/javase/tutorial/essential/io/notification.html
 *
 * @author silva
 */
public class FileWatcher implements Runnable {

    private volatile Boolean keepRunning;
    private WatchKey watchKey;
    private final Controller asssociatedController;

    public FileWatcher(Controller associatedController) {
        this.keepRunning = true;
        this.asssociatedController = associatedController;
    }

    /**
     * Monitora o diretório em busca de alterações nas classes
     */
    private void watcherClassChanges() {
        try {
            Path path = FileSystems.getDefault().getPath(Controller.getPathToFolderString());
            WatchService watcher = FileSystems.getDefault().newWatchService();
            watchKey = path.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
            WatchKey key = watcher.take();

            // Apenas continua quando for registrado um dos eventos acima
            if (keepRunning) {
                this.updateClasses();
            }
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateClasses() {
        this.asssociatedController.updateAllComboBox();
    }

    @Override
    public void run() {
        while (this.keepRunning) {
            this.watcherClassChanges();
        }
    }

    public void reload() {
        System.out.println("Reloaded path to classes");
        watchKey.cancel();
        updateClasses();
    }

    public void safeStop() {
        this.keepRunning = false;
        reload();
    }
}
