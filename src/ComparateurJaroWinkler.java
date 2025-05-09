public class ComparateurJaroWinkler implements ComparateurDeChaine {


    public double comparer(Nom nom1, Nom nom2) {
        if (nom1 == null || nom2 == null || nom1.getNom() == null || nom2.getNom() == null) {
            return 0.0;
        }

        String s1 = nom1.getNom();
        String s2 = nom2.getNom();

        return jaroWinklerSimilarity(s1, s2);
    }

    private double jaroWinklerSimilarity(String s1, String s2) {
        // Calcul de la similarité Jaro
        double jaroSimilarity = jaroSimilarity(s1, s2);

        // Préfixe commun pour Winkler (maximum 4 caractères)
        int prefixLength = 0;
        int maxPrefixLength = Math.min(4, Math.min(s1.length(), s2.length()));

        for (int i = 0; i < maxPrefixLength; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                prefixLength++;
            } else {
                break;
            }
        }

        // Facteur de mise à l'échelle pour l'ajustement du préfixe (généralement 0.1)
        double scalingFactor = 0.1;

        // Calcul final de Jaro-Winkler
        return jaroSimilarity + (prefixLength * scalingFactor * (1 - jaroSimilarity));
    }

    private double jaroSimilarity(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) {
            return 1.0;
        }

        // Distance maximale pour considérer deux caractères comme correspondants
        int matchDistance = Math.max(s1.length(), s2.length()) / 2 - 1;
        matchDistance = Math.max(0, matchDistance); // Assurer une valeur non négative

        boolean[] s1Matches = new boolean[s1.length()];
        boolean[] s2Matches = new boolean[s2.length()];

        // Compter les correspondances
        int matchingChars = 0;
        for (int i = 0; i < s1.length(); i++) {
            int start = Math.max(0, i - matchDistance);
            int end = Math.min(i + matchDistance + 1, s2.length());

            for (int j = start; j < end; j++) {
                if (!s2Matches[j] && s1.charAt(i) == s2.charAt(j)) {
                    s1Matches[i] = true;
                    s2Matches[j] = true;
                    matchingChars++;
                    break;
                }
            }
        }

        if (matchingChars == 0) {
            return 0.0;
        }

        // Compter les transpositions
        int transpositions = 0;
        int k = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1Matches[i]) {
                while (!s2Matches[k]) {
                    k++;
                }

                if (s1.charAt(i) != s2.charAt(k)) {
                    transpositions++;
                }

                k++;
            }
        }

        // Calcul final de Jaro
        double m = matchingChars;
        return (m / s1.length() + m / s2.length() + (m - transpositions / 2.0) / m) / 3.0;
    }
}