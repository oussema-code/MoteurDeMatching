import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionneurDeNMeilleur implements Selectionneur {
    private int nombreMax ;

    public SelectionneurDeNMeilleur(int N) {
        this.nombreMax = N;
    }
    public List<Nom> selectionner(List<CoupleAvecScore> coupleAvecScores){
        List<Nom> noms = new ArrayList<Nom>();
        Collections.sort(coupleAvecScores);
        for(int i=0;i<Math.min(coupleAvecScores.size(),this.nombreMax);i++){
            noms.add(coupleAvecScores.get(i).getCouple().getNom2());
        }
        return noms;
    }
}
