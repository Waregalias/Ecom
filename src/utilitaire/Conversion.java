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
		Class<?> aEtudier = null;
		Livre livre = null;
		Constructor<?> monConst = null;
		Class<?> lesTypes[] = null;
		Object []lesValeurs = null;
		
		ret = new Livre();

		if(lp.getNom() != null)
		{
			lesTypes = new Class<?>[5];
			lesValeurs = new Object[5];

			lesTypes[0] = String.class;
			lesTypes[1] = String.class;
			lesTypes[2] = double.class;
			lesTypes[3] = int.class;
			lesTypes[4] = String.class;

			lesValeurs[0] = lp.getNom();
			lesValeurs[1] = lp.getDescription();
			lesValeurs[2] = lp.getPrix();
			lesValeurs[3] = lp.getQte();
			lesValeurs[4] = lp.getImage();
			
			try 
			{
				aEtudier = Class.forName("model.Livre");
				monConst = aEtudier.getConstructor(lesTypes);
				livre = (Livre) monConst.newInstance(lesValeurs);
				System.out.println(livre);
			} 
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ret;
	}
}
