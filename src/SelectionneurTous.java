import java.util.ArrayList;
import java.util.List;

public class SelectionneurTous implements Selectionneur {
    public List<Nom> selectionner(List<CoupleAvecScore> coupleAvecScores){
        List<Nom> names= new ArrayList<>();
        for(CoupleAvecScore coupleAvecScore : coupleAvecScores){

            names.add(coupleAvecScore.getCouple().getNom2());

        }
        return names;
    }
}
