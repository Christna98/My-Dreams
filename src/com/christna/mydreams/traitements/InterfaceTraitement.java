/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.christna.mydreams.traitements;

import java.util.ArrayList;

/**
 *
 * @author Christna
 * @param <T>
 */
public interface InterfaceTraitement<T> {
    public void enregistrer(T t);
    public ArrayList<T> afficher();
    public T rechercher(int id);
    public void modifier(T t);
    public void supression(int id);
}
