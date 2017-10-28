package ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class VerificationHoraire {

    private static final String FORMAT_DATE = "dd/MM/yyyy";

    private static final String JOUR_AVANT_PRINTEMPS_AVRIL = "31/03/2017";
    private static final String JOUR_APRES_PRINTEMPS_AVRIL = "01/05/2017";

    private static final String JOUR_AVANT_PRINTEMPS_MAI_JUILLET = "30/04/2017";
    private static final String JOUR_APRES_PRINTEMPS_MAI_JUILLET = "22/07/2017";

    private static final String JOUR_AVANT_ETE = "21/07/2017";
    private static final String JOUR_APRES_ETE = "05/09/2017";

    private static final String JOUR_AVANT_AUTOMNE = "04/09/2017";
    private static final String JOUR_APRES_AUTOMNE = "10/10/2017";

    public static List<String> recupererHoraire(int jour, int mois, int annee, DepartInscription depart, DepartInscription destination){
        try{
            //On récupère la date actuelle
            Calendar c = Calendar.getInstance();
            c.setTime(new SimpleDateFormat(FORMAT_DATE).parse(jour+"/"+mois+"/"+annee));
            //On regarde le jour de la semaine de la date envoyée
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
            //On vérifie si la date correspond à la période Printemps Avril
            if(dateVerifiee.after(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_AVANT_PRINTEMPS_AVRIL))
                    && dateVerifiee.before(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_APRES_PRINTEMPS_AVRIL))){
                return recupererHorairesPrintempsAvril(jourVerifie, depart, destination);
            }
            //On vérifie si la date correspond à la période Printemps Mai Juillet
            if(dateVerifiee.after(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_AVANT_PRINTEMPS_MAI_JUILLET))
                    && dateVerifiee.before(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_APRES_PRINTEMPS_MAI_JUILLET))){
                return recupererHorairesPrintempsMaiJuillet(jourVerifie, depart, destination);
            }
            //On vérifie si la date correspond à la période Été
            if(dateVerifiee.after(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_AVANT_ETE))
                    && dateVerifiee.before(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_APRES_ETE))){
                return recupererHorairesEte(jourVerifie, depart, destination);
            }
            //On vérifie si la date correspond à la période Automne
            if(dateVerifiee.after(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_AVANT_AUTOMNE))
                    && dateVerifiee.before(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_APRES_AUTOMNE))){
                return recupererHorairesAutomne(jourVerifie, depart, destination);
            }

        }
        catch(Exception e){
            System.out.println("Mauvaise date envoyée !");
        }

        return new ArrayList<>(); // On renvoie une liste vide puisque aucune date n'a été trouvée
    }

    //PRINTEMPS AVRIL - DU 1ER AU 30 AVRIL 2017
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

    //PRINTEMPS MAI JUILLET - DU 1ER MAI AU 21 JUILLET 2017
    private static List<String> recupererHorairesPrintempsMaiJuillet(JourInscription jour, DepartInscription depart, DepartInscription destination){
        List<String> horairesDisponibles = new ArrayList<>();
        if(depart == DepartInscription.Matane && destination == DepartInscription.Godbout){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("07:00");
            else if(jour == JourInscription.MARDI) horairesDisponibles.add("07:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("14:00");
            else if(jour == JourInscription.JEUDI) horairesDisponibles.add("07:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("07:00");
            else if(jour == JourInscription.SAMEDI) horairesDisponibles.add("08:00");
            else if(jour == JourInscription.DIMANCHE) horairesDisponibles.add("09:00");
        }
        else if(depart == DepartInscription.Godbout && destination == DepartInscription.Matane){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.MARDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("18:00");
            else if(jour == JourInscription.JEUDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.SAMEDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.DIMANCHE) horairesDisponibles.add("12:00");
        }
        else if(depart == DepartInscription.Matane && destination == DepartInscription.Baie_Comeau){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("15:00");
            else if(jour == JourInscription.MARDI) horairesDisponibles.add("15:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("07:00");
            else if(jour == JourInscription.JEUDI) horairesDisponibles.add("15:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("15:00");
            else if(jour == JourInscription.SAMEDI) horairesDisponibles.add("14:00");
            else if(jour == JourInscription.DIMANCHE) horairesDisponibles.add("15:00");
        }
        else if(depart == DepartInscription.Baie_Comeau && destination == DepartInscription.Matane){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("18:00");
            else if(jour == JourInscription.MARDI) horairesDisponibles.add("18:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.JEUDI) horairesDisponibles.add("18:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("18:00");
            else if(jour == JourInscription.SAMEDI) horairesDisponibles.add("17:00");
            else if(jour == JourInscription.DIMANCHE) horairesDisponibles.add("18:00");
        }
        return horairesDisponibles;
    }

    //ETE - DU 22 JUILLET AU 4 SEPTEMBRE 2017
    private static List<String> recupererHorairesEte(JourInscription jour, DepartInscription depart, DepartInscription destination){
        List<String> horairesDisponibles = new ArrayList<>();
        if(depart == DepartInscription.Matane && destination == DepartInscription.Godbout){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("07:00");
            else if(jour == JourInscription.MARDI) horairesDisponibles.add("07:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("14:00");
            else if(jour == JourInscription.JEUDI) horairesDisponibles.add("07:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("07:00");
            else if(jour == JourInscription.DIMANCHE) horairesDisponibles.add("09:00");
        }
        else if(depart == DepartInscription.Godbout && destination == DepartInscription.Matane){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.MARDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("18:00");
            else if(jour == JourInscription.JEUDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.DIMANCHE) horairesDisponibles.add("12:00");
        }
        else if(depart == DepartInscription.Matane && destination == DepartInscription.Baie_Comeau){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("15:00");
            else if(jour == JourInscription.MARDI) horairesDisponibles.add("15:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("07:00");
            else if(jour == JourInscription.JEUDI) horairesDisponibles.add("15:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("15:00");
            else if(jour == JourInscription.SAMEDI){
                horairesDisponibles.add("08:00");
                horairesDisponibles.add("14:00");
            }
            else if(jour == JourInscription.DIMANCHE) horairesDisponibles.add("15:00");
        }
        else if(depart == DepartInscription.Baie_Comeau && destination == DepartInscription.Matane){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("18:00");
            else if(jour == JourInscription.MARDI) horairesDisponibles.add("18:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.JEUDI) horairesDisponibles.add("18:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("18:00");
            else if(jour == JourInscription.SAMEDI){
                horairesDisponibles.add("11:00");
                horairesDisponibles.add("17:00");
            }
            else if(jour == JourInscription.DIMANCHE) horairesDisponibles.add("18:00");
        }
        return horairesDisponibles;
    }

    //AUTOMNE - DU 5 SEPTEMBRE AU 9 OCTOBRE 2017
    private static List<String> recupererHorairesAutomne(JourInscription jour, DepartInscription depart, DepartInscription destination){
        List<String> horairesDisponibles = new ArrayList<>();
        if(depart == DepartInscription.Matane && destination == DepartInscription.Godbout){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("07:00");
            else if(jour == JourInscription.MARDI) horairesDisponibles.add("07:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("14:00");
            else if(jour == JourInscription.JEUDI) horairesDisponibles.add("07:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("07:00");
            else if(jour == JourInscription.SAMEDI) horairesDisponibles.add("08:00");
            else if(jour == JourInscription.DIMANCHE) horairesDisponibles.add("09:00");
        }
        else if(depart == DepartInscription.Godbout && destination == DepartInscription.Matane){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.MARDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("18:00");
            else if(jour == JourInscription.JEUDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.SAMEDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.DIMANCHE) horairesDisponibles.add("12:00");
        }
        else if(depart == DepartInscription.Matane && destination == DepartInscription.Baie_Comeau){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("15:00");
            else if(jour == JourInscription.MARDI) horairesDisponibles.add("15:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("07:00");
            else if(jour == JourInscription.JEUDI) horairesDisponibles.add("15:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("15:00");
            else if(jour == JourInscription.SAMEDI) horairesDisponibles.add("14:00");
            else if(jour == JourInscription.DIMANCHE) horairesDisponibles.add("15:00");
        }
        else if(depart == DepartInscription.Baie_Comeau && destination == DepartInscription.Matane){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("18:00");
            else if(jour == JourInscription.MARDI) horairesDisponibles.add("18:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.JEUDI) horairesDisponibles.add("18:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("18:00");
            else if(jour == JourInscription.SAMEDI) horairesDisponibles.add("17:00");
            else if(jour == JourInscription.DIMANCHE) horairesDisponibles.add("18:00");
        }
        return horairesDisponibles;
    }
}
