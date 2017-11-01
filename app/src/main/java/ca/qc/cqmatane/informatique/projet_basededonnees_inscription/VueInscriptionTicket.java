package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Inscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.GestionXML;


public class VueInscriptionTicket extends AppCompatActivity {
    private Inscription inscription;

    private TextView affichage_vue_inscription_numero_ticket;
    private TextView affichage_vue_inscription_prix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_ticket);
        inscription = Inscription.getInstance();
        affichage_vue_inscription_numero_ticket = (TextView) findViewById(R.id.affichage_vue_inscription_numero_ticket);
        affichage_vue_inscription_prix = (TextView) findViewById(R.id.affichage_vue_inscription_prix);

        float prixTotalFinal = (float) inscription.getPrix();
        affichage_vue_inscription_prix.setText(prixTotalFinal + "");

        String numeroInscription = GestionXML.getInstance(getApplicationContext()).getNumeroInscription();
        affichage_vue_inscription_numero_ticket.setText(numeroInscription);
    }





}
