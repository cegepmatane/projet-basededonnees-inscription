package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Inscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Personne;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Vehicule;

public class VueInscriptionRecapitulatifDesInformations extends AppCompatActivity {

    private Inscription inscription;
    private Personne personne;
    private Vehicule vehicule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_recapitulatif_des_informations);

        inscription = Inscription.getInstance();
        personne = Personne.getInstance();
        vehicule = Vehicule.getInstance();
    }


}
