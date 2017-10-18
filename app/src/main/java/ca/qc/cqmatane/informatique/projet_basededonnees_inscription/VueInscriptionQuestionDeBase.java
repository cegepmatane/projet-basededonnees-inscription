package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class VueInscriptionQuestionDeBase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_question_de_base);
        startActivity(new Intent(VueInscriptionQuestionDeBase.this, VueInscriptionDateAllerRetour.class));
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
    }
}
