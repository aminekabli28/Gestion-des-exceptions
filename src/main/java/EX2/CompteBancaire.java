package EX2;

class CompteBancaire {
    protected String numeroCompte;
    protected double solde;
    protected String nomTitulaire;

    public CompteBancaire(String numeroCompte, double solde, String nomTitulaire) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.nomTitulaire = nomTitulaire;
    }

    public void deposer(double montant) {
        solde += montant;
    }

    public void retirer(double montant) throws FondsInsuffisantsException {
        if (solde < montant) {
            throw new FondsInsuffisantsException("Fonds insuffisants pour effectuer le retrait.");
        }
        solde -= montant;
    }

    public void afficherSolde() {
        System.out.println("Solde du compte " + numeroCompte + " : " + solde);
    }

    public void transferer(CompteBancaire compteDestinataire, double montant) throws FondsInsuffisantsException, CompteInexistantException {
        if (solde < montant) {
            throw new FondsInsuffisantsException("Fonds insuffisants pour effectuer le transfert.");
        }
        if (compteDestinataire == null) {
            throw new CompteInexistantException("Compte destinataire inexistant.");
        }
        retirer(montant);
        compteDestinataire.deposer(montant);
    }
}