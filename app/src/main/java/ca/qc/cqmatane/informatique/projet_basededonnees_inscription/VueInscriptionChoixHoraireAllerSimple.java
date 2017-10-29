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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

        //On recupère la liste des horaires
        listeHorairesAllerSimple = (ListView) findViewById(R.id.liste_vue_choix_horaire_aller_simple);

        //Recuperation de la date de l'aller ainsi que du depart et de la destination
        Inscription inscriptionEnCours = Inscription.getInstance();
        //On récupère la date de l'inscription pour l'aller
        String[] dateInscription = inscriptionEnCours.getDateAller().split("/");
        //On récupère le depart de l'aller
        DepartInscription depart = DepartInscription.Matane;
        switch(inscriptionEnCours.getVilleDepart()){
            case "Matane":
                depart = DepartInscription.Matane;
                break;
            case "Godbout":
                depart = DepartInscription.Godbout;
                break;
            case "Baie-Comeau":
                depart = DepartInscription.Baie_Comeau;
                break;
        }
        //On récupère la destination de l'aller
        DepartInscription destination = DepartInscription.Matane;
        switch(inscriptionEnCours.getVilleArrivee()){
            case "Matane":
                destination = DepartInscription.Matane;
                break;
            case "Godbout":
                destination = DepartInscription.Godbout;
                break;
            case "Baie-Comeau":
                destination = DepartInscription.Baie_Comeau;
                break;
        }

        //Permet de savoir le nom de la cle a recuperer dans le HashMap
        String cleHashMap = "heure";

        listeHorairesAllerSimple.setAdapter(new SimpleAdapter(
                this,
                VerificationHoraire.recupererHoraireEnHashMap(
                        Integer.parseInt(dateInscription[0]),
                        Integer.parseInt(dateInscription[1]),
                        Integer.parseInt(dateInscription[2]),
                        depart,
                        destination,
                        cleHashMap),
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
