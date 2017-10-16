package ca.qc.cqmatane.informatique.projet_basededonnees_inscription.Modele;

/**
 * Created by lucas on 16/10/2017.
 */

public class Personne {

    private int id;
    private int age;
    private boolean accompagnateur;

    public Personne() {
    }

    public Personne(int id, int age, boolean accompagnateur) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAccompagnateur() {
        return accompagnateur;
    }

    public void setAccompagnateur(boolean accompagnateur) {
        this.accompagnateur = accompagnateur;
    }
}
