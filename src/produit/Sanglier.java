package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	private int poids;
	private Gaulois chasseur;
	
	public Sanglier(int poids, Gaulois chasseur) {
		super("sanglier", Unite.kg);
		this.chasseur = chasseur;
		this.poids = poids;
	}
	
	public int getPoids() {
		return poids;
	}


	public Gaulois getChasseur() {
		return chasseur;
	}
	
	
	@Override
	public void decrireProduit() {
		StringBuilder sb = new StringBuilder();
		sb.append(getNom());
		sb.append(" de ");
		sb.append(poids);
		sb.append(" ");
		sb.append(getUnite());
		sb.append(" chassé par ");
		sb.append(chasseur.getNom());
		System.out.println(sb.toString());
	}

}
