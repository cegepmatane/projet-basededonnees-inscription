package ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class VerificationHoraire {

    public static List<String> recupererHoraire(int jour, int mois, int annee, DepartInscription depart, DepartInscription destination){

        List<String> horairesDisponibles = new ArrayList<>();

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
        }
        catch(Exception e){
            System.out.println("Mauvaise date envoyée !");
        }
        return horairesDisponibles;
    }

    //PRINTEMPS - DU 1ER AU 30 AVRIL 2017
    public static List<String> recupererHorairesPrintempsAvril(JourInscription jour, DepartInscription depart, DepartInscription destination){
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
