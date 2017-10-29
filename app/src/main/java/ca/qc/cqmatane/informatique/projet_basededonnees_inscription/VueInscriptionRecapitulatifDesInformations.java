package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Inscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Personne;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Vehicule;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.ConnexionHTTP;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.GestionXML;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.TrancheAge;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.TypeInscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.TypeVehicule;

public class VueInscriptionRecapitulatifDesInformations extends AppCompatActivity {

    private Inscription inscription;
    private Personne personne;
    private Vehicule vehicule;

    protected TextView nom;
    protected TextView villeDepart;
    protected TextView villeArrivee;
    protected TextView type;
    protected TextView nombrePassager;
    protected TextView nombreVehicule;
    protected TextView dateAller;
    protected TextView dateRetour;
    protected TextView heureAller;
    protected TextView heureRetour;
    protected TextView prix;
    protected Button boutonModifier;
    protected Button boutonValider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_recapitulatif_des_informations);

        // Récupération des champs dans le XML
        nom = (TextView)findViewById(R.id.texte_nom_recap);
        villeDepart = (TextView)findViewById(R.id.texte_ville_depart_recap);
        villeArrivee = (TextView)findViewById(R.id.texte_ville_arrivee_recap);
        type = (TextView)findViewById(R.id.texte_type_recap);
        nombrePassager = (TextView)findViewById(R.id.texte_nombre_passager_recap);
        nombreVehicule = (TextView)findViewById(R.id.texte_nombre_vehicule_recap);
        dateAller = (TextView)findViewById(R.id.texte_date_aller_recap);
        dateRetour = (TextView)findViewById(R.id.texte_date_retour_recap);
        heureAller = (TextView)findViewById(R.id.texte_heure_aller_recap);
        heureRetour = (TextView)findViewById(R.id.texte_heure_retour_recap);
        prix = (TextView)findViewById(R.id.texte_prix_recap);
        boutonModifier = (Button) findViewById(R.id.action_modifier_recap);
        boutonValider = (Button) findViewById(R.id.action_valider_recap);


        // Récupération des instances des différents modèles
        inscription = Inscription.getInstance();
        personne = Personne.getInstance();
        vehicule = Vehicule.getInstance();

        inscription.setNumeroInscription(0);
        inscription.setNom("Nicolas");
        inscription.setType(TypeInscription.Simple);

        ArrayList<Personne> personnes = new ArrayList<>();
        personnes.add(new Personne(TrancheAge.DE0a4, false));
        personnes.add(new Personne(TrancheAge.DE16a64, true));
        inscription.setListePersonnes(personnes);

        ArrayList<Vehicule> vehicules = new ArrayList<>();
        vehicules.add(new Vehicule(51, TypeVehicule.Camion, 10, 15));
        vehicules.add(new Vehicule(51, TypeVehicule.Vehicule, 5, 5));
        inscription.setListeVehicules(vehicules);

        inscription.setDateAller("2017-05-21");
        inscription.setHeureAller("15:00");
        inscription.setDateRetour("2017-06-21");
        inscription.setHeureRetour("17:00");

        inscription.setPrix(90051);
        inscription.setVilleArrivee("Matane");
        inscription.setVilleDepart("Godbout");


        ajouterEcouteur(); // Appelle la méthode qui change la page dynamiquement en fonction de l'utilisateur
    }



    /**
     * Méthode qui permet de remplir tous les champs dans le récapitulatif
     */
    public void ajouterEcouteur() {
        nom.setText("Nom : "+inscription.getNom());
        villeDepart.setText("Ville de départ : "+inscription.getVilleDepart());
        villeArrivee.setText("Ville d'arrivée : "+inscription.getVilleArrivee());
        type.setText("Trajet : "+inscription.getType());
        nombrePassager.setText("Nombre de passagers : "+inscription.getListePersonnes().size());
        nombreVehicule.setText("Nombre de véhicules : "+inscription.getListeVehicules().size());
        dateAller.setText("Date de départ : "+inscription.getDateAller());
        if (dateRetour != null) { // Vérifie si l'utilisateur a pris un aller-retour
            dateRetour.setText("Date de retour : " + inscription.getDateRetour());
        } else {
            dateRetour.setText("Aucune date de retour");
        }
        heureAller.setText("Heure de l'aller : "+inscription.getHeureAller());
        if (heureRetour != null) { // Vérifie si l'utilisateur a pris un aller-retour
            heureRetour.setText("Heure du retour : " + inscription.getHeureRetour());
        } else {
            heureRetour.setText("Aucune heure de retour");
        }
        prix.setText("Prix : "+ inscription.getPrix() + "$");

        ecouteurBoutons(); // Appelle la méthode pour écouter les boutons
    }


    
    /**
     * Méthode qui sert à écouter les boutons modifier et valider
     */
    public void ecouteurBoutons(){
        boutonModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VueInscriptionRecapitulatifDesInformations.this, VueInscriptionQuestionDeBase.class));
            }
        });

        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ConnexionHTTP(VueInscriptionRecapitulatifDesInformations.this).execute();
            }
        });
    }
}
