package controller;

import java.util.List;
import java.util.Vector;

import model.Livre;
import service.LivrePOJO;
import storage.Dao;
import storage.DaoJPA;
import technique.LivreManager;

public class Manager {
	private static Manager instance = new Manager();
	private Dao<?> dao = new DaoJPA<LivrePOJO>();
	public List<LivreManager> lesLivres;
	
	public Manager() {
		lesLivres = new Vector<>();
		init();
	}
	
	public static Manager getInstance() {
		return instance;
	}
	
	public void init() {
		Dao<LivrePOJO> dao = null;
		dao = (Dao<LivrePOJO>) this.dao;
		
		List<LivrePOJO> tmp = null;
		tmp = (List<LivrePOJO>) dao.selectAll();
		for(LivrePOJO lp : tmp)
		{
			lesLivres.add(new LivreManager(lp.getId(), dao));
		}
	}
	
	public List<LivreManager> afficherLivres() {
		return lesLivres;
	}
}
