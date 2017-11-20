package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Inscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.TypeInscription;

public class VueInscriptionQuestionDeBase extends AppCompatActivity {

    private Spinner spinnerDepart;
    private Spinner spinnerArrivee;
    private EditText champNom;
    private EditText champNbPassagers;
    private EditText champNbVehicules;
    private Button boutonValider;
    private RadioButton boutonAllerSimple;
    private RadioButton boutonAllerRetour;
    private Inscription inscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_question_de_base);
        boutonAllerSimple = (RadioButton) findViewById(R.id.bouton_aller_simple);
        boutonAllerRetour = (RadioButton) findViewById(R.id.bouton_aller_retour);
        boutonAllerSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boutonAllerRetour.setChecked(false);
            }
        });

        boutonAllerRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 boutonAllerSimple.setChecked(false);
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
        } catch (Exception exception){

        }

        boutonValider = (Button) findViewById(R.id.bouton_valider);
        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inscription.setNom(champNom.getText().toString());
                if (boutonAllerSimple.isChecked())inscription.setType(TypeInscription.Simple);
                else inscription.setType(TypeInscription.Retour);
                inscription.setVilleDepart(spinnerDepart.getSelectedItem().toString());
                inscription.setVilleArrivee(spinnerArrivee.getSelectedItem().toString());
                Intent intentNavigueQuestionDetaillees = new Intent(VueInscriptionQuestionDeBase.this, VueInscriptionQuestionDetaillesPassagers.class);
                intentNavigueQuestionDetaillees.putExtra("nb_passagers",Integer.parseInt(champNbPassagers.getText().toString()));
                intentNavigueQuestionDetaillees.putExtra("nb_vehicules",Integer.parseInt(champNbVehicules.getText().toString()));
                startActivity(intentNavigueQuestionDetaillees);
            }
        });


    }


}
