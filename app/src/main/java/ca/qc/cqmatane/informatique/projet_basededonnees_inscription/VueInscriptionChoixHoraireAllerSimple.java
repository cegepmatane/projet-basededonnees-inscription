package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.DepartInscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.VerificationHoraire;

public class VueInscriptionChoixHoraireAllerSimple extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_choix_horaire_aller_simple);

        ListView listeHorairesAllerSimple = (ListView) findViewById(R.id.liste_vue_choix_horaire_aller_simple);

        //Permet de savoir le nom de la cle a recuperer dans le HashMap
        String cleHashMap = "heure";

        listeHorairesAllerSimple.setAdapter(new SimpleAdapter(
                this,
                VerificationHoraire.recupererHoraireEnHashMap(11, 10, 2017, DepartInscription.Matane, DepartInscription.Godbout, cleHashMap),
                R.layout.element_liste_choix_horaire,
                new String[] { cleHashMap },
                new int[] { R.id.action_choix_horaire }
        ));
    }
}
