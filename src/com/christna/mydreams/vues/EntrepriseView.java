/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christna.mydreams.vues;

import javax.swing.JInternalFrame;

/**
 *
 * @author Christna
 */
public class EntrepriseView extends JInternalFrame {

    public static int fn = 0;

    public EntrepriseView() {
        initialisationComposants();
    }

    public void initialisationComposants() {
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
    }
}
