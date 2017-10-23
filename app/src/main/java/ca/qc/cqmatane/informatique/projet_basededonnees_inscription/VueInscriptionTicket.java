package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Inscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Personne;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.TypeInscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Vehicule;


public class VueInscriptionTicket extends AppCompatActivity {
    private Inscription inscription;

    private float prixTotalFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_ticket);
        inscription = Inscription.getInstance();
    }

    /**
     * Calcule le prix total du billet
     * @return le prix du billet
     */
    private void calculerPrixBillet() {
        calculerPrixParPersonne();
    }

    /**
     * Calcule si il y a un pourcentage de rabais
     */
    private float calculerLeRabais() {
        float rabais;
        if(inscription.getListePersonnes().size() >= 15 && inscription.getListePersonnes().size() <= 30)
            rabais = 10;
        else if(inscription.getListePersonnes().size() >= 31)
            rabais = 15;
        else
            rabais = 0;
        return rabais;
    }

    /**
     * Calcule le prix de chaque personne et l'ajoute au prix finale
     */
    private void calculerPrixParPersonne() {
        for(Personne personneCourante : inscription.getListePersonnes()) {
            if (inscription.getType() == TypeInscription.AllerSimple) {
                if(personneCourante.getAge() >= 0 && personneCourante.getAge() <= 4)
                    prixTotalFinal += 0;
                else if(personneCourante.getAge() >= 5 && personneCourante.getAge() <= 15)
                    prixTotalFinal += 12.20;
                else if(personneCourante.getAge() >= 16 && personneCourante.getAge() <= 64)
                    prixTotalFinal += 19.85;
                else if(personneCourante.getAge() >= 65)
                    prixTotalFinal += 16.80;
            }

            if (inscription.getType() == TypeInscription.AllerRetour) {
                if(personneCourante.getAge() >= 0 && personneCourante.getAge() <= 4)
                    prixTotalFinal += 0;
                else if(personneCourante.getAge() >= 5 && personneCourante.getAge() <= 15)
                    prixTotalFinal += 20;
                else if(personneCourante.getAge() >= 16 && personneCourante.getAge() <= 64)
                    prixTotalFinal += 32;
                else if(personneCourante.getAge() >= 65)
                    prixTotalFinal += 27;
            }
        }
    }

    private void calculerPrixParVehicule() {
        for(Vehicule vehiculeCourant : inscription.getListeVehicules()) {
            if(vehiculeCourant.getType() == ) {
                if (vehiculeCourant.getLongueur() <= )
            }
        }
    }



}
