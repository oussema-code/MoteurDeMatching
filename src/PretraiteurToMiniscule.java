import java.util.ArrayList;
import java.util.List;
public class PretraiteurToMiniscule implements Pretraiteur {
    public List<Nom> traiter(List<Nom> ListeDeNom){
        List<Nom> ListeDeMiniscule = new ArrayList<Nom>();
        for(Nom nom : ListeDeNom){
            nom.getNom().toLowerCase();
            ListeDeMiniscule.add(nom);

        }
        return ListeDeMiniscule;

    }
}
