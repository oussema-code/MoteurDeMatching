import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double s = 0.5;
        Scanner sc = new Scanner(System.in);
        PretraiteurCaractereSpeciaux pretraiteur= new PretraiteurCaractereSpeciaux();
        SelectionneurAvecSeuil selectionneurAvecSeuil = new SelectionneurAvecSeuil(s);
        ComparateurLevenshtein comparateur = new ComparateurLevenshtein();
        GenerateurSansIndexeur generateur = new GenerateurSansIndexeur();
        IndexeurDictionnaire indexeurDictionnaire = new IndexeurDictionnaire();
        MoteurDeMatching moteurDeMatching = new MoteurDeMatching(selectionneurAvecSeuil, comparateur, generateur,indexeurDictionnaire,pretraiteur);
        List<Nom> l = new ArrayList<>();
        Nom name1= new Nom( "ousséma","1");
        Nom name2= new Nom("ouss@@maaaa","2");
        Nom name3= new Nom("oussem77aa","3");
        Nom name4= new Nom("oussem9797a","4");
        Nom name5= new Nom("ousseffffma","5");
        Nom name6= new Nom("oussemaaaa","6");
        Nom name7= new Nom("oussemapp","7");
        Nom name8= new Nom("oussemamma","8");
        Nom name9= new Nom("oussema","9");
        Nom name10= new Nom("oussemaéé","10");
        Nom name11= new Nom("oussema&&","11");
        Nom name12= new Nom("oussemaddd","12");
        l.add(name1);
        l.add(name2);
        l.add(name3);
        l.add(name4);
        l.add(name5);
        l.add(name6);
        l.add(name7);
        l.add(name8);
        l.add(name9);
        l.add(name10);
        l.add(name11);
        l.add(name12);
        Nom cible=new Nom( "oussema","15");
        List<Nom> resultat = new ArrayList<>();
        resultat=moteurDeMatching.recherche(cible,l);
        for (Nom nom : resultat) {
            System.out.println(nom.getNom());
        }
    }
}
