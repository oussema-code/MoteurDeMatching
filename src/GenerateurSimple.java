import java.util.ArrayList;
import java.util.List;

public class GenerateurSimple implements GenerateurDeCandidats {

    public List<Couple> generer(List<Nom> noms1, List<Nom> noms2) {
        List<Couple> resultats = new ArrayList<>();

        for (Nom n1 : noms1) {
            for (Nom n2 : noms2) {
                    resultats.add(new Couple(n1, n2));
            }
        }
        return resultats;
    }
}