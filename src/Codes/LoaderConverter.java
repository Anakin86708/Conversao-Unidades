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
import java.util.List;
import Converts.AbstractConverter;

/**
 *
 * @author silva
 */
public class LoaderConverter {

    private List<AbstractConverter> loadedObject;

    public LoaderConverter() {

    }

    public AbstractConverter[] getLoadedObject() {
        this.loader();
        return loadedObject.toArray(new AbstractConverter[0]);
    }

    /**
     * Responsável por carregar pela primeira vez todas as classes que estão
     * disponíveis e carregar no arrayList todos os Objects.
     */
    public void loader() {
        this.loadedObject = new ArrayList<>();
        String packageString = "Converts";
        File[] filesFromFolder = getFilesFromFolder();
        for (File classFile : filesFromFolder) {
            try {
                String classString = classFile.getName().replace(".java", "");
                Object o = Class.forName(packageString + "." + classString).getConstructor().newInstance();
                AbstractConverter converter = (AbstractConverter) o;
                addToLoaded(converter);

            } catch (ClassNotFoundException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException  ex) {
                Logger.getLogger(LoaderConverter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchMethodException | InvocationTargetException ex) {
                // Método não foi encontrado pois representa uma 
                System.err.println("erro!");
            }
        }
    }

    /**
     * Coloca apenas um objeto por classe dentro do ArrayList, evitando
     * duplicatas.
     *
     * @param obj Objeto a ser comparado.
     */
    private void addToLoaded(AbstractConverter obj) {
        String classString = obj.getClass().getName();
        for (AbstractConverter objDefault : this.loadedObject) {
            if (objDefault.getClass().getName().equals(classString)) {
                return;  // Já está dentro do arrayList
            }
        }
        // Do contrário, adiciona no ArrayList
        this.loadedObject.add(obj);
    }

    /**
     * Lê todos os arquivos .java dentro de uma pasta.
     *
     * @return Array de arquivos de classes a serem carregados.
     */
    private File[] getFilesFromFolder() {
        File folder = new File(Controller.getPathToFolderString());
        FilenameFilter filterName = generateFilenameFilter(".java");
        return folder.listFiles(filterName);
    }

    /**
     * Filtro de arquivos.
     *
     * @param filterString Nome que deseja ser filtrado.
     * @return booleano indicando se o arquivo corresponde ao filtro.
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
