import java.util.Objects;

public class EgaliteExacte implements ComparateurDeChaine {

    public double comparer(Nom nom1, Nom nom2) {
        if (nom1 == null || nom2 == null) {
            return 0.0;
        }
        return Objects.equals(nom1.getNom(), nom2.getNom()) ? 1.0 : 0.0;
    }
}
