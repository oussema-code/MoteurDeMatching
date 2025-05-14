import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Configurer les paramètres :");

        // Choix du prétraiteur
        System.out.println("1. Choisir les prétraitements :");
        System.out.println("1. Minuscule seulement");
        System.out.println("2. Caractere Speciaux");
        System.out.println("3. Ben Standardizer");
        int pretraiteurChoice = scanner.nextInt();
        scanner.nextLine();

        Pretraiteur pretraiteur;
        switch (pretraiteurChoice) {
            case 1 -> pretraiteur = new PretraiteurToMiniscule();
            case 2 -> pretraiteur = new PretraiteurCaractereSpeciaux();
            case 3 -> pretraiteur = new PretraiteurBenStandardizer();

            default -> {
                System.out.println("Choix invalide. Utilisation du prétraiteur par défaut.");
                pretraiteur = new PretraiteurCaractereSpeciaux();
            }
        }

        // Choix du comparateur
        System.out.println("2. Choisir une mesure de comparaison :");
        System.out.println("1. ComparateurExacte");
        System.out.println("2. ComparateurJaroWinkler");
        System.out.println("3. ComparateurLevenshtein");
        int comparateurChoice = scanner.nextInt();
        scanner.nextLine();

        ComparateurDeChaine comparateur;
        switch (comparateurChoice) {
            case 1 -> comparateur = new ComparateurExacte();
            case 2 -> comparateur = new ComparateurJaroWinkler();
            case 3 -> comparateur = new ComparateurLevenshtein();
            default -> {
                System.out.println("Choix invalide. Comparateur Levenshtein sélectionné par défaut.");
                comparateur = new ComparateurLevenshtein();
            }
        }

        // Choix du sélectionneur
        System.out.println("3. Choisir une méthode de sélection :");
        System.out.println("1. Par seuil");
        System.out.println("2. Top-N-Meilleur");
        System.out.println("3. Tous");
        int selectionneurChoice = scanner.nextInt();
        scanner.nextLine();

        Selectionneur selectionneur;
        switch (selectionneurChoice) {
            case 1 -> {
                System.out.println("Donner le seuil :");
                double seuil = scanner.nextDouble();
                scanner.nextLine();
                selectionneur = new SelectionneurAvecSeuil(seuil);
            }
            case 2 -> {
                System.out.println("Donner le nombre de résultats N :");
                int n = scanner.nextInt();
                scanner.nextLine();
                selectionneur = new SelectionneurDeNMeilleur(n);
            }
            case 3 -> {
                selectionneur = new SelectionneurTous();
            }
            default -> {
                System.out.println("Choix invalide. Utilisation du sélectionneur par seuil avec seuil = 0.8");
                selectionneur = new SelectionneurAvecSeuil(0.8);
            }
        }
        System.out.println("4. Choisir le générateur de candidats :");
        System.out.println("1. Simple");
        System.out.println("2. Sans indexeur");
        System.out.println("3. Avec indexeur");
        int generateurChoice = scanner.nextInt();
        scanner.nextLine();

        GenerateurDeCandidats generateur;
        switch (generateurChoice) {
            case 1 -> generateur = new GenerateurSimple();
            case 2 -> generateur = new GenerateurSansIndexeur();
            case 3 -> generateur = new GenerateurAvecIndexeur();
            default -> {
                System.out.println("Choix invalide. Générateur avec indexeur sélectionné par défaut.");
                generateur = new GenerateurAvecIndexeur();
            }
        }


        IndexeurDictionnaire indexeur = new IndexeurDictionnaire();

        MoteurDeMatching moteur = new MoteurDeMatching(selectionneur,  comparateur, generateur, indexeur,  pretraiteur);

        while (true) {
            System.out.println("\nMenu :");
            System.out.println("1. Effectuer une recherche");
            System.out.println("2. Comparer deux listes");
            System.out.println("3. Dédupliquer une liste");
            System.out.println("4. Quitter");
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1 -> {
                    System.out.println("Saisir le nom à rechercher :");
                    String nom = scanner.nextLine();
                    System.out.println("Fournir le fichier CSV :");
                    String fichier = scanner.nextLine();
                    Nom nomRecherche = new Nom(nom, "0");
                    DataImporter importer = new LocalCSVDataImporter(fichier);
                    List<Nom> liste = importer.importData();
                    long startTime=System.nanoTime();
                    List<Nom> resultats = moteur.recherche(nomRecherche, liste);
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime;
                    resultats.forEach(System.out::println);
                    System.out.println("Execution time in milliseconds: " + (duration / 1000000));

                }
                case 2 -> {
                    System.out.println("Fournir le premier fichier :");
                    String fichier1 = scanner.nextLine();
                    System.out.println("Fournir le second fichier :");
                    String fichier2 = scanner.nextLine();
                    DataImporter importer1 = new LocalCSVDataImporter(fichier1);
                    DataImporter importer2 = new LocalCSVDataImporter(fichier2);
                    List<Nom> liste1 = importer1.importData();
                    List<Nom> liste2 = importer2.importData();
                    long startTime=System.nanoTime();
                    List<Nom> resultats = moteur.comparer(liste1, liste2);
                    resultats.forEach(System.out::println);
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime;
                    System.out.println("Execution time in milliseconds: " + (duration / 1_000_000));
                }
                case 3 -> {
                    System.out.println("Fournir le fichier CSV :");
                    String fichier1 = scanner.nextLine();
                    DataImporter importer1 = new LocalCSVDataImporter(fichier1);
                    List<Nom> liste1 = importer1.importData();
                    long startTime=System.nanoTime();
                    List<Nom> resultats = moteur.dedupliquer(liste1);
                    resultats.forEach(System.out::println);
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime;
                    System.out.println("Execution time in milliseconds: " + (duration / 1_000_000));
                }
                case 4 -> {
                    System.out.println("Au revoir !");
                    return;
                }
                default -> System.out.println("Choix invalide.");
            }
        }
    }
}
