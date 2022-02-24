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
public class Pret {

    private int id;
    private int idGroupe;
    private float montantEmprunte;
    private float interet;
    private float versementMensuel;
    private Date datePret;
    private Date dateVersement1;
    private Date dateVersement2;
    private Date dateVersement3;
    private Date dateVersement4;

    public Pret() {
    }

    public Pret(int id, int idGroupe, float montantEmprunte, float interet, float versementMensuel, Date datePret, Date dateVersement1, Date dateVersement2, Date dateVersement3, Date dateVersement4) {
        this.id = id;
        this.idGroupe = idGroupe;
        this.montantEmprunte = montantEmprunte;
        this.interet = interet;
        this.versementMensuel = versementMensuel;
        this.datePret = datePret;
        this.dateVersement1 = dateVersement1;
        this.dateVersement2 = dateVersement2;
        this.dateVersement3 = dateVersement3;
        this.dateVersement4 = dateVersement4;
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

    public float getMontantEmprunte() {
        return montantEmprunte;
    }

    public void setMontantEmprunte(float montantEmprunte) {
        this.montantEmprunte = montantEmprunte;
    }

    public float getInteret() {
        return interet;
    }

    public void setInteret(float interet) {
        this.interet = interet;
    }

    public float getVersementMensuel() {
        return versementMensuel;
    }

    public void setVersementMensuel(float versementMensuel) {
        this.versementMensuel = versementMensuel;
    }

    public Date getDatePret() {
        return datePret;
    }

    public void setDatePret(Date datePret) {
        this.datePret = datePret;
    }

    public Date getDateVersement1() {
        return dateVersement1;
    }

    public void setDateVersement1(Date dateVersement1) {
        this.dateVersement1 = dateVersement1;
    }

    public Date getDateVersement2() {
        return dateVersement2;
    }

    public void setDateVersement2(Date dateVersement2) {
        this.dateVersement2 = dateVersement2;
    }

    public Date getDateVersement3() {
        return dateVersement3;
    }

    public void setDateVersement3(Date dateVersement3) {
        this.dateVersement3 = dateVersement3;
    }

    public Date getDateVersement4() {
        return dateVersement4;
    }

    public void setDateVersement4(Date dateVersement4) {
        this.dateVersement4 = dateVersement4;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pret{");
        sb.append("id=").append(id);
        sb.append(", idGroupe=").append(idGroupe);
        sb.append(", montantEmprunte=").append(montantEmprunte);
        sb.append(", interet=").append(interet);
        sb.append(", versementMensuel=").append(versementMensuel);
        sb.append(", datePret=").append(datePret);
        sb.append(", dateVersement1=").append(dateVersement1);
        sb.append(", dateVersement2=").append(dateVersement2);
        sb.append(", dateVersement3=").append(dateVersement3);
        sb.append(", dateVersement4=").append(dateVersement4);
        sb.append('}');
        return sb.toString();
    }
}
