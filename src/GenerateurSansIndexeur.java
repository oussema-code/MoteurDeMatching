import java.util.ArrayList;
import java.util.List;

public class GenerateurSansIndexeur implements GenerateurDeCandidats {
    private int differnceDeLongeur;

    public GenerateurSansIndexeur(int differnceDeLongeur) {
        this.differnceDeLongeur = differnceDeLongeur;
    }
    public List<Couple> generer(List<Nom> noms1, List<Nom> noms2) {
        List<Couple> resultats = new ArrayList<>();

        for (Nom n1 : noms1) {
            int len1 = n1.getNom().length();
            for (Nom n2 : noms2) {
                int len2 = n2.getNom().length();
                if (Math.abs(len1 - len2) <= differnceDeLongeur) {
                    resultats.add(new Couple(n1, n2));
                }
            }
        }
        return resultats;
    }
}