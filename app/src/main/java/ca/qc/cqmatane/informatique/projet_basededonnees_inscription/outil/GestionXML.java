package ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outil;

import android.content.Context;
import android.util.Xml;
import android.widget.Toast;

import org.xmlpull.v1.XmlSerializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Inscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Personne;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Vehicule;

public class GestionXML {

    private static GestionXML instance;
    private Context contexte;
    private Inscription inscription;

    public static GestionXML getInstance(Context contexte) {
        if (instance == null) instance = new GestionXML(contexte);
        return instance;
    }

    public GestionXML(Context contexte) {
        this.contexte = contexte;
        inscription = Inscription.getInstance();
    }

    public String creerXML() {
        try {
            XmlSerializer xmlSerializer = Xml.newSerializer();
            StringWriter writer = new StringWriter();
            xmlSerializer.setOutput(writer);
            xmlSerializer.startDocument("UTF-8", true);
            //Entre la balise <inscription>
            xmlSerializer.startTag(null, "inscription");

            xmlSerializer.startTag(null, "numeroInscription");
            xmlSerializer.text(inscription.getNumeroInscription() + "");
            xmlSerializer.endTag(null, "numeroInscription");

            xmlSerializer.startTag(null, "nom");
            xmlSerializer.text(inscription.getNom());
            xmlSerializer.endTag(null, "nom");

            xmlSerializer.startTag(null, "type");
            xmlSerializer.text(inscription.getType() + "");
            xmlSerializer.endTag(null, "type");

            xmlSerializer.startTag(null, "dateAller");
            xmlSerializer.text(inscription.getDateAller());
            xmlSerializer.endTag(null, "dateAller");

            xmlSerializer.startTag(null, "heureAller");
            xmlSerializer.text(inscription.getHeureAller());
            xmlSerializer.endTag(null, "heureAller");

            xmlSerializer.startTag(null, "dateRetour");
            if(inscription.getDateRetour() == null){
                xmlSerializer.text("NULL");
            }else{
                xmlSerializer.text(inscription.getDateRetour());
            }
            xmlSerializer.endTag(null, "dateRetour");

            xmlSerializer.startTag(null, "heureRetour");
            if(inscription.getHeureRetour() == null){
                xmlSerializer.text("NULL");
            }else{
                xmlSerializer.text(inscription.getHeureRetour());
            }
            xmlSerializer.endTag(null, "heureRetour");

            xmlSerializer.startTag(null, "depart");
            xmlSerializer.text(inscription.getVilleDepart());
            xmlSerializer.endTag(null, "depart");

            xmlSerializer.startTag(null, "destination");
            xmlSerializer.text(inscription.getVilleArrivee());
            xmlSerializer.endTag(null, "destination");

            xmlSerializer.startTag(null, "type");
            xmlSerializer.text(inscription.getType() + "");
            xmlSerializer.endTag(null, "type");

            xmlSerializer.startTag(null, "prix");
            xmlSerializer.text(inscription.getPrix() + "");
            xmlSerializer.endTag(null, "prix");

            xmlSerializer.startTag(null, "personnes");
            for (Personne personne : inscription.getListePersonnes()) {
                xmlSerializer.startTag(null, "personne");
                xmlSerializer.startTag(null, "age");
                xmlSerializer.text(personne.getAge().toString());
                xmlSerializer.endTag(null, "age");
                xmlSerializer.startTag(null, "accompagnateur");
                xmlSerializer.text(personne.isAccompagnateur() + "");
                xmlSerializer.endTag(null, "accompagnateur");
                xmlSerializer.endTag(null, "personne");
            }
            xmlSerializer.endTag(null, "personnes");

            xmlSerializer.startTag(null, "vehicules");
            for (Vehicule vehicule : inscription.getListeVehicules()) {
                xmlSerializer.startTag(null, "vehicule");
                xmlSerializer.startTag(null, "type");
                xmlSerializer.text(vehicule.getType() + "");
                xmlSerializer.endTag(null, "type");
                xmlSerializer.startTag(null, "largeur");
                xmlSerializer.text(vehicule.getLargeur() + "");
                xmlSerializer.endTag(null, "largeur");
                xmlSerializer.startTag(null, "longeur");
                xmlSerializer.text(vehicule.getLongueur() + "");
                xmlSerializer.endTag(null, "longeur");
                xmlSerializer.endTag(null, "vehicule");
            }
            xmlSerializer.endTag(null, "vehicules");

            xmlSerializer.endTag(null, "inscription");
            xmlSerializer.endDocument();
            xmlSerializer.flush();
            return writer.toString();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return "";
    }

    public void ecrire(String numeroInscription) {
        FileOutputStream fluxSortieFichier = null;
        try {
            fluxSortieFichier = contexte.openFileOutput("inscription.xml", Context.MODE_PRIVATE);
            XmlSerializer xmlSerializer = Xml.newSerializer();
            StringWriter writer = new StringWriter();
            xmlSerializer.setOutput(writer);
            xmlSerializer.startDocument("UTF-8", true);
            xmlSerializer.startTag(null, "inscription");
            xmlSerializer.startTag(null, "numeroInscription");
            xmlSerializer.text(numeroInscription);
            xmlSerializer.endTag(null, "numeroInscription");
            xmlSerializer.startTag(null, "inscription");
            xmlSerializer.endDocument();
            xmlSerializer.flush();
            String dataWrite = writer.toString();
            fluxSortieFichier.write(dataWrite.getBytes());
            fluxSortieFichier.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public String getNumeroInscription() {
        FileInputStream ficherEntree = null;
        String numeroInscription = "";
        try {
            ficherEntree = contexte.openFileInput("inscription.xml");
            InputStreamReader lectureEntree = new InputStreamReader(ficherEntree);
            char[] entreeConstructeur = new char[ficherEntree.available()];
            lectureEntree.read(entreeConstructeur);
            String donnee = new String(entreeConstructeur);
            numeroInscription = (donnee.split("<numeroInscription>")[1]).split("</numeroInscription>")[0];
            lectureEntree.close();
            ficherEntree.close();
        } catch (Exception exception) {
            Toast.makeText(contexte, "Vous n'avez pas d'inscription...", Toast.LENGTH_SHORT).show();
            exception.printStackTrace();
        }
        return numeroInscription;
    }

    public String lire() {
        FileInputStream ficherEntree = null;
        String donnee = "";
        try {
            ficherEntree = contexte.openFileInput("inscription.xml");
            InputStreamReader lectureEntree = new InputStreamReader(ficherEntree);
            char[] entreeConstructeur = new char[ficherEntree.available()];
            lectureEntree.read(entreeConstructeur);
            donnee = new String(entreeConstructeur);
            lectureEntree.close();
            ficherEntree.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return donnee;
    }

    public void supprimerXML() {
        contexte.deleteFile("preference.xml");
    }

    public static String getInfoXML(Context contexte, String informationComplete, String informationVoulu) {
        return (informationComplete.split("<" + informationVoulu + ">")[1]).split("</" + informationVoulu + ">")[0];
    }
}
