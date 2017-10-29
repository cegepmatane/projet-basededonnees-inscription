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
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Personne;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.TrancheAge;

public class VueInscriptionQuestionDetaillesPassagers extends AppCompatActivity {

    private EditText champAge1;
    private EditText champAge2;
    private EditText champAge3;
    private EditText champAge4;
    private EditText champAccompagnateur;
    private Button boutonValider;
    private int nbPassagers;
    private int nbVehicules;
    private ArrayList<Personne> listePassagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_question_detailles);

        Bundle donnees = this.getIntent().getExtras();
        nbPassagers = (int) donnees.get("nb_passagers");
        nbVehicules = (int) donnees.get("nb_vehicules");

        champAge1 = (EditText) findViewById(R.id.passagers_0_4);
        champAge2 = (EditText) findViewById(R.id.passagers_5_15);
        champAge3 = (EditText) findViewById(R.id.passagers_16_64);
        champAge4 = (EditText) findViewById(R.id.passagers_65_plus);
        champAccompagnateur = (EditText) findViewById(R.id.passagers_accompagnateur);
        boutonValider = (Button) findViewById(R.id.button_valider_passagers);

        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int nbPersonneSaisi1 = Integer.parseInt(champAge1.getText().toString());
                    int nbPersonneSaisi2 = Integer.parseInt(champAge2.getText().toString());
                    int nbPersonneSaisi3 = Integer.parseInt(champAge3.getText().toString());
                    int nbPersonneSaisi4 = Integer.parseInt(champAge4.getText().toString());
                    int nbPersonneSaisi5 = Integer.parseInt(champAccompagnateur.getText().toString());

                    int personneSaisiTotal = nbPersonneSaisi1 + nbPersonneSaisi2 + nbPersonneSaisi3 + nbPersonneSaisi4 + nbPersonneSaisi5;

                    if (personneSaisiTotal != nbPassagers){
                        if(personneSaisiTotal > nbPassagers){
                            Toast.makeText(VueInscriptionQuestionDetaillesPassagers.this, "Il y a " + (personneSaisiTotal-nbPassagers) + " passagers en trop !", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(VueInscriptionQuestionDetaillesPassagers.this, "Il manque " + (nbPassagers-personneSaisiTotal) + " passagers !", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        listePassagers = new ArrayList<Personne>();
                        for (int i = 0; i < nbPersonneSaisi1; i++) {
                            listePassagers.add(new Personne(TrancheAge.DE0a4,false));
                        }

                        for (int i = 0; i < nbPersonneSaisi2; i++) {
                            listePassagers.add(new Personne(TrancheAge.DE5a15,false));
                        }

                        for (int i = 0; i < nbPersonneSaisi3; i++) {
                            listePassagers.add(new Personne(TrancheAge.DE16a64,false));
                        }

                        for (int i = 0; i < nbPersonneSaisi4; i++) {
                            listePassagers.add(new Personne(TrancheAge.DE65aPLUS,false));
                        }

                        for (int i = 0; i < nbPersonneSaisi5; i++) {
                            listePassagers.add(new Personne(null,true));
                        }
                    }
                    Inscription.getInstance().setListePersonnes(listePassagers);

                } catch (NumberFormatException e){
                    Toast.makeText(VueInscriptionQuestionDetaillesPassagers.this, "Veuillez saisir des chiffres uniquement",Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}