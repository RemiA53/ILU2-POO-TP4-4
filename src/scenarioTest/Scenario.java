package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import villagegaulois.IVillage;

public class Scenario {

	public static void main(String[] args) {

		// TODO Partie 4 : creer de la classe anonyme Village
		IVillage village = new IVillage() {
			private int nbEtal = 0;
			private IEtal[] marche = new IEtal[100];
			@Override
			public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix) {
				etal.installerVendeur(vendeur, produit, prix);
				marche[nbEtal] = etal;
				nbEtal++;
				return etal.isEtalOccupe();
			}
			
			@Override
			public void acheterProduit(String produit, int quantiteSouhaitee) {
				int quantiteRestante = quantiteSouhaitee;
				for (int i = 0; i < nbEtal && quantiteRestante!=0; i++) {
					IEtal etal = marche[i];
					int quantiteDisponible = etal.contientProduit(produit, quantiteRestante);
					if (quantiteDisponible != 0) {
						int prix = etal.acheterProduit(quantiteDisponible);
						StringBuilder sb = new StringBuilder();
						sb.append("A l'étal n° ");
						sb.append(i + 1);
						sb.append(", j'achète ");
						sb.append(quantiteDisponible);
						sb.append(" ");
						sb.append(produit);
						sb.append(" et je le paye ");
						sb.append(prix);
						sb.append(" sous.");
						System.out.println(sb.toString());
						quantiteRestante -= quantiteDisponible;
					}
				}
				StringBuilder sb = new StringBuilder();
				sb.append("Je voulais ");
				sb.append(quantiteSouhaitee);
				sb.append(" ");
				sb.append(produit);
				sb.append(", j'en ai acheté ");
				sb.append(quantiteSouhaitee - quantiteRestante);
				sb.append(".\n");
				System.out.println(sb.toString());
			}
			
			@Override
			public String toString() {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < nbEtal; i++) {
					sb.append(marche[i].etatEtal());
				}
				return sb.toString();
			}
		};
		// fin

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(200, obelix);
		Sanglier sanglier2 = new Sanglier(150, obelix);
		Sanglier sanglier3 = new Sanglier(100, asterix);
		Sanglier sanglier4 = new Sanglier(50, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		village.acheterProduit("sanglier", 3);

		System.out.println(village);
	}

}

