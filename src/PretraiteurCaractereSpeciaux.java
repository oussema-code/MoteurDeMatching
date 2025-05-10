import java.text.Normalizer;
import java.util.*;

public class PretraiteurCaractereSpeciaux implements Pretraiteur {

    public List<Nom> traiter(List<Nom> listeDeNom) {
        List<Nom> resultat = new ArrayList<>();

        for (Nom nom : listeDeNom) {
            String nomNettoyer = nettoyerCaractereSpeciaux(nom.getNom());
            resultat.add(new Nom(nomNettoyer, nom.getId()));
        }
        return resultat;
    }

    private String nettoyerCaractereSpeciaux(String texte) {
        // Supprimer les accents (unicode normalization)
        String normalise = Normalizer.normalize(texte, Normalizer.Form.NFD);
        return normalise.replaceAll("\\p{M}", "") // supprime les marques diacritiques et les accents
                .replaceAll("[^a-zA-Z]", ""); // supprime les caractères spéciaux restants
    }
}
