import java.util.ArrayList;
import java.util.List;

public class PretraiteurCaractereSpeciaux {
    public List<Nom> traiter(List<Nom> listeDeNom){
        List<Nom> ListeFiltre = new ArrayList<Nom>();
        for(Nom nom : listeDeNom){
            String nomStr = nom.getNom();
            nomStr = nomStr.replaceAll("[^A-Za-z]", " ");
            nomStr=nomStr.replaceAll("(?i)\\b(ibn|bn)\\b","ben");
            Nom nouveauNom=new Nom(nomStr,nom.getId());
            ListeFiltre.add(nouveauNom);
        }
        return ListeFiltre;
    }
}
