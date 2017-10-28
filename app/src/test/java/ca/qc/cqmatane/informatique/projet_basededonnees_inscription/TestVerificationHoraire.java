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

    @Test
    public void testEteMataneGodbout(){
        assertEquals("07:00", VerificationHoraire.recupererHoraire(24, 7, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("07:00", VerificationHoraire.recupererHoraire(25, 7, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("14:00", VerificationHoraire.recupererHoraire(26, 7, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("07:00", VerificationHoraire.recupererHoraire(27, 7, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("07:00", VerificationHoraire.recupererHoraire(28, 7, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertTrue(VerificationHoraire.recupererHoraire(29, 7, 2017, DepartInscription.Matane, DepartInscription.Godbout).isEmpty());
        assertEquals("09:00", VerificationHoraire.recupererHoraire(30, 7, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
    }
    @Test
    public void testEteGodboutMatane(){
        assertEquals("11:00", VerificationHoraire.recupererHoraire(7, 8, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(8, 8, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("18:00", VerificationHoraire.recupererHoraire(9, 8, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(10, 8, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(11, 8, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertTrue(VerificationHoraire.recupererHoraire(12, 8, 2017, DepartInscription.Godbout, DepartInscription.Matane).isEmpty());
        assertEquals("12:00", VerificationHoraire.recupererHoraire(13, 8, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
    }
    @Test
    public void testEteMataneBaieComeau(){
        assertEquals("15:00", VerificationHoraire.recupererHoraire(21, 8, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("15:00", VerificationHoraire.recupererHoraire(22, 8, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("07:00", VerificationHoraire.recupererHoraire(23, 8, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("15:00", VerificationHoraire.recupererHoraire(24, 8, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("15:00", VerificationHoraire.recupererHoraire(25, 8, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("08:00", VerificationHoraire.recupererHoraire(26, 8, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("14:00", VerificationHoraire.recupererHoraire(26, 8, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(1));
        assertEquals("15:00", VerificationHoraire.recupererHoraire(27, 8, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
    }
    @Test
    public void testEteBaieComeauMatane(){
        assertEquals("18:00", VerificationHoraire.recupererHoraire(4, 9, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("18:00", VerificationHoraire.recupererHoraire(18, 8, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(19, 8, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("18:00", VerificationHoraire.recupererHoraire(20, 8, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("18:00", VerificationHoraire.recupererHoraire(1, 9, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(2, 9, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("17:00", VerificationHoraire.recupererHoraire(2, 9, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(1));
        assertEquals("18:00", VerificationHoraire.recupererHoraire(3, 9, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
    }

    @Test
    public void testAutomneMataneGodbout(){
        assertEquals("07:00", VerificationHoraire.recupererHoraire(11, 9, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("07:00", VerificationHoraire.recupererHoraire(12, 9, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("14:00", VerificationHoraire.recupererHoraire(13, 9, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("07:00", VerificationHoraire.recupererHoraire(14, 9, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("07:00", VerificationHoraire.recupererHoraire(15, 9, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("08:00", VerificationHoraire.recupererHoraire(16, 9, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("09:00", VerificationHoraire.recupererHoraire(17, 9, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
    }
    @Test
    public void testAutomneGodboutMatane(){
        assertEquals("11:00", VerificationHoraire.recupererHoraire(18, 9, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(19, 9, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("18:00", VerificationHoraire.recupererHoraire(20, 9, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(21, 9, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(22, 9, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(23, 9, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("12:00", VerificationHoraire.recupererHoraire(24, 9, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
    }
    @Test
    public void testAutomneMataneBaieComeau(){
        assertEquals("15:00", VerificationHoraire.recupererHoraire(25, 9, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("15:00", VerificationHoraire.recupererHoraire(26, 9, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("07:00", VerificationHoraire.recupererHoraire(27, 9, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("15:00", VerificationHoraire.recupererHoraire(28, 9, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("15:00", VerificationHoraire.recupererHoraire(29, 9, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("14:00", VerificationHoraire.recupererHoraire(30, 9, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("15:00", VerificationHoraire.recupererHoraire(3, 9, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
    }
    @Test
    public void testAutomneBaieComeauMatane(){
        assertEquals("18:00", VerificationHoraire.recupererHoraire(2, 10, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("18:00", VerificationHoraire.recupererHoraire(3, 10, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(4, 10, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("18:00", VerificationHoraire.recupererHoraire(5, 10, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("18:00", VerificationHoraire.recupererHoraire(6, 10, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("17:00", VerificationHoraire.recupererHoraire(7, 10, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("18:00", VerificationHoraire.recupererHoraire(8, 10, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
    }

    @Test
    public void testHiverMataneGodbout(){
        assertEquals("08:00", VerificationHoraire.recupererHoraire(16, 10, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("08:00", VerificationHoraire.recupererHoraire(10, 10, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("14:00", VerificationHoraire.recupererHoraire(11, 10, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertTrue(VerificationHoraire.recupererHoraire(12, 10, 2017, DepartInscription.Matane, DepartInscription.Godbout).isEmpty());
        assertEquals("08:00", VerificationHoraire.recupererHoraire(13, 10, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertEquals("08:00", VerificationHoraire.recupererHoraire(14, 10, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
        assertTrue(VerificationHoraire.recupererHoraire(15, 10, 2017, DepartInscription.Matane, DepartInscription.Godbout).isEmpty());
    }
    @Test
    public void testHiverGodboutMatane(){
        assertEquals("11:00", VerificationHoraire.recupererHoraire(11, 12, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("17:00", VerificationHoraire.recupererHoraire(12, 12, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("17:00", VerificationHoraire.recupererHoraire(13, 12, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertTrue(VerificationHoraire.recupererHoraire(14, 12, 2017, DepartInscription.Godbout, DepartInscription.Matane).isEmpty());
        assertEquals("11:00", VerificationHoraire.recupererHoraire(15, 12, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertEquals("11:00", VerificationHoraire.recupererHoraire(16, 12, 2017, DepartInscription.Godbout, DepartInscription.Matane).get(0));
        assertTrue(VerificationHoraire.recupererHoraire(17, 12, 2017, DepartInscription.Godbout, DepartInscription.Matane).isEmpty());
    }
    @Test
    public void testHiverMataneBaieComeau(){
        assertEquals("14:00", VerificationHoraire.recupererHoraire(5, 2, 2018, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertTrue(VerificationHoraire.recupererHoraire(6, 2, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).isEmpty());
        assertEquals("08:00", VerificationHoraire.recupererHoraire(7, 2, 2018, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("08:00", VerificationHoraire.recupererHoraire(8, 2, 2018, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertEquals("14:00", VerificationHoraire.recupererHoraire(9, 2, 2018, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
        assertTrue(VerificationHoraire.recupererHoraire(10, 2, 2017, DepartInscription.Matane, DepartInscription.Baie_Comeau).isEmpty());
        assertEquals("15:00", VerificationHoraire.recupererHoraire(11, 2, 2018, DepartInscription.Matane, DepartInscription.Baie_Comeau).get(0));
    }
    @Test
    public void testHiverBaieComeauMatane(){
        assertEquals("17:00", VerificationHoraire.recupererHoraire(26, 3, 2018, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertTrue(VerificationHoraire.recupererHoraire(27, 3, 2017, DepartInscription.Baie_Comeau, DepartInscription.Matane).isEmpty());
        assertEquals("11:00", VerificationHoraire.recupererHoraire(28, 3, 2018, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("17:00", VerificationHoraire.recupererHoraire(29, 3, 2018, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertEquals("17:00", VerificationHoraire.recupererHoraire(30, 3, 2018, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
        assertTrue(VerificationHoraire.recupererHoraire(31, 3, 2018, DepartInscription.Baie_Comeau, DepartInscription.Matane).isEmpty());
        assertEquals("18:00", VerificationHoraire.recupererHoraire(25, 3, 2018, DepartInscription.Baie_Comeau, DepartInscription.Matane).get(0));
    }
}
