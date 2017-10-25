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
}
