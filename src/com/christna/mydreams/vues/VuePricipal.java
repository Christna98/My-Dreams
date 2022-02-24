/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christna.mydreams.vues;

import javax.swing.GroupLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 *
 * @author Christna
 */
public class VuePricipal extends JFrame {

    private JDesktopPane desktop;
    private GroupLayout desktopLayout;

    private JMenuBar jMenuBar1;

    private JMenu menuEntreprise;
    private JMenu menuPret;
    private JMenu menuRemboursement;

    public VuePricipal() {
        initialisationComposants();
    }

    public void initialisationComposants() {

        desktop = new JDesktopPane();
        jMenuBar1 = new JMenuBar();

        menuEntreprise = new JMenu();
        menuPret = new JMenu();
        menuRemboursement = new JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        desktop.setBackground(new java.awt.Color(0, 51, 51));

        desktopLayout = new javax.swing.GroupLayout(desktop);

        desktop.setLayout(desktopLayout);

        desktopLayout.setHorizontalGroup(
                desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 821, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
                desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 504, Short.MAX_VALUE)
        );

        menuEntreprise.setForeground(new java.awt.Color(0, 51, 51));
        menuEntreprise.setText("Entreprises");
        menuEntreprise.setFont(new java.awt.Font("Californian FB", 1, 18));
        menuEntreprise.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEntrepriseMouseClicked(evt);
            }
        });

        menuPret.setForeground(new java.awt.Color(0, 51, 51));
        menuPret.setText("Prets");
        menuPret.setFont(new java.awt.Font("Californian FB", 1, 18));
        menuPret.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEntrepriseMouseClicked(evt);
            }
        });

        menuRemboursement.setForeground(new java.awt.Color(0, 51, 51));
        menuRemboursement.setText("Remboursements");
        menuRemboursement.setFont(new java.awt.Font("Californian FB", 1, 18));
        menuRemboursement.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEntrepriseMouseClicked(evt);
            }
        });

        jMenuBar1.add(menuEntreprise);
        jMenuBar1.add(menuPret);
        jMenuBar1.add(menuRemboursement);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(desktop)
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }

    private void menuEntrepriseMouseClicked(java.awt.event.MouseEvent evt) {
        if (EntrepriseView.fn == 0) {
            EntrepriseView entrepriseView = new EntrepriseView();
            desktop.add(entrepriseView);
            entrepriseView.setVisible(true);
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VuePricipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VuePricipal().setVisible(true);
        });
    }
}
