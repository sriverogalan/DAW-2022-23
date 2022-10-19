package org.catalegpelicules.domini;

public class Genere {
    private int id;
    private String nom;

    public Genere(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Genere(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Genere{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
