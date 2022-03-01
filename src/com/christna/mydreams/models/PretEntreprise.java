/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christna.mydreams.models;

/**
 *
 * @author Christna
 */
public class PretEntreprise {

    private int id;
    private int idGroupe;
    private float montantEmprunte;

    public PretEntreprise() {
    }

    public PretEntreprise(int id, int idGroupe, float montantEmprunte) {
        this.id = id;
        this.idGroupe = idGroupe;
        this.montantEmprunte = montantEmprunte;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PretEntreprise{");
        sb.append("id=").append(id);
        sb.append(", idGroupe=").append(idGroupe);
        sb.append(", montantEmprunte=").append(montantEmprunte);
        sb.append('}');
        return sb.toString();
    }
}
