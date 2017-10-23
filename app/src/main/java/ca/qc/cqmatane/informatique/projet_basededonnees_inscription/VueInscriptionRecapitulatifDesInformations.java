package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Inscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Personne;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Vehicule;

public class VueInscriptionRecapitulatifDesInformations extends AppCompatActivity {

    private Inscription inscription;
    private Personne personne;
    private Vehicule vehicule;

    protected TextView nom;
    protected TextView villeDepart;
    protected TextView villeArrivee;
    protected TextView nombrePassager;
    protected TextView nombreVehicule;
    protected TextView dateAller;
    protected TextView dateRetour;
    protected TextView heureAller;
    protected TextView heureRetour;
    protected TextView prix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_recapitulatif_des_informations);

        nom = (TextView)findViewById(R.id.texte_nom_recap);
        villeDepart = (TextView)findViewById(R.id.texte_ville_depart_recap);
        villeArrivee = (TextView)findViewById(R.id.texte_ville_arrivee_recap);
        nombrePassager = (TextView)findViewById(R.id.texte_nombre_passager_recap);
        nombreVehicule = (TextView)findViewById(R.id.texte_nombre_vehicule_recap);
        dateAller = (TextView)findViewById(R.id.texte_date_aller_recap);
        dateRetour = (TextView)findViewById(R.id.texte_date_retour_recap);
        heureAller = (TextView)findViewById(R.id.texte_heure_aller_recap);
        heureRetour = (TextView)findViewById(R.id.texte_date_retour_recap);
        prix = (TextView)findViewById(R.id.texte_prix_recap);


        inscription = Inscription.getInstance();
        personne = Personne.getInstance();
        vehicule = Vehicule.getInstance();

        ajouterEcouteur();
    }


    public void ajouterEcouteur() {
        nom.setText("Nom : "+inscription.getNom());
        villeDepart.setText("Ville de départ : "+inscription.getVilleDepart());
        villeArrivee.setText("Ville d'arrivée : "+inscription.getVilleArrivee());
        nombrePassager.setText("Nombre de passagers : "+inscription.getListePersonnes().size());
        nombreVehicule.setText("Nombre de véhicules : "+inscription.getListeVehicules().size());
        dateAller.setText("Date de départ : "+inscription.getDateAller());
        dateRetour.setText("Date de retour : "+inscription.getDateRetour());
        heureAller.setText("Heure de l'aller : "+inscription.getHeureAller());
        heureRetour.setText("Heure du retour : "+inscription.getHeureRetour());
        prix.setText("Prix : "+String.valueOf(inscription.getPrix()));
    }


}
