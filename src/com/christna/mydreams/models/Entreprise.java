/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christna.mydreams.models;

import java.util.Date;

/**
 *
 * @author Christna
 */
public class Entreprise {

    private int id;
    private int idGroupe;
    private String nomEntreprise;
    private String nomProprietaire;
    private String prenomProprietaire;
    private char sexe;
    private String adresse;
    private String telephone;
    private String typePieceProprietaire;
    private int noPieceProprietaire;
    private Date dateCreation;
    private String description;

    public Entreprise() {
    }

    public Entreprise(int id, int idGroupe, String nomEntreprise, String nomProprietaire, String prenomEntreprise, char sexe, String adresse, String telephone, String typePieceProprietaire, int noPieceProprietaire, Date dateCreation, String description) {
        this.id = id;
        this.idGroupe = idGroupe;
        this.nomEntreprise = nomEntreprise;
        this.nomProprietaire = nomProprietaire;
        this.prenomProprietaire = prenomEntreprise;
        this.sexe = sexe;
        this.adresse = adresse;
        this.telephone = telephone;
        this.typePieceProprietaire = typePieceProprietaire;
        this.noPieceProprietaire = noPieceProprietaire;
        this.dateCreation = dateCreation;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getNomProprietaire() {
        return nomProprietaire;
    }

    public void setNomProprietaire(String nomProprietaire) {
        this.nomProprietaire = nomProprietaire;
    }

    public String getPrenomProprietaire() {
        return prenomProprietaire;
    }

    public void setPrenomProprietaire(String prenomProprietaire) {
        this.prenomProprietaire = prenomProprietaire;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTypePieceProprietaire() {
        return typePieceProprietaire;
    }

    public void setTypePieceProprietaire(String typePieceProprietaire) {
        this.typePieceProprietaire = typePieceProprietaire;
    }

    public int getNoPieceProprietaire() {
        return noPieceProprietaire;
    }

    public void setNoPieceProprietaire(int noPieceProprietaire) {
        this.noPieceProprietaire = noPieceProprietaire;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Entreprise{");
        sb.append("id=").append(id);
        sb.append(", idGroupe=").append(idGroupe);
        sb.append(", nomEntreprise=").append(nomEntreprise);
        sb.append(", nomProprietaire=").append(nomProprietaire);
        sb.append(", prenomProprietaire=").append(prenomProprietaire);
        sb.append(", sexe=").append(sexe);
        sb.append(", adresse=").append(adresse);
        sb.append(", telephone=").append(telephone);
        sb.append(", typePieceProprietaire=").append(typePieceProprietaire);
        sb.append(", noPieceProprietaire=").append(noPieceProprietaire);
        sb.append(", dateCreation=").append(dateCreation);
        sb.append(", description=").append(description);
        sb.append("}");

        return sb.toString();
    }
}
