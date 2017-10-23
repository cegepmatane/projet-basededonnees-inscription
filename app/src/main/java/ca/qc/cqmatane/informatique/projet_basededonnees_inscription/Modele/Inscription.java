package ca.qc.cqmatane.informatique.projet_basededonnees_inscription.Modele;

import java.util.ArrayList;

/**
 * Created by lucas on 16/10/2017.
 */

public class Inscription {

    private int numeroInscription;
    private String nom;
    private TypeInscription type;
    private ArrayList<Personne> listePersonnes;
    private ArrayList<Vehicule> listeVehicules;
    private String destination;
    private String dateAller;
    private String dateRetour;
    private String heureAller;
    private String heureRetour;
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

    public TypeInscription getType() {
        return type;
    }

    public void setType(TypeInscription type) {
        this.type = type;
    }

    public static void setInstance(Inscription instance) {
        Inscription.instance = instance;
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

    public String getDateAller() {
        return dateAller;
    }

    public void setDateAller(String dateAller) {
        this.dateAller = dateAller;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }

    public String getHeureAller() {
        return heureAller;
    }

    public void setHeureAller(String heureAller) {
        this.heureAller = heureAller;
    }

    public String getHeureRetour() {
        return heureRetour;
    }

    public void setHeureRetour(String heureRetour) {
        this.heureRetour = heureRetour;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
