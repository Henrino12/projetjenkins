package com.example.trun.model;

public class Etudiant {
    private int id;
    private String prenom;
    private String nom;
    private String email;
    private String matricule;
    private int id_classe;

    public Etudiant() {
    }

    public Etudiant(int id, String prenom, String nom, String email,int id_classe) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        //this.matricule = matricule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }
}
