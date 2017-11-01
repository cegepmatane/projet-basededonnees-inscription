package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class VueInscriptionPrincipale extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_principale);
    }

    public void actionAfficherInscriptions(View vue){
        startActivity(new Intent(VueInscriptionPrincipale.this, VueInscriptionListeInscription.class));
    }

    public void actionFaireInscription(View vue){
        startActivity(new Intent(VueInscriptionPrincipale.this, VueInscriptionQuestionDeBase.class));
    }
}
