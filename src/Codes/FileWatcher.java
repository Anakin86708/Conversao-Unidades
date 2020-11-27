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
 * Singleton
 * @author silva
 */
public class FileWatcher implements Runnable{
    private static FileWatcher instance;
    private String pathToFolderString;
    
    public static synchronized FileWatcher getInstance(String pathToFolderString) {
        if (instance == null) {
            // Realiza chamada do construtor
            instance = new FileWatcher(pathToFolderString);
        }
        // Retorna a instância, nova se ainda não existir, ou a mesma, caso já tenha sido criada
        return instance;
    }
    
    private FileWatcher(String pathToFolderString) {
        this.pathToFolderString = pathToFolderString;
    }

    public void setPathToFolderString(String pathToFolderString) {
        this.pathToFolderString = pathToFolderString;
    }
    
    /**
     * Monitora o diretório em busca de alterações nas classes
     */
    private void watcherClassChanges() {
        try {
            Path path = FileSystems.getDefault().getPath(this.pathToFolderString);
            WatchService watcher = FileSystems.getDefault().newWatchService();
            WatchKey watchKey = path.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
            
            WatchKey key = watcher.take();
            System.out.println("Caiu aqui!");
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        this.watcherClassChanges();
    }
    
}
