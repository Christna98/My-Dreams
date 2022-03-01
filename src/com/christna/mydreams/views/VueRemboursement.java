/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christna.mydreams.views;

import com.christna.mydreams.fonctions.Fonctions;
import com.christna.mydreams.models.Pret;
import com.christna.mydreams.models.Remboursement;
import com.christna.mydreams.traitements.TraitementPret;
import com.christna.mydreams.traitements.TraitementRemboursement;
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
public class VueRemboursement extends JPanel {

    Remboursement remboursement;
    JTable table;
    DefaultTableModel model;
    JPanel form;
    String msg;

    JLabel labelId;
    JLabel labelIdPret;
    JLabel labelNomVersement;
    JLabel labelMontantRembourser;
    JLabel labelDateRemboursement;

    JTextField textFieldId = new JTextField();
    JComboBox<String> comboBoxIdPret = new JComboBox<String>();
    JTextField textFieldNomVersement = new JTextField();
    JTextField textFieldMontantRembourser = new JTextField();
    JDateChooser textFieldDateRemboursement = new JDateChooser();

    TraitementRemboursement traitementRemboursement = new TraitementRemboursement();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    ArrayList<Pret> prets = new TraitementPret().afficher();

    public VueRemboursement() {

        this.setLayout(new BorderLayout());

        //Table
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("ID Pret");
        model.addColumn("Nom Versement");
        model.addColumn("Montant Rembourser");
        model.addColumn("Date Remboursement");

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
                comboBoxIdPret.setSelectedItem(table.getValueAt(table.getSelectedRow(), 1).toString());
                textFieldNomVersement.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
                textFieldMontantRembourser.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
                try {
                    textFieldDateRemboursement.setDate(new Date(sdf.format(new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(table.getSelectedRow(), 5).toString()))));
                } catch (ParseException ex) {
                    Logger.getLogger(VueRemboursement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //Formulaire
        form = new JPanel();
        form.setPreferredSize(new Dimension(0, 250));
        form.setBackground(new Color(0x000030));

        if(!prets.isEmpty()){
            prets = new TraitementPret().afficher();
            
            for (Pret pret : prets) {
                comboBoxIdPret.insertItemAt(String.valueOf(pret.getId()), comboBoxIdPret.getItemCount());
            }
            comboBoxIdPret.setSelectedIndex(0);
        }
        

        form.add(Fonctions.createSelectDiv("ID Pret", comboBoxIdPret));
        form.add(Fonctions.createInputDiv("Nom Versement", textFieldNomVersement, 250, 27));
        form.add(Fonctions.createInputDiv("Montant Rembourser", textFieldMontantRembourser, 250, 27));
        form.add(Fonctions.createCalendarDiv("Date Remboursement", textFieldDateRemboursement, 250, 27));

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
            int id = 0;
            int idPret = Integer.parseInt(comboBoxIdPret.getSelectedItem().toString());
            String nomVersement = textFieldNomVersement.getText();
            float montantRembourser = Float.parseFloat(textFieldMontantRembourser.getText());
            Date dateRemboursement = textFieldDateRemboursement.getDate();

            remboursement = new Remboursement(
                    id,
                    idPret,
                    nomVersement,
                    montantRembourser,
                    dateRemboursement
            );

            traitementRemboursement.enregistrer(remboursement);

            initialize();
            loadDatas();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Supression
    public void supprimer() {
        if (table.getSelectedRow() != -1) {
            traitementRemboursement.supression(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
        } else {
            msg = "Veuillez sélectionner le remboursement à supprimer.";
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
            Logger.getLogger(VueRemboursement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Load Datas
    private void loadDatas() {

        model.setRowCount(0);

        for (Remboursement newRemboursementt : new TraitementRemboursement().afficher()) {
            Object[] data = {
                newRemboursementt.getId(),
                newRemboursementt.getIdPret(),
                newRemboursementt.getNomVersement(),
                newRemboursementt.getMontantRembourser(),
                newRemboursementt.getDateRemboursement()
            };

            model.addRow(data);
        }
    }

    public void initialize() {
        textFieldId.setText("");
        comboBoxIdPret.setSelectedIndex(0);
        textFieldNomVersement.setText("");
        textFieldMontantRembourser.setText("");
        textFieldDateRemboursement.setDate(new Date());
    }
}
