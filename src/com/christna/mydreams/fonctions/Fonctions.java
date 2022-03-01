/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christna.mydreams.fonctions;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Christna
 */
public class Fonctions {

    public static JPanel createSelectDiv(String labelText, JComboBox<String> jcomboBox) {

        JPanel inputDiv = new JPanel();

        inputDiv.setBackground(new Color(0x000021));
        inputDiv.setPreferredSize(new Dimension(250, 70));

        JLabel label = new JLabel(labelText);
        label.setForeground(new Color(0xFFFFFF));

        jcomboBox.setPreferredSize(new Dimension(250, 27));

        inputDiv.add(label);
        inputDiv.add(jcomboBox);

        return inputDiv;
    }

    public static JPanel createInputDiv(String labelText, JTextField textField, int l, int h) {

        JPanel inputDiv = new JPanel();

        inputDiv.setBackground(new Color(0x000021));
        inputDiv.setPreferredSize(new Dimension(250, 70));

        JLabel label = new JLabel(labelText);
        label.setForeground(new Color(0xFFFFFF));

        textField.setPreferredSize(new Dimension(l, h));

        inputDiv.add(label);
        inputDiv.add(textField);

        return inputDiv;
    }

    public static JPanel createCalendarDiv(String labelText, JDateChooser textFieldDateCreation, int l, int h) {
        JPanel inputDiv = new JPanel();

        inputDiv.setBackground(new Color(0x000021));
        inputDiv.setPreferredSize(new Dimension(250, 70));

        JLabel label = new JLabel(labelText);
        label.setForeground(new Color(0xFFFFFF));

        textFieldDateCreation.setPreferredSize(new Dimension(l, h));
        textFieldDateCreation.setMaxSelectableDate(new Date());
        textFieldDateCreation.setDate(new Date());
        textFieldDateCreation.setDateFormatString(new SimpleDateFormat("dd/MM/yyyy").toPattern());
        textFieldDateCreation.getDateEditor().setEnabled(false);

        inputDiv.add(label);
        inputDiv.add(textFieldDateCreation);

        return inputDiv;
    }
}
