/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christna.mydreams.traitements;

import com.christna.mydreams.dbutils.Database;
import com.christna.mydreams.models.Entreprise;
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
public class TraitementEntreprise implements InterfaceTraitement<Entreprise> {

    StringBuilder sb = null;
    PreparedStatement pst = null;
    Connection conn = null;
    ResultSet rs = null;

    ArrayList<Entreprise> entreprises = new ArrayList<>();
    Entreprise entreprise = null;

    @Override
    public void enregistrer(Entreprise entreprise) {

        sb = new StringBuilder();
        sb.append("INSERT INTO entreprises VALUES(");
        sb.append("?" + ",");
        sb.append("?" + ",");
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
            pst.setInt(2, entreprise.getIdGroupe());
            pst.setString(3, entreprise.getNomEntreprise());
            pst.setString(4, entreprise.getNomProprietaire());
            pst.setString(5, entreprise.getPrenomProprietaire());
            pst.setString(6, String.valueOf(entreprise.getSexe()));
            pst.setString(7, entreprise.getAdresse());
            pst.setString(8, entreprise.getTelephone());
            pst.setString(9, entreprise.getTypePieceProprietaire());
            pst.setInt(10, entreprise.getNoPieceProprietaire());
            pst.setDate(11, new java.sql.Date(entreprise.getDateCreation().getTime()));
            pst.setString(12, entreprise.getDescription());

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
            Logger.getLogger(TraitementEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Entreprise> afficher() {
        entreprises.clear();

        sb = new StringBuilder();
        sb.append("SELECT * FROM entreprises");

        try {

            conn = Database.getConnection();

            pst = conn.prepareStatement(sb.toString());

            rs = pst.executeQuery();

            while (rs.next()) {
                entreprise = new Entreprise();

                entreprise.setId(rs.getInt(1));
                entreprise.setIdGroupe(rs.getInt(2));
                entreprise.setNomEntreprise(rs.getString(3));
                entreprise.setNomProprietaire(rs.getString(4));
                entreprise.setPrenomProprietaire(rs.getString(5));
                entreprise.setSexe(rs.getString(6).charAt(0));
                entreprise.setAdresse(rs.getString(7));
                entreprise.setTelephone(rs.getString(8));
                entreprise.setTypePieceProprietaire(rs.getString(9));
                entreprise.setNoPieceProprietaire(rs.getInt(10));
                entreprise.setDateCreation(rs.getDate(11));
                entreprise.setDescription(rs.getString(12));

                entreprises.add(entreprise);
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
            Logger.getLogger(TraitementEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entreprises;
    }

    @Override
    public Entreprise rechercher(int id) {

        sb = new StringBuilder();
        sb.append("SELECT * FROM entreprises WHERE id = ?");

        try {

            conn = Database.getConnection();

            pst = conn.prepareStatement(sb.toString());

            pst.setInt(1, id);

            rs = pst.executeQuery();

            if (rs.next()) {
                entreprise = new Entreprise();

                entreprise.setId(rs.getInt(1));
                entreprise.setIdGroupe(rs.getInt(2));
                entreprise.setNomEntreprise(rs.getString(3));
                entreprise.setNomProprietaire(rs.getString(4));
                entreprise.setPrenomProprietaire(rs.getString(5));
                entreprise.setSexe(rs.getString(6).charAt(0));
                entreprise.setAdresse(rs.getString(7));
                entreprise.setTelephone(rs.getString(8));
                entreprise.setTypePieceProprietaire(rs.getString(9));
                entreprise.setNoPieceProprietaire(rs.getInt(10));
                entreprise.setDateCreation(rs.getDate(11));
                entreprise.setDescription(rs.getString(12));
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
            Logger.getLogger(TraitementEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entreprise;
    }

    @Override
    public void modifier(Entreprise entreprise) {
        sb = new StringBuilder();
        sb.append("UPDATE entreprises SET ");
        sb.append("idGroupe = ?" + ",");
        sb.append("nomEntreprise = ?" + ",");
        sb.append("nomProprietaire = ?" + ",");
        sb.append("prenomProprietaire = ?" + ",");
        sb.append("sexe = ?" + ",");
        sb.append("adresse = ?" + ",");
        sb.append("telephone = ?" + ",");
        sb.append("typePieceProprietaire = ?" + ",");
        sb.append("noPieceProprietaire = ?" + ",");
        sb.append("dateCreation = ?" + ",");
        sb.append("description = ?");
        sb.append(" WHERE id = ?");

        conn = Database.getConnection();

        try {
            pst = conn.prepareStatement(sb.toString());

            pst.setInt(1, entreprise.getIdGroupe());
            pst.setString(2, entreprise.getNomEntreprise());
            pst.setString(3, entreprise.getNomProprietaire());
            pst.setString(4, entreprise.getPrenomProprietaire());
            pst.setString(5, String.valueOf(entreprise.getSexe()));
            pst.setString(6, entreprise.getAdresse());
            pst.setString(7, entreprise.getTelephone());
            pst.setString(8, entreprise.getTypePieceProprietaire());
            pst.setInt(9, entreprise.getNoPieceProprietaire());
            pst.setDate(10, new java.sql.Date(entreprise.getDateCreation().getTime()));
            pst.setString(11, entreprise.getDescription());
            pst.setInt(12, entreprise.getId());

            int success = pst.executeUpdate();

            if (success == 1) {
                JOptionPane.showMessageDialog(null, "Modification reussie", "Message", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Modification non reussie", "Message", JOptionPane.ERROR_MESSAGE);

            }

            if (pst != null) {
                pst.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TraitementEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void supression(int id) {
        sb = new StringBuilder();
        sb.append("DELETE FROM entreprises ");
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
            Logger.getLogger(TraitementEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
