package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.ConnexionHTTP;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.GestionXML;

public class VueInscriptionListeInscription extends AppCompatActivity {

    ListView listeInscriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_liste_inscription);

        listeInscriptions = (ListView)findViewById(R.id.liste_inscription);

        ConnexionHTTP connexionHTTP = new ConnexionHTTP(this, "RecupererInscription.php", listeInscriptions);
        connexionHTTP.execute();
    }

}
