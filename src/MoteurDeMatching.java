import java.util.*;


public class MoteurDeMatching {
	    Selectionneur selectionneur;
	    ComparateurLevenshtein comparateur;
	    GenerateurDeCandidats generateur;
		IndexeurDictionnaire indexeur;
		PretraiteurCaractereSpeciaux pretraiteurCaractereSpeciaux;

	    
	    public MoteurDeMatching(Selectionneur selectionneur , ComparateurLevenshtein egalite,GenerateurDeCandidats generateur,IndexeurDictionnaire indexeur,PretraiteurCaractereSpeciaux pretraiteurCaractereSpeciaux) {
		    this.selectionneur=selectionneur;
		    this.comparateur=egalite;
		    this.generateur=generateur;
			this.indexeur=indexeur;
			this.pretraiteurCaractereSpeciaux=pretraiteurCaractereSpeciaux;
	    }
		public List<CoupleAvecScore> preparer(List<Couple> L,ComparateurLevenshtein e){
			List<CoupleAvecScore> resultat=new ArrayList<>();
			for(Couple element:L){
				CoupleAvecScore cas= new CoupleAvecScore(element,e.comparer(element.getNom1(), element.getNom2()));
				resultat.add(cas);
			}
			return resultat;
		}
	    public List<Nom> recherche(Nom monNom,List<Nom> ListeDeNoms) {
	    	List<Nom> ListeDeCible=new ArrayList<Nom>();
			ListeDeCible.add(monNom);
			List<Nom> resultat= new ArrayList<>();
			ListeDeNoms=pretraiteurCaractereSpeciaux.traiter(ListeDeNoms);
			resultat=selectionneur.selectionner(preparer(generateur.generer(ListeDeCible,ListeDeNoms),comparateur))  ;

			return resultat;
			}



}
