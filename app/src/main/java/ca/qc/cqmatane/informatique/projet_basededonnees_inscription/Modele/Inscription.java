package ca.qc.cqmatane.informatique.projet_basededonnees_inscription.Modele;

import java.util.ArrayList;

/**
 * Created by lucas on 16/10/2017.
 */

public class Inscription {

    private int numeroInscription;
    private String nom;
    private String type;
    private ArrayList<Personne> listePersonnes;
    private ArrayList<Vehicule> listeVehicules;
    private String date;
    private String heure;
    private double prix;

    private static Inscription instance;

    public static Inscription getInstance(){
        if(instance == null)instance = new Inscription();
        return instance;
    }

    public Inscription() {
    }

    public int getNumeroInscription() {
        return numeroInscription;
    }

    public void setNumeroInscription(int numeroInscription) {
        this.numeroInscription = numeroInscription;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Personne> getListePersonnes() {
        return listePersonnes;
    }

    public void setListePersonnes(ArrayList<Personne> listePersonnes) {
        this.listePersonnes = listePersonnes;
    }

    public ArrayList<Vehicule> getListeVehicules() {
        return listeVehicules;
    }

    public void setListeVehicules(ArrayList<Vehicule> listeVehicules) {
        this.listeVehicules = listeVehicules;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
