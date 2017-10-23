package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Inscription;

public class VueInscriptionDateSimple extends AppCompatActivity {

    TextView champDate;
    String jour, mois, annee;
    Button bouton_valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_date_simple);

        champDate = (TextView)findViewById(R.id.champ_choisir_date);
        bouton_valider = (Button)findViewById(R.id.action_date_depart_valider);
        ajouterEcouteur();
    }


    public void ajouterEcouteur() {
        champDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar dateCourante = Calendar.getInstance();

                DatePickerDialog datePickerDialog = new DatePickerDialog(VueInscriptionDateSimple.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        i1++;
                        champDate.setText(i2 + "/" + i1 + "/" + i);
                        jour = i2 + "";
                        mois = i1 + "";
                        annee = i + "";
                    }
                }, dateCourante.get(Calendar.YEAR), dateCourante.get(Calendar.MONTH), dateCourante.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().setMinDate(dateCourante.getTimeInMillis());
                datePickerDialog.getDatePicker().setMaxDate(1522540799000L);
                datePickerDialog.show();
            }
        });

        bouton_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isDateValide().equals("chaineVide")) {
                    Toast.makeText(getApplicationContext(), "Veuillez rentrer une date", Toast.LENGTH_SHORT).show();
                } else {
                    miseAJourInscription();
                    startActivity(new Intent(VueInscriptionDateSimple.this, VueInscriptionChoixHoraireAllerSimple.class));
                }
            }
        });

    }

    public String isDateValide() {
        if(jour == null || mois == null || annee == null) {
            return "chaineVide";
        }
        return "ok";
    }

    private void miseAJourInscription() {
        String dateAllerEntiere = annee + "-" + mois + "-" + jour;
        Inscription.getInstance().setDateAller(dateAllerEntiere);
    }


}
