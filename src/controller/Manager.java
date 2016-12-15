package controller;

import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.naming.remote.client.InitialContextFactory;

import model.Livre;
import service.LivrePOJO;
import storage.Dao;
import storage.DaoJPA;
import technique.LivreManager;
import oreilly.DaoJPARemote;

public class Manager {
	private static Manager instance = new Manager();
	public List<LivreManager> lesLivres;
	private Dao<?> dao = new DaoJPA<LivrePOJO>();
	
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
		Dao<LivrePOJO> dao = null;
		dao = (Dao<LivrePOJO>) this.dao;
		
		ajouterLivres(dao);
		//readDaoEJB();
	}
	
	private void readDaoEJB() {
		DaoJPARemote dao = null;
		InitialContext contexte = null;
		Properties env = null;
		
		try {
			env = new Properties();
		    env.put("jboss.naming.client.ejb.context", true); 
		    env.put(Context.INITIAL_CONTEXT_FACTORY, InitialContextFactory.class.getName());
			env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
			contexte = new InitialContext(env);
			dao = InitialContext.doLookup("java:global/oreilly/DaoJPA!oreilly.storage.DaoJPARemote"); 
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
			lesLivres.add(new LivreManager(lp.getId(), dao));
		}
	}
	
	public void reserverLivres() { // ajouter un param�tre LivrePOJO
		lesLivres.get(0).reserverLivre(); // changer le param�tre get(*) par l'id du LivrePOJO
	}
	
	public void rendreLivres() { // ajouter un param�tre LivrePOJO
		lesLivres.get(0).lacherLivre(); // changer le param�tre get(*) par l'id du LivrePOJO
	}
		
}
