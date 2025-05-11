import java.util.*;

public class PretraiteurBenStandardizer implements Pretraiteur {
    public List<Nom> traiter(List<Nom> noms) {
        List<Nom> resultat = new ArrayList<>();

        for (Nom nom : noms) {
            String nomNettoye = standardiserBen(nom.getNom());
            resultat.add(new Nom(nomNettoye, nom.getId()));
        }

        return resultat;
    }

    private String standardiserBen(String nom) {
        // Normaliser le texte en minuscule pour éviter les cas sensibles
        nom = nom.toLowerCase();

        // Remplacer les variantes de "ben" uniquement si ce sont des mots séparés
        nom = nom.replaceAll("\\b(iben|ibn|bn|abo|abou|aba|bin)\\b", "ben");

        return nom;
    }
}
