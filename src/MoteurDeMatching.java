import java.util.*;


public class MoteurDeMatching {
	    Selectionneur selectionneur;
	    ComparateurDeChaine comparateur;
	    GenerateurDeCandidats generateur;
	    
	    public MoteurDeMatching(Selectionneur selectionneur , ComparateurDeChaine egalite,GenerateurDeCandidats generateur) {
		    this.selectionneur=selectionneur;
		    this.comparateur=egalite;
		    this.generateur=generateur;
	    }
		public List<CoupleAvecScore> preparer(List<Couple> L,ComparateurDeChaine e){
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
			resultat=selectionneur.selectionner(preparer(generateur.generer(ListeDeCible,ListeDeNoms),comparateur))  ;
			return resultat;
			}



}
