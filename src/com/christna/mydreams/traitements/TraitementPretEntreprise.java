/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christna.mydreams.traitements;

import com.christna.mydreams.dbutils.Database;
import com.christna.mydreams.models.PretEntreprise;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Christna
 */
public class TraitementPretEntreprise implements InterfaceTraitement<PretEntreprise> {

    StringBuilder sb = null;
    PreparedStatement pst = null;
    Connection conn = null;
    ResultSet rs = null;

    ArrayList<PretEntreprise> pretEntreprises = new ArrayList<PretEntreprise>();
    PretEntreprise pretEntreprise = null;

    @Override
    public void enregistrer(PretEntreprise pretEntreprise) {
        sb = new StringBuilder();

        sb.append("INSERT INTO pretEntreprises VALUES(");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ")");

        conn = Database.getConnection();

        try {
            pst = conn.prepareStatement(sb.toString());

            pst.setString(1, null);
            pst.setInt(2, pretEntreprise.getId());
            pst.setInt(3, pretEntreprise.getIdGroupe());
            pst.setFloat(4, pretEntreprise.getMontantEmprunte());

            int success = pst.executeUpdate();

            if (success == 1) {
                JOptionPane.showMessageDialog(null, "Enregistrement reussi", "Message", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Enregistrement non reussi", "Message", JOptionPane.ERROR_MESSAGE);
            }

            if (pst != null) {
                pst.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TraitementPretEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<PretEntreprise> afficher() {

        pretEntreprises.clear();

        sb = new StringBuilder();
        sb.append("SELECT * FROM pretEntreprises");

        conn = Database.getConnection();

        try {
            pst = conn.prepareStatement(sb.toString());

            rs = pst.executeQuery();

            while (rs.next()) {
                pretEntreprise = new PretEntreprise();

                pretEntreprise.setId(rs.getInt(2));
                pretEntreprise.setIdGroupe(rs.getInt(3));
                pretEntreprise.setMontantEmprunte(rs.getFloat(4));

                pretEntreprises.add(pretEntreprise);
            }

            if (rs != null) {
                rs.close();
            }

            if (pst != null) {
                pst.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TraitementPretEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pretEntreprises;
    }

    @Override
    public PretEntreprise rechercher(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modifier(PretEntreprise pretEntreprise) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void supression(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
