package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Inscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outil.DepartInscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outil.VerificationHoraire;

public class VueInscriptionChoixHoraireAllerRetour extends AppCompatActivity {

    protected ListView listeHorairesAller;
    protected ListView listeHorairesRetour;
    protected Button actionValiderChoixHoraire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_choix_horaire_aller_retour);

        //Récupération des éléments de la vue
        listeHorairesAller = (ListView) findViewById(R.id.liste_vue_choix_horaire_aller_retour_aller);
        listeHorairesRetour = (ListView) findViewById(R.id.liste_vue_choix_horaire_aller_retour_retour);
        actionValiderChoixHoraire = (Button) findViewById(R.id.action_valider_choix_horaire_aller_retour);

        //On vérifie la disponibilité du bouton
        verifierBoutonValiderDisponible();

        //Recuperation de la date de l'aller ainsi que du depart et de la destination
        Inscription inscriptionEnCours = Inscription.getInstance();
        //On récupère la date de l'inscription pour l'aller
        String[] dateInscriptionAller = inscriptionEnCours.getDateAller().split("-");
        String[] dateInscriptionRetour = inscriptionEnCours.getDateRetour().split("-");
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

        listeHorairesAller.setAdapter(new SimpleAdapter(
                this,
                VerificationHoraire.recupererHoraireEnHashMap(
                        Integer.parseInt(dateInscriptionAller[2]),
                        Integer.parseInt(dateInscriptionAller[1]),
                        Integer.parseInt(dateInscriptionAller[0]),
                        depart,
                        destination,
                        cleHashMap),
                R.layout.element_liste_choix_horaire,
                new String[]{cleHashMap},
                new int[]{R.id.action_choix_horaire}
        ));

        listeHorairesRetour.setAdapter(new SimpleAdapter(
                this,
                VerificationHoraire.recupererHoraireEnHashMap(
                        Integer.parseInt(dateInscriptionRetour[2]),
                        Integer.parseInt(dateInscriptionRetour[1]),
                        Integer.parseInt(dateInscriptionRetour[0]),
                        destination,
                        depart,
                        cleHashMap),
                R.layout.element_liste_choix_horaire,
                new String[]{cleHashMap},
                new int[]{R.id.action_choix_horaire}
        ));
    }

    public void actionChoixHoraire(View v) {

        ViewGroup listeChoixHoraireDuBouton = (ViewGroup) v.getParent().getParent();

        Button boutonHoraireChoisi = (Button) v;

        for (int i = 0; i < listeChoixHoraireDuBouton.getChildCount(); i++) {
            //On récupère le ConstraintLayout de l'élément de la vue
            ViewGroup elementListeHoraire = (ViewGroup) listeChoixHoraireDuBouton.getChildAt(i);
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
        if(listeChoixHoraireDuBouton.getId() == R.id.liste_vue_choix_horaire_aller_retour_aller)
            Inscription.getInstance().setHeureAller(horaireSelectionne);
        else if(listeChoixHoraireDuBouton.getId() == R.id.liste_vue_choix_horaire_aller_retour_retour)
            Inscription.getInstance().setHeureRetour(horaireSelectionne);

        //On active le bouton valider
        verifierBoutonValiderDisponible();
    }

    private void verifierBoutonValiderDisponible() {
        boolean actionValiderDisponible =
                Inscription.getInstance().getHeureAller() != null
                        && !Inscription.getInstance().getHeureAller().equals("")
                        && Inscription.getInstance().getHeureRetour() != null
                        && !Inscription.getInstance().getHeureRetour().equals("");
        actionValiderChoixHoraire.setEnabled(actionValiderDisponible);
    }

    public void actionValiderChoixHoraire(View v){
        Intent intentNaviguerRecapitulatif = new Intent(VueInscriptionChoixHoraireAllerRetour.this, VueInscriptionRecapitulatifDesInformations.class);
        startActivity(intentNaviguerRecapitulatif);
    }

}
