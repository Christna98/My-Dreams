/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christna.mydreams.views;

import com.christna.mydreams.fonctions.Fonctions;
import com.christna.mydreams.models.Entreprise;
import com.christna.mydreams.traitements.TraitementEntreprise;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class VueEntreprise extends JPanel {

    Entreprise entreprise;
    JTable table;
    DefaultTableModel model;
    JPanel form;
    String msg;

    JLabel labelId;
    JLabel labelIdGroupe;
    JLabel labelNomEntreprise;
    JLabel labelNomProprietaire;
    JLabel labelPrenomProprietaire;
    JLabel labelSexe;
    JLabel labelAdresse;
    JLabel labelTelephone;
    JLabel labelTypePiece;
    JLabel labelNoPiece;
    JLabel labelCreation;
    JLabel labelDescription;

    JTextField textFieldId = new JTextField();
    JComboBox<String> comboBoxIdGroupe = new JComboBox<String>();
    JTextField textFieldNomEntreprise = new JTextField();
    JTextField textFieldNomProprietaire = new JTextField();
    JTextField textFieldPrenomProprietaire = new JTextField();
    JComboBox<String> comboBoxSexe = new JComboBox<String>();
    JTextField textFieldAdresse = new JTextField();
    JTextField textFieldTelephone = new JTextField();
    JTextField textFieldTypePiece = new JTextField();
    JTextField textFieldNoPiece = new JTextField();
    JDateChooser textFieldDateCreation = new JDateChooser();
    JTextField textFieldDescription = new JTextField();

    TraitementEntreprise traitementEntreprise = new TraitementEntreprise();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    public VueEntreprise() {

        this.setLayout(new BorderLayout());

        //Table
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("ID Groupe");
        model.addColumn("Nom Entreprise");
        model.addColumn("Nom Proprietaire");
        model.addColumn("Prenom Proprietaire");
        model.addColumn("Sexe");
        model.addColumn("Adresse");
        model.addColumn("Telephone");
        model.addColumn("Type Piece");
        model.addColumn("N° Piece");
        model.addColumn("Date Creation");
        model.addColumn("Description");

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
                comboBoxIdGroupe.setSelectedItem(table.getValueAt(table.getSelectedRow(), 1).toString());
                textFieldNomEntreprise.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
                textFieldNomProprietaire.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
                textFieldPrenomProprietaire.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
                comboBoxSexe.setSelectedItem(table.getValueAt(table.getSelectedRow(), 5).toString());
                textFieldAdresse.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
                textFieldTelephone.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
                textFieldTypePiece.setText(table.getValueAt(table.getSelectedRow(), 8).toString());
                textFieldNoPiece.setText(table.getValueAt(table.getSelectedRow(), 9).toString());
                try {
                    textFieldDateCreation.setDate(new Date(sdf.format(new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(table.getSelectedRow(), 10).toString()))));
                } catch (ParseException ex) {
                    Logger.getLogger(VueEntreprise.class.getName()).log(Level.SEVERE, null, ex);
                }
                textFieldDescription.setText(table.getValueAt(table.getSelectedRow(), 11).toString());
            }
        });

        //Formulaire
        form = new JPanel();
        form.setPreferredSize(new Dimension(0, 250));
        form.setBackground(new Color(0x000030));

        ArrayList<String> idsGroupe = new ArrayList<String>() {
            {
                add("1");
                add("2");
                add("3");
                add("4");
                add("5");
                add("6");
                add("7");
                add("8");
                add("9");
                add("10");
                add("11");
                add("12");
            }
        };
        for(String ids : idsGroupe){
            comboBoxIdGroupe.insertItemAt(ids, comboBoxIdGroupe.getItemCount());
        }
        comboBoxIdGroupe.setSelectedIndex(0);

        ArrayList<String> sexes = new ArrayList<String>() {
            {
                add("M");
                add("F");
            }
        };

        for(String sexe : sexes){
            comboBoxSexe.insertItemAt(sexe, comboBoxSexe.getItemCount());
        }
        comboBoxSexe.setSelectedIndex(0);
        
        form.add(Fonctions.createSelectDiv("ID Groupe", comboBoxIdGroupe));
        form.add(Fonctions.createInputDiv("Nom Entreprise", textFieldNomEntreprise, 250, 27));
        form.add(Fonctions.createInputDiv("Nom Proprietaire", textFieldNomProprietaire, 250, 27));
        form.add(Fonctions.createInputDiv("Prenom Proprietaire", textFieldPrenomProprietaire, 250, 27));
        form.add(Fonctions.createSelectDiv("Sexe", comboBoxSexe));
        form.add(Fonctions.createInputDiv("Adresse", textFieldAdresse, 250, 27));
        form.add(Fonctions.createInputDiv("Telephone", textFieldTelephone, 250, 27));
        form.add(Fonctions.createInputDiv("Type Piece", textFieldTypePiece, 250, 27));
        form.add(Fonctions.createInputDiv("N° Piece", textFieldNoPiece, 250, 27));
        form.add(Fonctions.createCalendarDiv("Date Creation", textFieldDateCreation, 250, 27));
        form.add(Fonctions.createInputDiv("Description", textFieldDescription, 250, 27));

        //Butons
        JPanel placeButtons = new JPanel();
        placeButtons.setLayout(new FlowLayout());
        placeButtons.setBackground(new Color(0x000021));
        placeButtons.setPreferredSize(new Dimension(0, 55));

        JButton enregistrerBtn = new JButton("Enregistrer");
        enregistrerBtn.addActionListener((ActionEvent e) -> {
            enregistrer();
        });

        JButton modifierBtn = new JButton("Modifier");
        modifierBtn.addActionListener((ActionEvent e) -> {
            modifier();
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
        placeButtons.add(modifierBtn);
        placeButtons.add(supprimmerBtn);
        placeButtons.add(printerBtn);

        this.add(new JScrollPane(table), BorderLayout.NORTH);
        this.add(form, BorderLayout.CENTER);
        this.add(placeButtons, BorderLayout.SOUTH);
    }

    //Enregistrement
    private void enregistrer() {

        try {
            int id = 0;
            int idGroupe = Integer.parseInt(comboBoxIdGroupe.getSelectedItem().toString());
            String nomEntreprise = textFieldNomEntreprise.getText();
            String nomProprietaire = textFieldNomProprietaire.getText();
            String prenomProprietaire = textFieldPrenomProprietaire.getText();
            char sexe = comboBoxSexe.getSelectedItem().toString().charAt(0);
            String adresse = textFieldAdresse.getText();
            String telephone = textFieldTelephone.getText();
            String typePieceProprietaire = textFieldTypePiece.getText();
            int noPieceProprietaire = Integer.parseInt(textFieldNoPiece.getText());
            Date dateCreation = textFieldDateCreation.getDate();
            String description = textFieldDescription.getText();

            entreprise = new Entreprise(
                    id,
                    idGroupe,
                    nomEntreprise,
                    nomProprietaire,
                    prenomProprietaire,
                    sexe,
                    adresse,
                    telephone,
                    typePieceProprietaire,
                    noPieceProprietaire,
                    dateCreation,
                    description
            );

            traitementEntreprise.enregistrer(entreprise);

            initialize();
            loadDatas();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modifier() {

        try {

            if (table.getSelectedRow() != -1) {
                int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
                int idGroupe = Integer.parseInt(comboBoxIdGroupe.getSelectedItem().toString());
                String nomEntreprise = textFieldNomEntreprise.getText();
                String nomProprietaire = textFieldNomProprietaire.getText();
                String prenomProprietaire = textFieldPrenomProprietaire.getText();
                char sexe = comboBoxSexe.getSelectedItem().toString().charAt(0);
                String adresse = textFieldAdresse.getText();
                String telephone = textFieldTelephone.getText();
                String typePieceProprietaire = textFieldTypePiece.getText();
                int noPieceProprietaire = Integer.parseInt(textFieldNoPiece.getText());
                Date dateCreation = textFieldDateCreation.getDate();
                String description = textFieldDescription.getText();

                entreprise = new Entreprise(
                        id,
                        idGroupe,
                        nomEntreprise,
                        nomProprietaire,
                        prenomProprietaire,
                        sexe,
                        adresse,
                        telephone,
                        typePieceProprietaire,
                        noPieceProprietaire,
                        dateCreation,
                        description
                );

                traitementEntreprise.modifier(entreprise);

                initialize();
                loadDatas();
            } else {
                msg = "Veuillez sélectionner l'entreprise à modifier.";
                JOptionPane.showMessageDialog(null, msg, "Modification", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Supression
    public void supprimer() {
        if (table.getSelectedRow() != -1) {
            traitementEntreprise.supression(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
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
            Logger.getLogger(VueEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Load Datas
    private void loadDatas() {

        model.setRowCount(0);

        for (Entreprise newEntreprise : new TraitementEntreprise().afficher()) {
            Object[] data = {
                newEntreprise.getId(),
                newEntreprise.getIdGroupe(),
                newEntreprise.getNomEntreprise(),
                newEntreprise.getNomProprietaire(),
                newEntreprise.getPrenomProprietaire(),
                newEntreprise.getSexe(),
                newEntreprise.getAdresse(),
                newEntreprise.getTelephone(),
                newEntreprise.getTypePieceProprietaire(),
                newEntreprise.getNoPieceProprietaire(),
                newEntreprise.getDateCreation(),
                newEntreprise.getDescription()
            };

            model.addRow(data);
        }
    }

    public void initialize() {
        textFieldId.setText("");
        comboBoxIdGroupe.setSelectedIndex(0);
        textFieldNomEntreprise.setText("");
        textFieldNomProprietaire.setText("");
        textFieldPrenomProprietaire.setText("");
        comboBoxSexe.setSelectedIndex(0);
        textFieldAdresse.setText("");
        textFieldTelephone.setText("");
        textFieldTypePiece.setText("");
        textFieldNoPiece.setText("");
        textFieldDateCreation.setDate(new Date());
        textFieldDescription.setText("");
    }
}
