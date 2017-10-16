package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class VueInscriptionDateSimple extends AppCompatActivity {

    TextView champDate;
    String jour, mois, annee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_date_simple);

        champDate = (TextView)findViewById(R.id.champ_choisir_date);
    }


    public void onClick(View vue) {
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
        datePickerDialog.show();
    }
}
