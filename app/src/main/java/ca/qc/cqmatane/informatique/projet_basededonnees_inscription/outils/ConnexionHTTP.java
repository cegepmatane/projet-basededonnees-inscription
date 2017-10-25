package ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.VueInscriptionTicket;

public class ConnexionHTTP extends AsyncTask<Void, Void, Void> {

    private Context context;
    private ProgressDialog dialog;

    public ConnexionHTTP(Context context) {
        this.context = context;
        dialog = new ProgressDialog(context);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.setMessage("Chargement...");
        dialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL("http://10.0.2.2/Inscription/CreerInscription.php?xmlInscription=" + GestionXML.getInstance(context).creerXML());
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            GestionXML.getInstance(context).ecrire(buffer.toString());
            System.out.println(GestionXML.getInstance(context).getNumeroInscription());
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        dialog.dismiss();
        context.startActivity(new Intent(context, VueInscriptionTicket.class));
    }
}
