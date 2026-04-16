package produit;

public abstract class Produit {
	private String nom;
	private Unite unite;
	
	public String getNom() {
		return nom;
	}

	public Unite getUnite() {
		return unite;
	}

	public Produit(String nom, Unite unite) {
		this.nom = nom;
		this.unite = unite;
	}

	public abstract void decrireProduit();
}
