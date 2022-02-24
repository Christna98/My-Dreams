/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christna.mydreams.traitements;

import com.christna.mydreams.dbutils.Database;
import com.christna.mydreams.models.Pret;
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
public class TraitementPret implements InterfaceTraitement<Pret> {

    StringBuilder sb = null;
    PreparedStatement pst = null;
    Connection conn = null;
    ResultSet rs = null;

    ArrayList<Pret> prets = new ArrayList<>();
    Pret pret = null;

    @Override
    public void enregistrer(Pret pret) {

        sb = new StringBuilder();

        sb.append("INSERT INTO prets VALUES(");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ")");

        conn = Database.getConnection();

        try {
            pst = conn.prepareStatement(sb.toString());

            pst.setString(1, null);
            pst.setInt(2, pret.getIdGroupe());
            pst.setFloat(3, pret.getMontantEmprunte());
            pst.setFloat(4, pret.getInteret());
            pst.setFloat(5, pret.getVersementMensuel());
            pst.setDate(6, new java.sql.Date(pret.getDatePret().getTime()));
            pst.setDate(7, new java.sql.Date(pret.getDateVersement1().getTime()));
            pst.setDate(8, new java.sql.Date(pret.getDateVersement2().getTime()));
            pst.setDate(9, new java.sql.Date(pret.getDateVersement3().getTime()));
            pst.setDate(10, new java.sql.Date(pret.getDateVersement4().getTime()));

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
            Logger.getLogger(TraitementPret.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Pret> afficher() {
        prets.clear();

        sb = new StringBuilder();
        sb.append("SELECT * FROM prets");

        try {
            conn = Database.getConnection();

            pst = conn.prepareStatement(sb.toString());

            rs = pst.executeQuery();

            while (rs.next()) {
                pret = new Pret();

                pret.setId(rs.getInt(1));
                pret.setIdGroupe(rs.getInt(2));
                pret.setMontantEmprunte(rs.getFloat(3));
                pret.setInteret(rs.getFloat(4));
                pret.setVersementMensuel(rs.getFloat(5));
                pret.setDatePret(rs.getDate(6));
                pret.setDateVersement1(rs.getDate(7));
                pret.setDateVersement2(rs.getDate(8));
                pret.setDateVersement3(rs.getDate(9));
                pret.setDateVersement4(rs.getDate(10));

                prets.add(pret);
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
            Logger.getLogger(TraitementPret.class.getName()).log(Level.SEVERE, null, ex);
        }

        return prets;
    }

    @Override
    public Pret rechercher(int id) {

        sb = new StringBuilder();

        sb.append("SELECT * FROM prets WHERE id = ?");

        conn = Database.getConnection();

        try {

            pst = conn.prepareStatement(sb.toString());

            pst.setInt(1, id);

            rs = pst.executeQuery();

            if (rs.next()) {
                pret = new Pret();

                pret.setId(rs.getInt(1));
                pret.setIdGroupe(rs.getInt(2));
                pret.setMontantEmprunte(rs.getFloat(3));
                pret.setInteret(rs.getFloat(4));
                pret.setVersementMensuel(rs.getFloat(5));
                pret.setDatePret(rs.getDate(6));
                pret.setDateVersement1(rs.getDate(7));
                pret.setDateVersement2(rs.getDate(8));
                pret.setDateVersement3(rs.getDate(9));
                pret.setDateVersement4(rs.getDate(10));
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
            Logger.getLogger(TraitementPret.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pret;
    }

    @Override
    public void modifier(Pret t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void supression(int id) {
        
        sb = new StringBuilder();
        sb.append("DELETE FROM prets ");
        sb.append("WHERE id = ?");
        conn = Database.getConnection();

        try {
            
            pst = conn.prepareStatement(sb.toString());

            pst.setInt(1, id);

            int rep = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer ce produit", "Message", JOptionPane.YES_NO_OPTION);

            if (rep == JOptionPane.YES_OPTION) {
                
                int n = pst.executeUpdate();

                if (n == 1) {
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
            Logger.getLogger(TraitementPret.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
