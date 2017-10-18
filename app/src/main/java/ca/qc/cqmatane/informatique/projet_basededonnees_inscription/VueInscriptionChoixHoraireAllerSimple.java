package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VueInscriptionChoixHoraireAllerSimple extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_choix_horaire_aller_simple);


        List<HashMap<String, String>> listeHeures = new ArrayList<>();

        for(int i = 0; i < 25; i++){
            HashMap<String, String> heure1 = new HashMap<>();
            heure1.put("heure", i < 10 ? ("0" + i + ":00") : (i + ":00"));
            listeHeures.add(heure1);
        }

        ListView listeHorairesAllerSimple = (ListView) findViewById(R.id.liste_vue_choix_horaire_aller_simple);

        listeHorairesAllerSimple.setAdapter(new SimpleAdapter(
                this,
                listeHeures,
                R.layout.element_liste_choix_horaire,
                new String[] { "heure" },
                new int[] { R.id.action_choix_horaire }
        ));
    }
}
