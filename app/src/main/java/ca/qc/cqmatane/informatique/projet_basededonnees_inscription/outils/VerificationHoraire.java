package ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class VerificationHoraire {

    private static final String FORMAT_DATE = "dd/MM/yyyy";

    private static final String JOUR_AVANT_PRINTEMPS_AVRIL_2017 = "31/03/2017";
    private static final String JOUR_APRES_PRINTEMPS_AVRIL_2017 = "01/05/2017";

    public static List<String> recupererHoraire(int jour, int mois, int annee, DepartInscription depart, DepartInscription destination){

        List<String> horairesDisponibles = new ArrayList<>();

        try{
            Calendar c = Calendar.getInstance();
            c.setTime(new SimpleDateFormat(FORMAT_DATE).parse(jour+"/"+mois+"/"+annee));
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

            Date dateVerifiee = c.getTime();
            if(dateVerifiee.after(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_AVANT_PRINTEMPS_AVRIL_2017))
                    && dateVerifiee.before(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_APRES_PRINTEMPS_AVRIL_2017))){
                return recupererHorairesPrintempsAvril(jourVerifie, depart, destination);
            }

        }
        catch(Exception e){
            System.out.println("Mauvaise date envoyée !");
        }
        return horairesDisponibles;
    }

    //PRINTEMPS - DU 1ER AU 30 AVRIL 2017
    private static List<String> recupererHorairesPrintempsAvril(JourInscription jour, DepartInscription depart, DepartInscription destination){
        List<String> horairesDisponibles = new ArrayList<>();
        if(depart == DepartInscription.Matane && destination == DepartInscription.Godbout){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("08:00");
            else if(jour == JourInscription.MARDI) horairesDisponibles.add("08:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("14:00");
            else if(jour == JourInscription.JEUDI) horairesDisponibles.add("08:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("08:00");
            else if(jour == JourInscription.SAMEDI) horairesDisponibles.add("08:00");
            else if(jour == JourInscription.DIMANCHE) horairesDisponibles.add("09:00");
        }
        else if(depart == DepartInscription.Godbout && destination == DepartInscription.Matane){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.MARDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("17:00");
            else if(jour == JourInscription.JEUDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.SAMEDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.DIMANCHE) horairesDisponibles.add("12:00");
        }
        else if(depart == DepartInscription.Matane && destination == DepartInscription.Baie_Comeau){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("14:00");
            else if(jour == JourInscription.MARDI) horairesDisponibles.add("14:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("08:00");
            else if(jour == JourInscription.JEUDI) horairesDisponibles.add("14:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("14:00");
            else if(jour == JourInscription.SAMEDI) horairesDisponibles.add("14:00");
            else if(jour == JourInscription.DIMANCHE) horairesDisponibles.add("15:00");
        }
        else if(depart == DepartInscription.Baie_Comeau && destination == DepartInscription.Matane){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("17:00");
            else if(jour == JourInscription.MARDI) horairesDisponibles.add("17:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.JEUDI) horairesDisponibles.add("17:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("17:00");
            else if(jour == JourInscription.SAMEDI) horairesDisponibles.add("17:00");
            else if(jour == JourInscription.DIMANCHE) horairesDisponibles.add("18:00");
        }
        return horairesDisponibles;
    }

}
