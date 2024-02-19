package EX2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<CompteBancaire> comptes = new ArrayList<>();

        CompteBancaire compte1 = new CompteBancaire("123", 1000, "John Doe");
        CompteCourant compte2 = new CompteCourant("456", 500, "Jane Smith", 100);
        CompteEpargne compte3 = new CompteEpargne("789", 2000, "Alice Johnson", 5);

        comptes.add(compte1);
        comptes.add(compte2);
        comptes.add(compte3);

        // Retrait avec fonds suffisants
        try {
            compte1.retirer(200);
        } catch (FondsInsuffisantsException e) {
            System.out.println(e.getMessage());
        }

        // Retrait avec fonds insuffisants
        try {
            compte1.retirer(2000);
        } catch (FondsInsuffisantsException e) {
            System.out.println(e.getMessage());
        }

        // Transfert avec compte destinataire inexistant
        try {
            compte1.transferer(null, 500);
        } catch (FondsInsuffisantsException | CompteInexistantException e) {
            System.out.println(e.getMessage());
        }

        // Transfert avec fonds suffisants et compte destinataire existant
        try {
            compte1.transferer(compte2, 300);
        } catch (FondsInsuffisantsException | CompteInexistantException e) {
            System.out.println(e.getMessage());
        }

        // Affichage des soldes
        for (CompteBancaire compte : comptes) {
            compte.afficherSolde();
        }
    }
}