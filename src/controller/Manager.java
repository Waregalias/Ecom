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

import model.Livre;
import model.Panier;
import service.LivrePOJO;
import storage.Dao;
import storage.DaoJPA;
import storage.DaoJPARemote;
import technique.LivreManager;

public class Manager {
	private static Manager instance = new Manager();
	private List<LivreManager> lesLivres;
	private Panier panier;
	private int rank;
	@EJB
	private Dao<LivrePOJO> dao;
	
	public Manager() {
		lesLivres = new Vector<>();
		init();
		
		//reserverLivres();
		//rendreLivres();
	}
	
	public static Manager getInstance() {
		return instance;
	}
	
	public void init() {
		try {
			rank=0;
			dao = InitialContext.doLookup("java:module/DaoJPA");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	public void ajouterLivres(Dao<LivrePOJO> dao) {
		List<LivrePOJO> tmp = null;
		tmp = (List<LivrePOJO>) dao.selectAll();
		for(LivrePOJO lp : tmp)
		{
			lesLivres.add(new LivreManager(rank, lp.getId(), dao));
			rank++;
		}
	}
	
	public void createPanier() {
		panier = new Panier();
	}
	
	public void payerLivres() {
		
	}
	
	public void reserverLivres() {
		panier.ajouterLivre(lesLivres.get(0).reserverLivre()); //replace (0) par id livre issue de la servlet
	}
	
	public void rendreLivres() {
		panier.supprimerLivre(lesLivres.get(0).lacherLivre()); //replace (0) par id livre issue de la servlet
	}
		
}