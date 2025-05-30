import java.util.*;
public class MoteurDeMatching {
	    Selectionneur selectionneur;
	    ComparateurDeChaine comparateur;
	    GenerateurDeCandidats generateur;
		Indexeur indexeur;
		Pretraiteur pretraiteur;

	    
	    public MoteurDeMatching(Selectionneur selectionneur , ComparateurDeChaine comparateur,GenerateurDeCandidats generateur,Indexeur indexeur,Pretraiteur pretraiteur) {
		    this.selectionneur=selectionneur;
		    this.comparateur=comparateur;
		    this.generateur=generateur;
			this.indexeur=indexeur;
			this.pretraiteur=pretraiteur;
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
			pretraiteur.traiter(ListeDeNoms);
			pretraiteur.traiter(ListeDeCible);
			resultat=selectionneur.selectionner(preparer(generateur.generer(ListeDeCible,ListeDeNoms),comparateur))  ;

			return resultat;
			}
		public List<Nom> comparer(List<Nom> ListeDeNoms,List<Nom> ListeDeNoms1) {
			List<Nom> resultat= new ArrayList<>();
			pretraiteur.traiter(ListeDeNoms1);
			pretraiteur.traiter(ListeDeNoms);
			resultat=selectionneur.selectionner(preparer(generateur.generer(ListeDeNoms,ListeDeNoms1),comparateur))  ;
			return resultat;
		}
	public List<Nom> dedupliquer(List<Nom> ListeDeNoms) {
		List<Nom> ListeOriginale = new ArrayList<>(ListeDeNoms);
		pretraiteur.traiter(ListeDeNoms);
		List<Nom> doublons = selectionneur.selectionner(
				preparer(generateur.generer(ListeDeNoms, ListeDeNoms), comparateur)
		);
		ListeOriginale.removeAll(doublons);

		return ListeOriginale;
	}
}
