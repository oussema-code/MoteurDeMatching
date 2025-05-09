import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double s = 1;
        Scanner sc = new Scanner(System.in);
        int differnceDeLongeur = 5;

        SelectionneurAvecSeuil selectionneurAvecSeuil = new SelectionneurAvecSeuil(s);
        EgaliteExacte comparateur = new EgaliteExacte();
        GenerateurSansIndexeur generateur = new GenerateurSansIndexeur(differnceDeLongeur);
        MoteurDeMatching moteurDeMatching = new MoteurDeMatching(selectionneurAvecSeuil, comparateur, generateur);

        List<Nom> l = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            System.out.println("tapez le nom");
            Nom nom = new Nom();
            nom.setNom(sc.nextLine());
            nom.setId(sc.nextInt());
            sc.nextLine(); // Important pour éviter l'erreur
            l.add(nom);
        }

        System.out.println("tapez le nom cible");
        Nom nom1 = new Nom();
        nom1.setNom(sc.nextLine());
        nom1.setId(sc.nextInt());
        sc.nextLine();
        List<Nom> resultat = moteurDeMatching.recherche(nom1, l);

        for (Nom nom : resultat) {
            System.out.println(nom.getNom());
        }
    }
}
