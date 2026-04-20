package produit;

public interface IProduit {

	String getNom();

	Unite getUnite();

	String decrireProduit();
	
	default int calculerPrix(int prix) {
		return prix;
	}

}