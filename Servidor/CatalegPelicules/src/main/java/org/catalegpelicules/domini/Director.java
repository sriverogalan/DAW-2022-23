package org.catalegpelicules.domini;

public class Director {
    private int id;
    private String nom;
    private String cognom;

    public Director(int id, String nom, String cognom) {
        this.nom = nom;
        this.cognom = cognom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    @Override
    public String toString() {
        return  "| Director " +
                "| nom='" + nom + '\'' +
                "| cognom='" + cognom + '\'' +
                '|' ;
    }
}
