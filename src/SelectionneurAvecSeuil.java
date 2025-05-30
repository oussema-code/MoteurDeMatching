import java.util.ArrayList;
import java.util.List;

public class SelectionneurAvecSeuil implements Selectionneur {
    private final double  seuil;
    public SelectionneurAvecSeuil(double seuil) {
        this.seuil = seuil;
    }
    public List<Nom> selectionner(List<CoupleAvecScore> coupleAvecScores){
        List<Nom> names= new ArrayList<>();
        for(CoupleAvecScore coupleAvecScore : coupleAvecScores){
            if(coupleAvecScore.getScore() >= seuil ){
                names.add(coupleAvecScore.getCouple().getNom2());

            }
        }
        return names;
    }
}
