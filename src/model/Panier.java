package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import service.LivrePOJO;

public class Panier {
	// Panier doit être unique à chaque lancement
	private static Panier instance = new Panier();
	private static float LIVRAISON = 23;
	private Map<LivrePOJO, Integer> panier;
	private float uprix;
	private float total;

	// APPELER LES FONCTIONS DU LIVREMANAGER
	// POUR L'ECHANGE AVEC LA DAO
	
	// LE MODEL PANIER ACTUEL EFFECTUE UNIQUEMENT
	// LES CONTROLES D'AFFICHAGE
	
	public Panier() {
		panier = new HashMap<>();
		uprix = 0;
		total = 0;
	}
	
	public void ajouterProduit(LivrePOJO livre) {
		// TODO: Tester qu'on en ajoute pas + que la limite
		if(panier.containsKey(livre.getId())) {
			panier.put(livre, panier.get(livre)+1);
		}
		else {
			panier.put(livre, 1);
		}
	}
	
	public void supprimerProduit(Livre livre) {
		panier.remove(livre, 1);
	}
	
	public float afficherTotal() {
		for ( Entry<LivrePOJO, Integer> entry : panier.entrySet()) {
            Integer qte = entry.getValue();
            uprix = entry.getKey().getPrix();
            total += uprix * qte;
        }
		total += LIVRAISON;
		
		return total;
	}
}
