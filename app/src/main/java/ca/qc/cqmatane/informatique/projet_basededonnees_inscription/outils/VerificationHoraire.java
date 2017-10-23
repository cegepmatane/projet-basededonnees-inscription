package ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class VerificationHoraire {

    public static String[] recupererHoraire(int jour, int mois, int annee){
        Calendar dateVerification = new GregorianCalendar(annee, mois, jour);
        System.out.println(dateVerification.get(Calendar.DAY_OF_WEEK));
        return null;
    }

}
