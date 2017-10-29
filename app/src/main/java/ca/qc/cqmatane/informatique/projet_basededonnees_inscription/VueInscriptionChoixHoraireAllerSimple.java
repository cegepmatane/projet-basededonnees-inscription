package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Inscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.DepartInscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.VerificationHoraire;

public class VueInscriptionChoixHoraireAllerSimple extends AppCompatActivity {

    protected ListView listeHorairesAllerSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_choix_horaire_aller_simple);

        listeHorairesAllerSimple = (ListView) findViewById(R.id.liste_vue_choix_horaire_aller_simple);

        //Permet de savoir le nom de la cle a recuperer dans le HashMap
        String cleHashMap = "heure";

        listeHorairesAllerSimple.setAdapter(new SimpleAdapter(
                this,
                VerificationHoraire.recupererHoraireEnHashMap(19, 8, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau, cleHashMap),
                R.layout.element_liste_choix_horaire,
                new String[] { cleHashMap },
                new int[] { R.id.action_choix_horaire }
        ));
    }

    public void actionChoixHoraire(View v)
    {
        Button boutonHoraireChoisi = (Button) v;

        for(int i = 0; i < listeHorairesAllerSimple.getChildCount(); i++){
            //On récupère le ConstraintLayout de l'élément de la vue
            ViewGroup elementListeHoraire = (ViewGroup) listeHorairesAllerSimple.getChildAt(i);
            //On récupère ensuite le bouton qu'il contient
            Button boutonListeHoraire = (Button) elementListeHoraire.getChildAt(0);
            //On restore ensuite sa couleur de fond
            boutonListeHoraire.setBackgroundResource(android.R.drawable.btn_default);
        }

        //On marque visuellement le bouton selectionne
        boutonHoraireChoisi.setBackgroundColor(Color.CYAN);

        //On recupere l'horaire selectionné
        String horaireSelectionne = boutonHoraireChoisi.getText().toString();
        //On l'ajoute a l'inscription
        Inscription.getInstance().setHeureAller(horaireSelectionne);
    }

}
