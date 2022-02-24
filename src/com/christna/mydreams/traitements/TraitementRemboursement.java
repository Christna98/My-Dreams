/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christna.mydreams.traitements;

import com.christna.mydreams.dbutils.Database;
import com.christna.mydreams.models.Remboursement;
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
public class TraitementRemboursement implements InterfaceTraitement<Remboursement> {

    StringBuilder sb = null;
    PreparedStatement pst = null;
    Connection conn = null;
    ResultSet rs = null;

    ArrayList<Remboursement> remboursements = new ArrayList<>();
    Remboursement remboursement = null;

    @Override
    public void enregistrer(Remboursement remboursement) {
        
            sb = new StringBuilder();

            sb.append("INSERT INTO remboursements VALUES(");
            sb.append("?" + ",");
            sb.append("?" + ",");
            sb.append("?" + ",");
            sb.append("?" + ",");
            sb.append("?" + ")");

            conn = Database.getConnection();
            
        try {
            
            pst = conn.prepareStatement(sb.toString());

            pst.setString(1, null);
            pst.setInt(2, remboursement.getIdPret());
            pst.setString(3, remboursement.getNomVersement());
            pst.setFloat(4, remboursement.getMontantRembourser());
            pst.setDate(5, new java.sql.Date(remboursement.getDateRemboursement().getTime()));

            int success = pst.executeUpdate();

            if (success == 1) {
                JOptionPane.showMessageDialog(null, "Enregistrement reussi", "Message", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Enregistrement nonreussi", "Message", JOptionPane.ERROR_MESSAGE);
            }

            if (pst != null) {
                pst.close();
            }

            if (conn != null) {
                conn.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TraitementRemboursement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Remboursement> afficher() {

        remboursements.clear();

        sb = new StringBuilder();
        sb.append("SELECT * FROM remboursements");

        conn = Database.getConnection();

        try {

            pst = conn.prepareStatement(sb.toString());

            rs = pst.executeQuery();

            while (rs.next()) {
                remboursement = new Remboursement();

                remboursement.setId(rs.getInt(1));
                remboursement.setIdPret(rs.getInt(2));
                remboursement.setNomVersement(rs.getString(3));
                remboursement.setMontantRembourser(rs.getFloat(4));
                remboursement.setDateRemboursement(rs.getDate(5));

                remboursements.add(remboursement);
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
            Logger.getLogger(TraitementRemboursement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return remboursements;
    }

    @Override
    public Remboursement rechercher(int id) {

        sb = new StringBuilder();

        sb.append("SELECT * FROM remboursements WHERE id = ?");

        conn = Database.getConnection();
        try {
            pst = conn.prepareStatement(sb.toString());

            pst.setInt(1, id);

            rs = pst.executeQuery();

            if (rs.next()) {
                remboursement = new Remboursement();

                remboursement.setId(rs.getInt(1));
                remboursement.setIdPret(rs.getInt(2));
                remboursement.setNomVersement(rs.getString(3));
                remboursement.setMontantRembourser(rs.getFloat(4));
                remboursement.setDateRemboursement(rs.getDate(5));

            }
        } catch (SQLException ex) {
            Logger.getLogger(TraitementRemboursement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return remboursement;
    }

    @Override
    public void modifier(Remboursement t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void supression(int id) {

        sb = new StringBuilder();
        sb.append("DELETE FROM remboursements WHERE id = ?");

        conn = Database.getConnection();

        try {
            pst = conn.prepareStatement(sb.toString());

            pst.setInt(1, id);

            int rep = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer ce produit", "Message", JOptionPane.YES_NO_OPTION);

            if (rep == JOptionPane.YES_OPTION) {

                int success = pst.executeUpdate();

                if (success == 1) {
                    JOptionPane.showMessageDialog(null, "Suppression reussie", "Message", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Suppression non reussie", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TraitementRemboursement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
