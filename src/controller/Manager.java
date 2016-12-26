package controller;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.naming.remote.client.InitialContextFactory;

import model.Categorie;
import model.Livre;
import model.Panier;
import service.CategoriePOJO;
import service.LivrePOJO;
import storage.Dao;
import storage.DaoJPA;
import storage.DaoJPARemote;
import technique.CategorieManager;
import technique.LivreManager;

public class Manager {
	private static Manager instance = new Manager();
	private List<LivreManager> lesLivres;
	private List<CategorieManager> lesCategories;
	private Panier panier;
	private int rank;
	@EJB
	private Dao<LivrePOJO> dao;
	@EJB
	private Dao<CategoriePOJO> daoCat;
	
	
	public Manager() {
		lesLivres = new Vector<>();
		lesCategories = new Vector<>();
		init();
	}
	
	public static Manager getInstance() {
		return instance;
	}
	
	public static void reset() {
		instance = new Manager();
	}
	
	public void init() {
		try {
			rank=0;
			dao = InitialContext.doLookup("java:module/DaoJPA");
			daoCat = InitialContext.doLookup("java:module/DaoJPA");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		ajouterCategories(daoCat);
		ajouterLivres(dao);
		readDaoEJB();
	}
	
	private void readDaoEJB() {
		DaoJPARemote dao = null;
		try {
			dao = InitialContext.doLookup("java:global/Oreilly/DaoJPA!storage.DaoJPARemote");
			ajouterLivres(dao);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<LivreManager> afficherLivres() {
		return lesLivres;
	}
	
	public List<CategorieManager> afficherCategories() {
		return lesCategories;
	}
	
	public void ajouterLivres(Dao<LivrePOJO> dao) {
		List<LivrePOJO> tmp = null;
		tmp = (List<LivrePOJO>) dao.selectAll();
		
		for(LivrePOJO lp : tmp)
		{
			lesLivres.add(new LivreManager(rank, lp.getId(), dao));
			rank++;
		}
	}
	
	public void ajouterCategories(Dao<CategoriePOJO> daoCat) {
		List<CategoriePOJO> tmp = null;
		tmp = daoCat.categorieAll();
		
		for(CategoriePOJO cp : tmp)
		{
			lesCategories.add(new CategorieManager(cp.getId(), daoCat));
		}
	}
	
	public void createPanier() {
		panier = new Panier();
	}
	
	public void payerLivres() {
		panier = null;
	}
	
	public void reserverLivres(int idLivre) {
		lesLivres.get(idLivre).reserverLivre();
		//panier.ajouterLivre(lesLivres.get(idLivre).reserverLivre());
	}
	
	public void rendreLivres(int idLivre) {
		lesLivres.get(idLivre).lacherLivre();
		//panier.supprimerLivre(lesLivres.get(idLivre).lacherLivre());
	}
		
}