package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import org.junit.Test;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.DepartInscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.VerificationHoraire;

import static org.junit.Assert.*;

public class TestVerificationHoraire {
    @Test
    public void testPrintempsAvrilMataneGodbout(){
        assertEquals("08:00", VerificationHoraire.recupererHoraire(10, 4, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("08:00", VerificationHoraire.recupererHoraire(11, 4, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("14:00", VerificationHoraire.recupererHoraire(12, 4, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("08:00", VerificationHoraire.recupererHoraire(13, 4, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("08:00", VerificationHoraire.recupererHoraire(14, 4, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("08:00", VerificationHoraire.recupererHoraire(15, 4, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("09:00", VerificationHoraire.recupererHoraire(16, 4, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
    }
    @Test
    public void testPrintempsAvrilGodboutMatane(){
        assertEquals("11:00", VerificationHoraire.recupererHoraire(10, 4, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(11, 4, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("17:00", VerificationHoraire.recupererHoraire(12, 4, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(13, 4, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(14, 4, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(15, 4, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("12:00", VerificationHoraire.recupererHoraire(16, 4, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
    }
    @Test
    public void testPrintempsAvrilMataneBaieComeau(){
        assertEquals("14:00", VerificationHoraire.recupererHoraire(10, 4, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("14:00", VerificationHoraire.recupererHoraire(11, 4, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("08:00", VerificationHoraire.recupererHoraire(12, 4, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("14:00", VerificationHoraire.recupererHoraire(13, 4, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("14:00", VerificationHoraire.recupererHoraire(14, 4, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("14:00", VerificationHoraire.recupererHoraire(15, 4, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("15:00", VerificationHoraire.recupererHoraire(16, 4, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
    }
    @Test
    public void testPrintempsAvrilBaieComeauMatane(){
        assertEquals("17:00", VerificationHoraire.recupererHoraire(10, 4, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("17:00", VerificationHoraire.recupererHoraire(11, 4, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(12, 4, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("17:00", VerificationHoraire.recupererHoraire(13, 4, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("17:00", VerificationHoraire.recupererHoraire(14, 4, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("17:00", VerificationHoraire.recupererHoraire(15, 4, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("18:00", VerificationHoraire.recupererHoraire(16, 4, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
    }

    @Test
    public void testPrintempsMaiJuilletMataneGodbout(){
        assertEquals("07:00", VerificationHoraire.recupererHoraire(8, 5, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("07:00", VerificationHoraire.recupererHoraire(9, 5, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("14:00", VerificationHoraire.recupererHoraire(10, 5, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("07:00", VerificationHoraire.recupererHoraire(11, 5, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("07:00", VerificationHoraire.recupererHoraire(12, 5, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("08:00", VerificationHoraire.recupererHoraire(13, 5, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("09:00", VerificationHoraire.recupererHoraire(14, 5, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
    }
    @Test
    public void testPrintempsMaiJuilletGodboutMatane(){
        assertEquals("11:00", VerificationHoraire.recupererHoraire(10, 7, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(11, 7, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("18:00", VerificationHoraire.recupererHoraire(12, 7, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(13, 7, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(14, 7, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(15, 7, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("12:00", VerificationHoraire.recupererHoraire(16, 7, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
    }
    @Test
    public void testPrintempsMaiJuilletMataneBaieComeau(){
        assertEquals("15:00", VerificationHoraire.recupererHoraire(1, 5, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("15:00", VerificationHoraire.recupererHoraire(2, 5, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("07:00", VerificationHoraire.recupererHoraire(3, 5, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("15:00", VerificationHoraire.recupererHoraire(4, 5, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("15:00", VerificationHoraire.recupererHoraire(5, 5, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("14:00", VerificationHoraire.recupererHoraire(6, 5, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("15:00", VerificationHoraire.recupererHoraire(7, 5, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
    }
    @Test
    public void testPrintempsMaiJuilletBaieComeauMatane(){
        assertEquals("18:00", VerificationHoraire.recupererHoraire(17, 7, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("18:00", VerificationHoraire.recupererHoraire(18, 7, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(19, 7, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("18:00", VerificationHoraire.recupererHoraire(20, 7, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("18:00", VerificationHoraire.recupererHoraire(21, 7, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("17:00", VerificationHoraire.recupererHoraire(15, 7, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("18:00", VerificationHoraire.recupererHoraire(16, 7, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
    }
}
