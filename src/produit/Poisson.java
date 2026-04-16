package produit;

public class Poisson extends Produit {
	private String date;
	
	public Poisson(String date) {
		super("poisson", Unite.piece);
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}

	@Override
	public void decrireProduit() {
		StringBuilder sb = new StringBuilder();
		sb.append(getNom());
		sb.append(" pêchés ");
		sb.append(date);
	}
}
