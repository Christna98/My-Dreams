/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christna.mydreams.views;

import com.christna.mydreams.fonctions.Fonctions;
import com.christna.mydreams.models.Entreprise;
import com.christna.mydreams.models.PretEntreprise;
import com.christna.mydreams.traitements.TraitementEntreprise;
import com.christna.mydreams.traitements.TraitementPretEntreprise;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christna
 */
public class VuePretEntreprise extends JPanel {

    PretEntreprise pretEntreprise;
    JTable table;
    DefaultTableModel model;
    JPanel form;
    String msg;

    JLabel labelId;
    JLabel labelIdGroupe;
    JLabel labelMontantEmprunte;

    JComboBox<String> comboBoxId = new JComboBox<String>();
    JTextField textFieldIdGroupe = new JTextField();
    JTextField textFieldMontantEmprunte = new JTextField();

    TraitementPretEntreprise traitementPretEntreprise = new TraitementPretEntreprise();

    ArrayList<Entreprise> entreprises = new TraitementEntreprise().afficher();

    public VuePretEntreprise() {

        this.setLayout(new BorderLayout());

        //Table
        model = new DefaultTableModel();
        model.addColumn("ID Entreprise");
        model.addColumn("ID Groupe");
        model.addColumn("Montant Emprunté");

        loadDatas();

        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };

        table.setShowGrid(true);
        table.setRowHeight(25);
        table.setFont(new Font("AvantGarde", Font.PLAIN, 12));
        table.setAutoCreateRowSorter(true);

        DefaultTableCellRenderer headerCells = new DefaultTableCellRenderer();
        headerCells.setHorizontalAlignment(JLabel.CENTER);
        headerCells.setBackground(new Color(0x000021));
        headerCells.setForeground(new Color(0xFFFFFF));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            table.getColumnModel().getColumn(i).setHeaderRenderer(headerCells);
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                comboBoxId.setSelectedItem(table.getValueAt(table.getSelectedRow(), 0).toString());
                textFieldIdGroupe.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
                textFieldMontantEmprunte.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
            }
        });

        //Formulaire
        form = new JPanel();
        form.setPreferredSize(new Dimension(0, 250));
        form.setBackground(new Color(0x000030));

        if (!entreprises.isEmpty()) {
            for (Entreprise entreprise : entreprises) {
                comboBoxId.insertItemAt(String.valueOf(entreprise.getId()), comboBoxId.getItemCount());
            }
            comboBoxId.setSelectedIndex(0);
            textFieldIdGroupe.setText(String.valueOf(entreprises.get(0).getIdGroupe()));
        }

        comboBoxId.addActionListener((ActionEvent e) -> {
            for (Entreprise entreprise : entreprises) {
                if (Integer.parseInt((String) comboBoxId.getSelectedItem()) == entreprise.getId()) {
                    textFieldIdGroupe.setText(String.valueOf(entreprise.getIdGroupe()));
                }
            }
        });

        textFieldIdGroupe.setEnabled(false);
        
        form.add(Fonctions.createSelectDiv("ID Entreprises", comboBoxId));
        form.add(Fonctions.createInputDiv("ID Groupe", textFieldIdGroupe, 250, 27));
        form.add(Fonctions.createInputDiv("Montant Emprunte", textFieldMontantEmprunte, 250, 27));

        //Butons
        JPanel placeButtons = new JPanel();
        placeButtons.setLayout(new FlowLayout());
        placeButtons.setBackground(new Color(0x000021));
        placeButtons.setPreferredSize(new Dimension(0, 55));

        JButton enregistrerBtn = new JButton("Enregistrer");
        enregistrerBtn.addActionListener((ActionEvent e) -> {
            enregistrer();
        });

        JButton supprimmerBtn = new JButton("Supprimer");
        supprimmerBtn.addActionListener((ActionEvent e) -> {
            supprimer();
        });

        JButton printerBtn = new JButton("Imprimer");
        printerBtn.addActionListener((ActionEvent e) -> {
            printer();
        });

        placeButtons.add(enregistrerBtn);
        placeButtons.add(supprimmerBtn);
        placeButtons.add(printerBtn);

        this.add(new JScrollPane(table), BorderLayout.NORTH);
        this.add(form, BorderLayout.CENTER);
        this.add(placeButtons, BorderLayout.SOUTH);
    }

    //Enregistrement
    private void enregistrer() {

        try {
            int id = Integer.parseInt(comboBoxId.getSelectedItem().toString());
            int idGroupe = Integer.parseInt(textFieldIdGroupe.getText());
            float montantEmprunte = Float.parseFloat(textFieldMontantEmprunte.getText());

            pretEntreprise = new PretEntreprise(
                    id,
                    idGroupe,
                    montantEmprunte
            );

            traitementPretEntreprise.enregistrer(pretEntreprise);

            initialize();
            loadDatas();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Supression
    public void supprimer() {
        if (table.getSelectedRow() != -1) {
            traitementPretEntreprise.supression(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
        } else {
            msg = "Veuillez sélectionner l'entreprise à supprimer.";
            JOptionPane.showMessageDialog(null, msg, "Suppression", JOptionPane.ERROR_MESSAGE);
        }
        initialize();
        loadDatas();
    }

    //Imprimer
    public void printer() {
        try {
            table.print();
        } catch (PrinterException ex) {
            Logger.getLogger(VuePretEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Load Datas
    private void loadDatas() {

        model.setRowCount(0);

        for (PretEntreprise newPretEntreprise : new TraitementPretEntreprise().afficher()) {

            Object[] data = {
                newPretEntreprise.getId(),
                newPretEntreprise.getIdGroupe(),
                newPretEntreprise.getMontantEmprunte()
            };

            model.addRow(data);
        }
    }

    public void initialize() {
        comboBoxId.setSelectedIndex(0);
        textFieldIdGroupe.setText("");
        textFieldMontantEmprunte.setText("");
    }
}
