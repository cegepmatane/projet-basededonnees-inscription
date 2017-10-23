package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Inscription;

public class VueInscriptionQuestionDeBase extends AppCompatActivity {

    private Spinner spinnerDepart;
    private Spinner spinnerArrivee;
    private EditText champNom;
    private EditText champNbPassagers;
    private EditText champNbVehicules;
    private Button boutonValider;
    private Inscription inscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_question_de_base);
        RadioButton radioButtonAllerSimple = (RadioButton) findViewById(R.id.bouton_aller_simple);
        radioButtonAllerSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton radioButtonAllerRetour = (RadioButton) findViewById(R.id.bouton_aller_retour);
                radioButtonAllerRetour.setChecked(false);
            }
        });

        RadioButton radioButtonAllerRetour = (RadioButton) findViewById(R.id.bouton_aller_retour);
        radioButtonAllerRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton radioButtonAllerSimple = (RadioButton) findViewById(R.id.bouton_aller_simple);
                radioButtonAllerSimple.setChecked(false);
            }
        });

        spinnerDepart = (Spinner) findViewById(R.id.spinner_depart_aller_simple);
        spinnerArrivee = (Spinner) findViewById(R.id.spinner_arrivee_aller_simple);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.destination_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDepart.setAdapter(adapter);
        spinnerArrivee.setAdapter(adapter);

        champNom = (EditText) findViewById(R.id.text_nom);
        champNbPassagers = (EditText) findViewById(R.id.text_nombre_personne);
        champNbVehicules = (EditText) findViewById(R.id.text_nombre_vehicule);
        inscription = Inscription.getInstance();
        champNom.setText(inscription.getNom());
        try {
            champNbPassagers.setText(inscription.getListePersonnes().size());
            champNbVehicules.setText(inscription.getListeVehicules().size());
        } catch (Exception e){

        }

        boutonValider = (Button) findViewById(R.id.bouton_valider);
        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inscription.setNom(champNom.getText().toString());
                if (Integer.parseInt(champNbVehicules.getText().toString()) == 0){
                    Intent intentNavigueQuestionDetaillees = new Intent(VueInscriptionQuestionDeBase.this, VueInscriptionQuestionDetailles.class);
                    
                }

            }
        });


    }


}
