package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;

public interface IVillage {
	<P extends IProduit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, IProduit[] produit, int prix);

	void acheterProduit(String produit, int quantiteSouhaitee);
}
