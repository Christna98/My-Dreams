/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christna.mydreams.views;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author Christna
 */
public class App {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        VuePrincipale vuePrincipale = new VuePrincipale();
        vuePrincipale.setVisible(true);
    }
}
