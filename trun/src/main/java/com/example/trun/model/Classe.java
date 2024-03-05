package com.example.trun.model;

import javafx.collections.ObservableList;

public class Classe {
    private int id;
    private String libelle;
    private int nombreetudiant;

    public Classe() {
    }

    public Classe(int id, String libelle, int nombreetudiant) {
        this.id = id;
        this.libelle = libelle;
        this.nombreetudiant = nombreetudiant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNombreetudiant() {
        return nombreetudiant;
    }

    public void setNombreetudiant(int nombreetudiant) {
        this.nombreetudiant = nombreetudiant;
    }

    @Override
    public String toString() {
        return libelle ;
    }
}
