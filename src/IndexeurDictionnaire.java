import java.util.*;

public class IndexeurDictionnaire implements Indexeur<Object> {

    public Object indexer(List<Nom> noms) {
        Map<Integer, List<Nom>> names = new HashMap<>();

        for (Nom nom : noms) {
            int longueur = nom.getNom().length();
            if (!names.containsKey(longueur)) {
                names.put(longueur, new ArrayList<>());
            }
            names.get(longueur).add(nom);
        }

        return names;
    }
}
