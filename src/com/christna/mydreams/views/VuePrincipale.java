/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christna.mydreams.views;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author Christna
 */
public class VuePrincipale extends JFrame {

    public VuePrincipale() {

        this.setTitle("My Dreams");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(700, 600));
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Principal Panel
        JTabbedPane jtabbedPane = new JTabbedPane();
        
        jtabbedPane.add("Entreprises", new VueEntreprise());
        jtabbedPane.add("Prets Entreprises", new VuePretEntreprise());
        jtabbedPane.add("Prets", new VuePret());
        jtabbedPane.add("Remboursements", new VueRemboursement());
        
        this.add(jtabbedPane);
    }
}
