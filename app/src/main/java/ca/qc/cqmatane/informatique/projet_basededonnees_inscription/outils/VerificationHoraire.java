package ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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

    private static final String JOUR_AVANT_HIVER = "09/10/2017";
    private static final String JOUR_APRES_HIVER = "01/04/2018";

    private static final String JOUR_FETES_1 = "23/12/2017";
    private static final String JOUR_FETES_2 = "24/12/2017";
    private static final String JOUR_FETES_3 = "26/12/2017";
    private static final String JOUR_FETES_4 = "28/12/2017";
    private static final String JOUR_FETES_5 = "30/12/2017";
    private static final String JOUR_FETES_6 = "31/12/2017";
    private static final String JOUR_FETES_7 = "02/01/2018";

    private static final String JOUR_SANS_TRAVERSEE_1 = "25/12/2017";
    private static final String JOUR_SANS_TRAVERSEE_2 = "01/01/2018";

    /**
     * Fonction principale qui renvoie les horaires disponibles en fonction de la date
     * @param jour Jour de la date à vérifier
     * @param mois Mois de la date à vérifier
     * @param annee Année de la date à vérifier
     * @param depart Destination de départ
     * @param destination Destination d'arrivée
     * @return Liste des horaires disponibles en String
     */
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

            //On récupère la date actuelle pour la comparer par la suite
            Date dateVerifiee = c.getTime();

            //On vérifie si la date correspond à la période où il n'y a pas de traversée
            if(dateVerifiee.equals(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_SANS_TRAVERSEE_1))
                    || dateVerifiee.equals(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_SANS_TRAVERSEE_2))){
                return new ArrayList<>(); // On renvoie une liste vide puisque qu'il n'y a aucune traversée lors de ces dates
            }
            //On vérifie si la date correspond à la période des fêtes
            else if(dateVerifiee.equals(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_FETES_1))
                    || dateVerifiee.equals(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_FETES_2))
                    || dateVerifiee.equals(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_FETES_3))
                    || dateVerifiee.equals(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_FETES_4))
                    || dateVerifiee.equals(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_FETES_5))
                    || dateVerifiee.equals(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_FETES_6))
                    || dateVerifiee.equals(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_FETES_7))){
                return recupererHorairesFetes(depart, destination);
            }
            //On vérifie si la date correspond à la période Printemps Avril
            else if(dateVerifiee.after(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_AVANT_PRINTEMPS_AVRIL))
                    && dateVerifiee.before(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_APRES_PRINTEMPS_AVRIL))){
                return recupererHorairesPrintempsAvril(jourVerifie, depart, destination);
            }
            //On vérifie si la date correspond à la période Printemps Mai Juillet
            else if(dateVerifiee.after(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_AVANT_PRINTEMPS_MAI_JUILLET))
                    && dateVerifiee.before(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_APRES_PRINTEMPS_MAI_JUILLET))){
                return recupererHorairesPrintempsMaiJuillet(jourVerifie, depart, destination);
            }
            //On vérifie si la date correspond à la période Été
            else if(dateVerifiee.after(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_AVANT_ETE))
                    && dateVerifiee.before(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_APRES_ETE))){
                return recupererHorairesEte(jourVerifie, depart, destination);
            }
            //On vérifie si la date correspond à la période Automne
            else if(dateVerifiee.after(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_AVANT_AUTOMNE))
                    && dateVerifiee.before(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_APRES_AUTOMNE))){
                return recupererHorairesAutomne(jourVerifie, depart, destination);
            }
            //On vérifie si la date correspond à la période Hiver
            else if(dateVerifiee.after(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_AVANT_HIVER))
                    && dateVerifiee.before(new SimpleDateFormat(FORMAT_DATE).parse(JOUR_APRES_HIVER))){
                return recupererHorairesHiver(jourVerifie, depart, destination);
            }

        }
        catch(Exception e){
            System.out.println("Mauvaise date envoyée !");
        }

        return new ArrayList<>(); // On renvoie une liste vide puisque aucune date n'a été trouvée
    }

    public static List<HashMap<String, String>> recupererHoraireEnHashMap(int jour, int mois, int annee, DepartInscription depart, DepartInscription destination, String cleHashMap){
        List<HashMap<String, String>> listeHoraireEnHashMap = new ArrayList<>();

        List<String> listeHoraireDisponible = recupererHoraire(jour, mois, annee, depart, destination);

        for(String horaire : listeHoraireDisponible){
            HashMap<String, String> horaireEnHashMap = new HashMap<>();
            horaireEnHashMap.put(cleHashMap, horaire);
            listeHoraireEnHashMap.add(horaireEnHashMap);
        }

        return listeHoraireEnHashMap;
    }

    public static boolean horaireDisponible(int jour, int mois, int annee, DepartInscription depart, DepartInscription destination){
        return !recupererHoraire(jour, mois, annee, depart, destination).isEmpty();
    }

    //FETES
    private static List<String> recupererHorairesFetes(DepartInscription depart, DepartInscription destination){
        List<String> horairesDisponibles = new ArrayList<>();
        if(depart == DepartInscription.Matane && destination == DepartInscription.Godbout){
            horairesDisponibles.add("08:00");
        }
        else if(depart == DepartInscription.Godbout && destination == DepartInscription.Matane){
            horairesDisponibles.add("11:00");
        }
        else if(depart == DepartInscription.Matane && destination == DepartInscription.Baie_Comeau){
            horairesDisponibles.add("14:00");
        }
        else if(depart == DepartInscription.Baie_Comeau && destination == DepartInscription.Matane){
            horairesDisponibles.add("17:00");
        }
        return horairesDisponibles;
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

    //HIVER - DU 10 OCTOBRE 2017 AU 31 MARS 2018
    private static List<String> recupererHorairesHiver(JourInscription jour, DepartInscription depart, DepartInscription destination){
        List<String> horairesDisponibles = new ArrayList<>();
        if(depart == DepartInscription.Matane && destination == DepartInscription.Godbout){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("08:00");
            else if(jour == JourInscription.MARDI) horairesDisponibles.add("08:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("14:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("08:00");
            else if(jour == JourInscription.SAMEDI) horairesDisponibles.add("08:00");
        }
        else if(depart == DepartInscription.Godbout && destination == DepartInscription.Matane){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.MARDI) horairesDisponibles.add("17:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("17:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.SAMEDI) horairesDisponibles.add("11:00");
        }
        else if(depart == DepartInscription.Matane && destination == DepartInscription.Baie_Comeau){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("14:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("08:00");
            else if(jour == JourInscription.JEUDI) horairesDisponibles.add("08:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("14:00");
            else if(jour == JourInscription.DIMANCHE) horairesDisponibles.add("15:00");
        }
        else if(depart == DepartInscription.Baie_Comeau && destination == DepartInscription.Matane){
            if(jour == JourInscription.LUNDI) horairesDisponibles.add("17:00");
            else if(jour == JourInscription.MERCREDI) horairesDisponibles.add("11:00");
            else if(jour == JourInscription.JEUDI) horairesDisponibles.add("17:00");
            else if(jour == JourInscription.VENDREDI) horairesDisponibles.add("17:00");
            else if(jour == JourInscription.DIMANCHE) horairesDisponibles.add("18:00");
        }
        return horairesDisponibles;
    }
}
