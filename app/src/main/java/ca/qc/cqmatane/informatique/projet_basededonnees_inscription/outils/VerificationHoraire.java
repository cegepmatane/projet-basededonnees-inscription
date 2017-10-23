package ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class VerificationHoraire {

    public static List<String> recupererHoraire(int jour, int mois, int annee){
        List<String> datesDisponibles = new ArrayList<>();
        try{
            Calendar c = Calendar.getInstance();
            c.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(jour+"/"+mois+"/"+annee));
            JourInscription jourVerifie;
            switch(c.get(Calendar.DAY_OF_WEEK)){
                case 1:
                    jourVerifie = JourInscription.DIMANCHE;
                    break;
                case 2:
                    jourVerifie = JourInscription.LUNDI;
                    break;
                case 3:
                    jourVerifie = JourInscription.MARDI;
                    break;
                case 4:
                    jourVerifie = JourInscription.MERCREDI;
                    break;
                case 5:
                    jourVerifie = JourInscription.JEUDI;
                    break;
                case 6:
                    jourVerifie = JourInscription.VENDREDI;
                    break;
                default:
                    jourVerifie = JourInscription.SAMEDI;
                    break;
            }
            System.out.println("Jour le 23/10/2017 : " + jourVerifie.toString());
        }
        catch(Exception e){
            System.out.println("Mauvaise date envoyée !");
        }
        return datesDisponibles;
    }

}
