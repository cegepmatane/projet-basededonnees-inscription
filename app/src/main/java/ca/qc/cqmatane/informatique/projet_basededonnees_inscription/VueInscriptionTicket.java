package ca.qc.cqmatane.informatique.projet_basededonnees_inscription;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Inscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Personne;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.GestionXML;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.TrancheAge;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.TypeInscription;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.modele.Vehicule;
import ca.qc.cqmatane.informatique.projet_basededonnees_inscription.outils.TypeVehicule;


public class VueInscriptionTicket extends AppCompatActivity {
    private Inscription inscription;
    private float prixTotalFinal;

    private TextView affichage_vue_inscription_numero_ticket;
    private TextView affichage_vue_inscription_prix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription_ticket);
        inscription = Inscription.getInstance();
        affichage_vue_inscription_numero_ticket = (TextView) findViewById(R.id.affichage_vue_inscription_numero_ticket);
        affichage_vue_inscription_prix = (TextView) findViewById(R.id.affichage_vue_inscription_prix);

        calculerPrixBillet();
        affichage_vue_inscription_prix.setText(prixTotalFinal + "");

        String numeroInscription = GestionXML.getInstance(getApplicationContext()).getNumeroInscription();
        affichage_vue_inscription_numero_ticket.setText(numeroInscription);
    }

    /**
     * Calcule le prix total du billet
     * @return le prix du billet
     */
    private void calculerPrixBillet() {
        calculerPrixParPersonne();
        calculerPrixParVehicule();
        float rabais = calculerLeRabais() * 100;
        prixTotalFinal *= 1 + rabais;
    }

    /**
     * Calcule si il y a un pourcentage de rabais
     */
    private float calculerLeRabais() {
        float rabais;
        if(inscription.getListePersonnes().size() >= 15 && inscription.getListePersonnes().size() <= 30)
            rabais = 10;
        else if(inscription.getListePersonnes().size() >= 31)
            rabais = 15;
        else
            rabais = 0;
        return rabais;
    }

    /**
     * Calcule le prix de chaque personne et l'ajoute au prix finale
     */
    private void calculerPrixParPersonne() {
        for(Personne personneCourante : inscription.getListePersonnes()) {
            if (inscription.getType() == TypeInscription.Simple) {
                if(personneCourante.getAge() == TrancheAge.DE0a4 || personneCourante.isAccompagnateur() == true)
                    prixTotalFinal += 0;
                else if(personneCourante.getAge() == TrancheAge.DE5a15)
                    prixTotalFinal += 12.20;
                else if(personneCourante.getAge() == TrancheAge.DE16a64)
                    prixTotalFinal += 19.85;
                else if(personneCourante.getAge() == TrancheAge.DE65aPLUS)
                    prixTotalFinal += 16.80;
            }

            if (inscription.getType() == TypeInscription.Retour) {
                if(personneCourante.getAge() == TrancheAge.DE0a4 || personneCourante.isAccompagnateur() == true)
                    prixTotalFinal += 0;
                else if(personneCourante.getAge() == TrancheAge.DE5a15)
                    prixTotalFinal += 20;
                else if(personneCourante.getAge() == TrancheAge.DE16a64)
                    prixTotalFinal += 32;
                else if(personneCourante.getAge() == TrancheAge.DE65aPLUS)
                    prixTotalFinal += 27;
            }
        }
    }

    /**
     * Calcule le prix de tout les véhicule et les ajoute au prix final total
     */
    private void calculerPrixParVehicule() {
        for(Vehicule vehiculeCourant : inscription.getListeVehicules()) {
            if(vehiculeCourant.getType() == TypeVehicule.Vehicule) {
                if (vehiculeCourant.getLongueur() <= 6.4) {
                    prixTotalFinal += 80;
                }
                else if(vehiculeCourant.getLongueur() >= 6.4) {
                    int longeurEnPlus = (int) (vehiculeCourant.getLongueur() - 6.4);
                    prixTotalFinal += (80 + (longeurEnPlus * 19.40));
                }
            }

            else if(vehiculeCourant.getType() == TypeVehicule.Vehicule_qui_tire_un_autre_element) {
                if (vehiculeCourant.getLongueur() <= 9.4) {
                    prixTotalFinal += 48.40;
                }
                else if(vehiculeCourant.getLongueur() >= 9.4) {
                    int longeurEnPlus = (int) (vehiculeCourant.getLongueur() - 9.4);
                    prixTotalFinal += (48.40 + (longeurEnPlus * 19.40));
                }
            }

            else if(vehiculeCourant.getType() == TypeVehicule.Camion) {
                if (vehiculeCourant.getLargeur() <= 2.6) {
                    prixTotalFinal += vehiculeCourant.getLargeur() * 19.40;
                }
                else if(vehiculeCourant.getLongueur() >= 2.6) {
                    prixTotalFinal += vehiculeCourant.getLargeur() * 19.40;
                }
            }

            else if(vehiculeCourant.getType() == TypeVehicule.Motocyclette) {
                if (vehiculeCourant.getLargeur() <= 2.6) {
                    prixTotalFinal += vehiculeCourant.getLargeur() * 38.65;
                }
            }
        }
    }



}
