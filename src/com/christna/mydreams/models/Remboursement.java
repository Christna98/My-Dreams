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
public class Remboursement {

    private int id;
    private int idPret;
    private String nomVersement;
    private float montantRembourser;
    private Date dateRemboursement;

    public Remboursement() {
    }

    public Remboursement(int id, int idPret, String nomVersement, float montantRembourser, Date dateRemboursement) {
        this.id = id;
        this.idPret = idPret;
        this.nomVersement = nomVersement;
        this.montantRembourser = montantRembourser;
        this.dateRemboursement = dateRemboursement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPret() {
        return idPret;
    }

    public void setIdPret(int idPret) {
        this.idPret = idPret;
    }

    public String getNomVersement() {
        return nomVersement;
    }

    public void setNomVersement(String nomVersement) {
        this.nomVersement = nomVersement;
    }

    public float getMontantRembourser() {
        return montantRembourser;
    }

    public void setMontantRembourser(float montantRembourser) {
        this.montantRembourser = montantRembourser;
    }

    public Date getDateRemboursement() {
        return dateRemboursement;
    }

    public void setDateRemboursement(Date dateRemboursement) {
        this.dateRemboursement = dateRemboursement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Remboursement{");
        sb.append("id=").append(id);
        sb.append(", idPret=").append(idPret);
        sb.append(", nomVersement=").append(nomVersement);
        sb.append(", montantRembourser=").append(montantRembourser);
        sb.append(", dateRemboursement=").append(dateRemboursement);
        sb.append('}');
        return sb.toString();
    }
}
