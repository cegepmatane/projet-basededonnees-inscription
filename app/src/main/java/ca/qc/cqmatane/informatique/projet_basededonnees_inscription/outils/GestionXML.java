package ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils;

import android.content.Context;
import android.util.Xml;

import org.xmlpull.v1.XmlSerializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

public class GestionXML {

    private static GestionXML instance;
    private Context contexte;

    public static GestionXML getInstance(Context contexte) {
        if (instance == null) instance = new GestionXML(contexte);
        return instance;
    }

    public GestionXML(Context contexte) {
        this.contexte = contexte;
    }

    public void ecrire() {
        FileOutputStream fluxSortieFichier = null;
        try {
            fluxSortieFichier = contexte.openFileOutput("inscription.xml", Context.MODE_PRIVATE);
            XmlSerializer xmlSerializer = Xml.newSerializer();
            StringWriter writer = new StringWriter();
            xmlSerializer.setOutput(writer);
            xmlSerializer.startDocument("UTF-8", true);
            //Entre la balise <inscription>
            xmlSerializer.startTag(null, "inscription");

            xmlSerializer.startTag(null, "numeroInscription");
            xmlSerializer.text("2");
            xmlSerializer.endTag(null, "numeroInscription");

            xmlSerializer.endTag(null, "inscription");
            xmlSerializer.endDocument();
            xmlSerializer.flush();
            String dataWrite = writer.toString();
            fluxSortieFichier.write(dataWrite.getBytes());
            fluxSortieFichier.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void lire() {
//        FileInputStream ficherEntree = null;
//        try {
//            ficherEntree = contexte.openFileInput("preference.xml");
//            InputStreamReader lectureEntree = new InputStreamReader(ficherEntree);
//            char[] entreeConstructeur = new char[ficherEntree.available()];
//            lectureEntree.read(entreeConstructeur);
//            String donnee = new String(entreeConstructeur);
//            nomDeCompte = (donnee.split("<username>")[1]).split("</username>")[0];
//            vibration = Boolean.parseBoolean((donnee.split("<vibration>")[1]).split("</vibration>")[0]);
//            lectureEntree.close();
//            ficherEntree.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numeroInscription;
    }

    public void supprimerXML(){
        contexte.deleteFile("preference.xml");
    }
}
