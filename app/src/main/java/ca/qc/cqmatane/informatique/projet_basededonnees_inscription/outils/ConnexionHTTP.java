package ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.R;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.VueInscriptionTicket;

public class ConnexionHTTP extends AsyncTask<Void, Void, String> {

    private Context context;
    private ProgressDialog dialog;
    private String nomPage;
    private ListView listeInscriptions;

    public ConnexionHTTP(Context context, String nomPage) {
        this.context = context;
        this.nomPage = nomPage;
        dialog = new ProgressDialog(context);
    }

    public ConnexionHTTP(Context context, String nomPage, ListView listeInscriptions) {
        this.context = context;
        this.nomPage = nomPage;
        this.listeInscriptions = listeInscriptions;
        dialog = new ProgressDialog(context);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.setMessage("Chargement...");
        dialog.show();
    }


    @Override
    protected String doInBackground(Void... voids) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            StringBuffer urlBuffer = new StringBuffer("http://10.0.2.2/Inscription/"+nomPage);
            switch (nomPage){
                case "CreerInscription.php":
                    System.out.println(GestionXML.getInstance(context).creerXML());
                    urlBuffer.append("?xmlInscription=").append(GestionXML.getInstance(context).creerXML());
                    break;
                case "RecupererInscription.php":
                    urlBuffer.append("?numeroInscription=").append(GestionXML.getInstance(context).getNumeroInscription());
                    break;
            }
            URL url = new URL(urlBuffer.toString());
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            switch (nomPage){
                case "CreerInscription.php":
                    GestionXML.getInstance(context).ecrire(buffer.toString());
                    return null;
                case "RecupererInscription.php":
                    return buffer.toString();
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String inscription) {
        super.onPostExecute(inscription);
        dialog.dismiss();
        if(inscription != null){
            List<HashMap<String,String>> inscriptions = new ArrayList<>();
            HashMap<String,String> inscriptionHashMapAller = new HashMap<>();
            inscriptionHashMapAller.put("numeroInscription", "Numéro d'inscription : " + GestionXML.getInfoXML(context, inscription,"numeroInscription"));
            inscriptionHashMapAller.put("depart", "Départ : " +  GestionXML.getInfoXML(context, inscription,"depart"));
            inscriptionHashMapAller.put("arrive", "Arrivé : " + GestionXML.getInfoXML(context, inscription,"destination"));
            inscriptionHashMapAller.put("date", "Date départ : " + GestionXML.getInfoXML(context, inscription,"dateAller"));
            inscriptionHashMapAller.put("heure", "Heure départ : " + GestionXML.getInfoXML(context, inscription,"heureAller").substring(0, 5));
            inscriptions.add(inscriptionHashMapAller);
            if(!GestionXML.getInfoXML(context, inscription, "dateRetour").equals("")){
                HashMap<String,String> inscriptionHashMapRetour = new HashMap<>();
                inscriptionHashMapRetour.put("numeroInscription", inscriptionHashMapAller.get("numeroInscription"));
                inscriptionHashMapRetour.put("depart", "Départ : " + GestionXML.getInfoXML(context, inscription,"destination"));
                inscriptionHashMapRetour.put("arrive", "Arrivé : " + GestionXML.getInfoXML(context, inscription,"depart"));
                inscriptionHashMapRetour.put("date", "Date départ : " + GestionXML.getInfoXML(context, inscription,"dateRetour"));
                inscriptionHashMapRetour.put("heure", "Heure départ : " + GestionXML.getInfoXML(context, inscription,"heureRetour").substring(0, 5));
                inscriptions.add(inscriptionHashMapRetour);
            }

            listeInscriptions.setAdapter(new SimpleAdapter(
                    context,
                    inscriptions,
                    R.layout.liste_inscription_perso,
                    new String[]{"numeroInscription", "depart", "arrive", "date", "heure"},
                    new int[]{R.id.texte_numero_inscription, R.id.texte_ville_depart, R.id.texte_ville_arrive, R.id.texte_date_depart, R.id.texte_heure_depart}
            ));
        }else{
            context.startActivity(new Intent(context, VueInscriptionTicket.class));
        }
    }
}
