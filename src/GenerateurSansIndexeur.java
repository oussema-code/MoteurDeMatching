import java.util.*;

public class GenerateurSansIndexeur implements GenerateurDeCandidats {

    public List<Couple> generer(List<Nom> noms1, List<Nom> noms2) {
        List<Couple> couples = new ArrayList<>();

        for (Nom nom1 : noms1) {
            int longueur = nom1.getNom().length();
            double marge = longueur * 0.2;
            int min = (int) Math.floor(longueur - marge);
            int max = (int) Math.ceil(longueur + marge);

            for (Nom nom2 : noms2) {
                int len = nom2.getNom().length();
                if (len >= min && len <= max) {
                    couples.add(new Couple(nom1, nom2));
                }
            }
        }

        return couples;
    }
}
