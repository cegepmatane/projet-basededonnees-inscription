package ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outil.TypeVehicule;

/**
 * Created by lucas on 16/10/2017.
 */

public class Vehicule {

    private int id;
    private TypeVehicule type;
    private double largeur;
    private double longueur;

    private static Vehicule instance;

    public static Vehicule getInstance(){
        if(instance == null)instance = new Vehicule();
        return instance;
    }

    public Vehicule(){}

    public Vehicule(int id, TypeVehicule type, double largeur, double longueur) {
        this.id = id;
        this.type = type;
        this.largeur = largeur;
        this.longueur = longueur;
    }

    public Vehicule(TypeVehicule type, double largeur, double longueur) {
        this.type = type;
        this.largeur = largeur;
        this.longueur = longueur;
    }

    public Vehicule(TypeVehicule type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeVehicule getType() {
        return type;
    }

    public void setType(TypeVehicule type) {
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
