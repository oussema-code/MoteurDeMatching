public class CoupleAvecScore implements Comparable<CoupleAvecScore> {
    private Couple couple;
    private double score;

    public CoupleAvecScore(Couple couple, double score) {
        this.couple = couple;
        this.score = score;
    }
    public Couple getCouple() {
        return couple;
    }
    public double getScore() {
        return score;
    }
    public int compareTo(CoupleAvecScore other) {
        // Descending order: high score comes first
        return Double.compare(other.score, this.score);
    }
}
