package controller;

import java.util.List;

import model.Livre;
import service.LivrePOJO;
import storage.Dao;
import storage.DaoJPA;

public class Manager {
	private static Manager instance = new Manager();
	private Dao<?> dao = new DaoJPA<LivrePOJO>();
	public List<Livre> lesLivres;
	
	public Manager() {
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
			lesLivres.add(new Livre(lp.getId(), dao));
		}
	}
	
	public List<Livre> afficherLivres() {
		return lesLivres;
	}
}
