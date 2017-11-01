package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Inscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Vehicule;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.TypeInscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.TypeVehicule;

public class VueInscriptionQuestionsDetaillesVehicules extends AppCompatActivity {

    private EditText champNbVehicules;
    private EditText champNbVehiculesTirant;
    private EditText champNbCamionPetit;
    private EditText champNbCamionGrand;
    private EditText champNbMotocyclette;
    private EditText champLongueurSupVehicules;
    private EditText champLongueurSupVehiculesTirant;
    private EditText champLongueurCamionPetit;
    private EditText champLongueurCamionGrand;
    private Button boutonValider;
    private int nbVehiculesPrevu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_questions_detailles_vehicules);

        Bundle donnees = this.getIntent().getExtras();
        nbVehiculesPrevu = (int) donnees.get("nb_vehicules");

        champNbVehicules = (EditText) findViewById(R.id.nb_vehicules);
        champNbVehiculesTirant = (EditText) findViewById(R.id.nb_vehicules_tirant);
        champNbCamionPetit = (EditText) findViewById(R.id.nb_camion_petit);
        champNbCamionGrand = (EditText) findViewById(R.id.nb_camion_grand);
        champNbMotocyclette = (EditText) findViewById(R.id.nb_motocyclette);
        champLongueurSupVehicules = (EditText) findViewById(R.id.longueur_sup_vehicules);
        champLongueurSupVehiculesTirant = (EditText) findViewById(R.id.longueur_sup_vehicules_tirant);
        champLongueurCamionPetit = (EditText) findViewById(R.id.longueur_camion_petit);
        champLongueurCamionGrand = (EditText) findViewById(R.id.longueur_camion_grand);

        boutonValider = (Button) findViewById(R.id.bouton_valider_vehicules);

        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int nbVehicules = Integer.parseInt(champNbVehicules.getText().toString());
                    int nbVehiculesTirant= Integer.parseInt(champNbVehiculesTirant.getText().toString());
                    int nbCamionPetit = Integer.parseInt(champNbCamionPetit.getText().toString());
                    int nbCamionGrand = Integer.parseInt(champNbCamionGrand.getText().toString());
                    int nbMotocyclette = Integer.parseInt(champNbMotocyclette.getText().toString());
                    float longeurSupVehicules = Float.parseFloat(champLongueurSupVehicules.getText().toString());
                    float longeurSupVehiculesTirant = Float.parseFloat(champLongueurSupVehiculesTirant.getText().toString());
                    float longeurCamionPetit = Float.parseFloat(champLongueurCamionPetit.getText().toString());
                    float longeurCamionGrand = Float.parseFloat(champLongueurCamionGrand.getText().toString());

                    int nbVehiculesTotal = nbVehicules + nbVehiculesTirant + nbCamionPetit + nbCamionGrand + nbMotocyclette;

                    if (nbVehiculesTotal != nbVehiculesPrevu){
                        if (nbVehiculesTotal < nbVehiculesPrevu){
                            Toast.makeText(VueInscriptionQuestionsDetaillesVehicules.this, "Il manque " + (nbVehiculesPrevu-nbVehiculesTotal) + " véhicules !", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(VueInscriptionQuestionsDetaillesVehicules.this, "Il y a " + (nbVehiculesTotal-nbVehiculesPrevu) + " véhicules en trop !", Toast.LENGTH_SHORT).show();
                        }

                    } else {

                        ArrayList<Vehicule> listeVehicules = new ArrayList<Vehicule>();

                        for (int i = 0; i < nbVehicules; i++) {
                            if (i == nbVehicules-1){
                                listeVehicules.add(new Vehicule(TypeVehicule.Vehicule, 2.6, 6.4+longeurSupVehicules));
                            } else {
                                listeVehicules.add(new Vehicule(TypeVehicule.Vehicule, 2.6, 6.4));
                            }
                        }

                        for (int i = 0; i < nbVehiculesTirant; i++) {
                            if (i == nbVehiculesTirant-1){
                                listeVehicules.add(new Vehicule(TypeVehicule.Vehicule_qui_tire_un_autre_element, 2.6, 9.4+longeurSupVehiculesTirant));
                            } else {
                                listeVehicules.add(new Vehicule(TypeVehicule.Vehicule_qui_tire_un_autre_element, 2.6, 9.4));
                            }
                        }

                        for (int i = 0; i < nbCamionPetit; i++) {
                            listeVehicules.add(new Vehicule(TypeVehicule.Camion, 2.6, longeurCamionPetit/nbCamionPetit));
                        }

                        for (int i = 0; i < nbCamionGrand; i++) {
                            listeVehicules.add(new Vehicule(TypeVehicule.Camion, 6.0, longeurCamionGrand/nbCamionGrand));
                        }

                        for (int i = 0; i < nbMotocyclette; i++) {
                            listeVehicules.add(new Vehicule(TypeVehicule.Motocyclette));
                        }

                        Inscription.getInstance().setListeVehicules(listeVehicules);
                    }


                } catch (NumberFormatException e){
                    Toast.makeText(VueInscriptionQuestionsDetaillesVehicules.this, "Veuillez saisir tout les champs avce les bons formats !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
