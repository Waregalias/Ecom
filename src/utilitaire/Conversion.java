package utilitaire;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import model.Categorie;
import model.Livre;
import service.CategoriePOJO;
import service.LivrePOJO;

public abstract class Conversion {
	private static final String PAQ = "model.";
	public static Livre pojoToLivre(LivrePOJO lp)
	{	
		Livre ret = null;
		ret = new Livre(lp.getNom(), lp.getDescription(), lp.getPrix(), lp.getQte(), lp.getImage());		
		return ret;
	}
	
	public static Categorie pojoToCategorie(CategoriePOJO cp)
	{	
		Categorie ret = null;
		ret = new Categorie(cp.getNom(), cp.getDescription(), cp.getImage());
		return ret;
	}
}
