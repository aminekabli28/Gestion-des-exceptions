package EX1;

public class Main {
    public static void main(String[] args) {
        try {
            EntierNaturel entier = new EntierNaturel(-5);
        } catch (NombreNegatifException e) {
            System.out.println("Erreur : " + e.getMessage());
            System.out.println("Valeur erronée : " + e.getValeurErronee());
        }

        EntierNaturel entier = null;
        try {
            entier = new EntierNaturel(10);
            entier.setVal(-3);
        } catch (NombreNegatifException e) {
            System.out.println("Erreur : " + e.getMessage());
            System.out.println("Valeur erronée : " + e.getValeurErronee());
        }

        try {
            entier.decrementer();
        } catch (NombreNegatifException e) {
            System.out.println("Erreur : " + e.getMessage());
            System.out.println("Valeur erronée : " + e.getValeurErronee());
        }
    }
}
