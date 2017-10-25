package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import org.junit.Test;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.DepartInscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.VerificationHoraire;

import static org.junit.Assert.*;

public class TestVerificationHoraire {
    @Test
    public void testPrintempsAvrilMataneGodboutLundi(){
        assertEquals("08:00", VerificationHoraire.recupererHoraire(10, 4, 2017, DepartInscription.Matane, DepartInscription.Godbout).get(0));
    }
}
