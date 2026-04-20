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
	public String decrireProduit() {
		StringBuilder sb = new StringBuilder();
		sb.append(getNom());
		sb.append(" p�ch�s ");
		sb.append(date);
		return(sb.toString());
	}
}
