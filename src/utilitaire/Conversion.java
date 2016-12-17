package utilitaire;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import model.Livre;
import service.LivrePOJO;

public abstract class Conversion {
	private static final String PAQ = "model.";
	public static Livre pojoToLivre(LivrePOJO lp)
	{	
		Livre ret = null;
		ret = new Livre(lp.getNom(), lp.getDescription(), lp.getPrix(), lp.getQte(), lp.getImage());		
		return ret;
	}
}
