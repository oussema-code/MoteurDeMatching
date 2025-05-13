import java.util.*;

public class GenerateurAvecIndexeur implements GenerateurDeCandidats {
    public List<Couple> generer(List<Nom> noms1, List<Nom> noms2) {
        List<Couple> couples = new ArrayList<>();
        IndexeurDictionnaire indexeur = new IndexeurDictionnaire();
        Map<Integer, List<Nom>> index = (Map<Integer, List<Nom>>) indexeur.indexer(noms2);
        for (Nom nom1 : noms1) {
            int longueur = nom1.getNom().length();
            double marge = longueur * 0.2;
            int min = (int) Math.floor(longueur - marge);
            int max = (int) Math.ceil(longueur + marge);
            for (int key : index.keySet()) {
                if (key >= min && key <= max) {
                    for (Nom nom2 : index.get(key)) {
                        couples.add(new Couple(nom1, nom2));
                    }
                }
            }
        }
        return couples;
    }
}