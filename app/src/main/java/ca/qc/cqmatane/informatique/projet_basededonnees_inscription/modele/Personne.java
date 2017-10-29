package ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.TrancheAge;

/**
 * Created by lucas on 16/10/2017.
 */

public class Personne {

    private int id;
    private TrancheAge age;
    private boolean accompagnateur;

    private static Personne instance;

    public static Personne getInstance(){
        if(instance == null)instance = new Personne();
        return instance;
    }

    public Personne() {
    }

    public Personne(int id, TrancheAge age, boolean accompagnateur) {
        this.id = id;
        this.age = age;
        this.accompagnateur = accompagnateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TrancheAge getAge() {
        return age;
    }

    public void setAge(TrancheAge age) {
        this.age = age;
    }

    public boolean isAccompagnateur() {
        return accompagnateur;
    }

    public void setAccompagnateur(boolean accompagnateur) {
        this.accompagnateur = accompagnateur;
    }
}
