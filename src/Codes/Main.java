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

/**
 * The purpose of the "Main" class is to initialize the program.
 * @author enzoj
 */
public class Main {

    /**
     * Method that iniatilize the program.
     * @param args Parameter to be iniatilized.
     */
    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
}
