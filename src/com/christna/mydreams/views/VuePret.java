/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christna.mydreams.views;

import com.christna.mydreams.fonctions.Fonctions;
import com.christna.mydreams.models.Pret;
import com.christna.mydreams.traitements.TraitementPret;
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
public class VuePret extends JPanel {

    Pret pret;
    JTable table;
    DefaultTableModel model;
    JPanel form;
    String msg;

    JLabel labelId;
    JLabel labelIdGroupe;
    JLabel labelMontantEmprunte;
    JLabel labelInteret;
    JLabel labelVersementMensuel;
    JLabel labelDatePret;
    JLabel labelDateVersement1;
    JLabel labelDateVersement2;
    JLabel labelDateVersement3;
    JLabel labelDateVersement4;

    JTextField textFieldId = new JTextField();
    JComboBox<String> comboBoxIdGroupe = new JComboBox<String>();
    JTextField textFieldMontantEmprunte = new JTextField();
    JTextField textFieldInteret = new JTextField();
    JTextField textFieldVersementMensuel = new JTextField();
    JDateChooser textFieldDatePret = new JDateChooser();
    JDateChooser textFieldDateVersement1 = new JDateChooser();
    JDateChooser textFieldDateVersement2 = new JDateChooser();
    JDateChooser textFieldDateVersement3 = new JDateChooser();
    JDateChooser textFieldDateVersement4 = new JDateChooser();

    TraitementPret traitementPret = new TraitementPret();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    public VuePret() {

        this.setLayout(new BorderLayout());

        //Table
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("ID Groupe");
        model.addColumn("Montant Emprunte");
        model.addColumn("Interet");
        model.addColumn("Versement Mensuel");
        model.addColumn("Date Pret");
        model.addColumn("Date Versement 1");
        model.addColumn("Date Versement 2");
        model.addColumn("Date Versement 3");
        model.addColumn("Date Versement 4");

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
                textFieldMontantEmprunte.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
                textFieldInteret.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
                textFieldVersementMensuel.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
                try {
                    textFieldDatePret.setDate(new Date(sdf.format(new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(table.getSelectedRow(), 5).toString()))));
                    textFieldDateVersement1.setDate(new Date(sdf.format(new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(table.getSelectedRow(), 6).toString()))));
                    textFieldDateVersement2.setDate(new Date(sdf.format(new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(table.getSelectedRow(), 7).toString()))));
                    textFieldDateVersement3.setDate(new Date(sdf.format(new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(table.getSelectedRow(), 8).toString()))));
                    textFieldDateVersement4.setDate(new Date(sdf.format(new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(table.getSelectedRow(), 9).toString()))));
                } catch (ParseException ex) {
                    Logger.getLogger(VuePret.class.getName()).log(Level.SEVERE, null, ex);
                }
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

        form.add(Fonctions.createSelectDiv("ID Groupe", comboBoxIdGroupe));
        form.add(Fonctions.createInputDiv("Montant Emprunte", textFieldMontantEmprunte, 250, 27));
        form.add(Fonctions.createInputDiv("Interet", textFieldInteret, 250, 27));
        form.add(Fonctions.createInputDiv("Versement Mensuel", textFieldVersementMensuel, 250, 27));
        form.add(Fonctions.createCalendarDiv("Date Pret", textFieldDatePret, 250, 27));
        form.add(Fonctions.createCalendarDiv("Date Versement 1", textFieldDateVersement1, 250, 27));
        form.add(Fonctions.createCalendarDiv("Date Versement 2", textFieldDateVersement2, 250, 27));
        form.add(Fonctions.createCalendarDiv("Date Versement 3", textFieldDateVersement3, 250, 27));
        form.add(Fonctions.createCalendarDiv("Date Versement 4", textFieldDateVersement4, 250, 27));

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
            int idGroupe = Integer.parseInt(comboBoxIdGroupe.getSelectedItem().toString());
            float montantEmprunte = Float.parseFloat(textFieldMontantEmprunte.getText());
            float interet = Float.parseFloat(textFieldInteret.getText());
            float versementMensuel = Float.parseFloat(textFieldVersementMensuel.getText());
            Date datePret = textFieldDatePret.getDate();
            Date dateVersement1 = textFieldDateVersement1.getDate();
            Date dateVersement2 = textFieldDateVersement2.getDate();
            Date dateVersement3 = textFieldDateVersement3.getDate();
            Date dateVersement4 = textFieldDateVersement4.getDate();

            pret = new Pret(
                    id,
                    idGroupe,
                    montantEmprunte,
                    interet,
                    versementMensuel,
                    datePret,
                    dateVersement1,
                    dateVersement2,
                    dateVersement3,
                    dateVersement4
            );

            traitementPret.enregistrer(pret);
            
            initialize();
            loadDatas();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Supression
    public void supprimer() {
        if (table.getSelectedRow() != -1) {
            traitementPret.supression(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
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
            Logger.getLogger(VuePret.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Load Datas
    private void loadDatas() {

        model.setRowCount(0);

        for (Pret newPret : new TraitementPret().afficher()) {
            Object[] data = {
                newPret.getId(),
                newPret.getIdGroupe(),
                newPret.getMontantEmprunte(),
                newPret.getInteret(),
                newPret.getVersementMensuel(),
                newPret.getDatePret(),
                newPret.getDateVersement1(),
                newPret.getDateVersement2(),
                newPret.getDateVersement3(),
                newPret.getDateVersement4()
            };

            model.addRow(data);
        }
    }

    public void initialize() {
        textFieldId.setText("");
        comboBoxIdGroupe.setSelectedIndex(0);
        textFieldMontantEmprunte.setText("");
        textFieldInteret.setText("");
        textFieldVersementMensuel.setText("");
        textFieldDatePret.setDate(new Date());
        textFieldDateVersement1.setDate(new Date());
        textFieldDateVersement2.setDate(new Date());
        textFieldDateVersement3.setDate(new Date());
        textFieldDateVersement4.setDate(new Date());
    }
}
