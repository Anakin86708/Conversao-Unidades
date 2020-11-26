/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import GUI.MainWindow;

/**
 *
 * @author silva
 */
public class Main {
    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
        LoaderConverter lc = new LoaderConverter("D:\\Users\\Ariel\\OneDrive - Etec Centro Paula Souza\\Documentos\\NetBeansProjects\\FactoryTest\\src\\resources");
        lc.loader();
    }
}
