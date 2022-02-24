/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.christna.mydreams.models;

import com.christna.mydreams.traitements.TraitementRemboursement;
import java.util.Date;

/**
 *
 * @author Christna
 */
public class Test {
    public static void main(String[] args) {
        
        TraitementRemboursement tr = new TraitementRemboursement();
       
        Remboursement remboursement = new Remboursement();
        
        remboursement.setIdPret(2);
        remboursement.setNomVersement("Versement2");
        remboursement.setMontantRembourser(3750);
        remboursement.setDateRemboursement(new Date("2022/23/03"));
        
        tr.enregistrer(remboursement);
//        tp.supression(1);

        for (Remboursement newRemboursement : tr.afficher()) {
            System.out.println(newRemboursement.toString());
        }
    }
}
