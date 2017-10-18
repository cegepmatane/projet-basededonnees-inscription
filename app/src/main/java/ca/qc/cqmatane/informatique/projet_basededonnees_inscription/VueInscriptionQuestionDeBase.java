package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.Modele.Inscription;

public class VueInscriptionQuestionDeBase extends AppCompatActivity {

    private Spinner spinnerDepart;
    private Spinner spinnerArrivee;
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

        inscription = new Inscription();
    }
}
