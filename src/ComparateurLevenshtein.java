public class ComparateurLevenshtein implements ComparateurDeChaine {


    public double comparer(Nom nom1, Nom nom2) {
        if (nom1 == null || nom2 == null || nom1.getNom() == null || nom2.getNom() == null) {
            return 0.0;
        }
        String s1 = nom1.getNom().toLowerCase();
        String s2 = nom2.getNom().toLowerCase();
        // Calcul de la distance de Levenshtein
        int[][] distance = new int[s1.length() + 1][s2.length() + 1];
        // Initialisation
        for (int i = 0; i <= s1.length(); i++) {
            distance[i][0] = i;
        }
        for (int j = 0; j <= s2.length(); j++) {
            distance[0][j] = j;
        }
        // Calcul de la distance
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int cout = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                distance[i][j] = Math.min(
                        Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1),
                        distance[i - 1][j - 1] + cout
                );
            }
        }
        // Normalisation du score (1.0 = identique, 0.0 = complètement différent)
        int maxLength = Math.max(s1.length(), s2.length());
        if (maxLength == 0) {
            return 1.0; // Deux chaînes vides sont identiques
        }
        double similarite = 1.0 - ((double) distance[s1.length()][s2.length()] / maxLength);
        return similarite;
    }
}