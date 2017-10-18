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

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.Modele.Inscription;

public class VueInscriptionDateAllerRetour extends AppCompatActivity {
    TextView calendrier_inscription_date_aller_retour_depart;
    TextView calendrier_inscription_date_aller_retour_retour;
    Button action_inscription_date_aller_retour_valider;

    String jourDepart, moisDepart, anneeDepart;
    String jourRetour, moisRetour, anneeRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_date_aller_retour);

        calendrier_inscription_date_aller_retour_depart = (TextView) findViewById(R.id.calendrier_inscription_date_aller_retour_depart);
        calendrier_inscription_date_aller_retour_retour = (TextView) findViewById(R.id.calendrier_inscription_date_aller_retour_retour);
        action_inscription_date_aller_retour_valider = (Button) findViewById(R.id.action_inscription_date_aller_retour_valider);

        ajouteEcouteur();
    }


    /**
     * Ajoute un écouteur sur les deux TextView pour ouvrir le calendrier et le bouton pour valider
     */
    private void ajouteEcouteur() {
        final Calendar dateCourante = Calendar.getInstance();
        calendrier_inscription_date_aller_retour_depart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(VueInscriptionDateAllerRetour.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        i1++;
                        calendrier_inscription_date_aller_retour_depart.setText(i2 + "/" + i1 + "/" + i);
                        jourDepart = i2 + "";
                        moisDepart = i1 + "";
                        anneeDepart = i + "";
                    }
                } , dateCourante.get(Calendar.YEAR),dateCourante.get(Calendar.MONTH),dateCourante.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.getDatePicker().setMaxDate(1508178703594L + 14342400000L);
                datePickerDialog.show();
            }
        });

        calendrier_inscription_date_aller_retour_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(VueInscriptionDateAllerRetour.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        i1++;
                        calendrier_inscription_date_aller_retour_retour.setText(i2 + "/" + i1 + "/" + i);
                        jourRetour = i2 + "";
                        moisRetour = i1 + "";
                        anneeRetour = i + "";
                    }
                } , dateCourante.get(Calendar.YEAR),dateCourante.get(Calendar.MONTH),dateCourante.get(Calendar.DAY_OF_MONTH));datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.getDatePicker().setMaxDate(1508178703594L + 14342400000L);

                datePickerDialog.show();
            }
        });

        action_inscription_date_aller_retour_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isDateValide().equals("chaineVide")) {
                    Toast.makeText(getApplicationContext(), "Veuillez rentrer toute les dates", Toast.LENGTH_SHORT).show();
                }
                else if (isDateValide().equals("dateInferieur")) {
                    Toast.makeText(getApplicationContext(), "Veuillez chosir une date de retour après le " + jourDepart + "/" + moisDepart + "/" + anneeDepart, Toast.LENGTH_SHORT).show();
                }else  { //Les informations ont passées toutes le étapes de validation
                    miseAJourInscription();
                    startActivity(new Intent(VueInscriptionDateAllerRetour.this, VueInscriptionChoixHoraireAllerRetour.class));
                }
            }
        });
    }

    /**
     * Vérifie si la date rentré est valide ou qu'elle soit bien rempli
     * @return
     */
    private String isDateValide() {
        if(jourDepart == null || moisDepart == null || anneeDepart == null || jourRetour == null || moisRetour == null || anneeRetour == null) {
            return "chaineVide";
        }
        if(Integer.parseInt(anneeRetour) < Integer.parseInt(anneeDepart)) {
            return "dateInferieur";
        }else if(Integer.parseInt(anneeRetour) == Integer.parseInt(anneeDepart) && Integer.parseInt(moisRetour) < Integer.parseInt(moisDepart)) {
            return "dateInferieur";
        }else if(Integer.parseInt(anneeRetour) == Integer.parseInt(anneeDepart) && Integer.parseInt(moisRetour) == Integer.parseInt(moisDepart) && Integer.parseInt(jourRetour) < Integer.parseInt(jourDepart)) {
            return "dateInferieur";
        }
        return "ok";
    }

    /**
     * Met à jour l'objet inscription
     */
    private void miseAJourInscription() {
        String dateAllerEntiere = anneeDepart + "-" + moisDepart + "-" + jourDepart;
        String dateRetourEntiere = anneeRetour + "-" + moisRetour + "-" + jourRetour;
        Inscription.getInstance().setDateAller(dateAllerEntiere);
        Inscription.getInstance().setDateRetour(dateRetourEntiere);
    }
}
