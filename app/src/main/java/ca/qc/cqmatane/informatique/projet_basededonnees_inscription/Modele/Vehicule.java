package ca.qc.cqmatane.informatique.projet_basededonnees_inscription.Modele;

/**
 * Created by lucas on 16/10/2017.
 */

public class Vehicule {

    private int id;
    private String type;
    private double largeur;
    private double longueur;

    private static Vehicule instance;

    public static Vehicule getInstance(){
        if(instance == null)instance = new Vehicule();
        return instance;
    }

    public Vehicule(){}

    public Vehicule(int id, String type, double largeur, double longueur) {
        this.id = id;
        this.type = type;
        this.largeur = largeur;
        this.longueur = longueur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }
}
