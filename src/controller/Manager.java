package controller;

import java.util.List;

import service.CategoriePOJO;
import storage.Dao;
import storage.DaoJPA;

public class Manager {

	public Manager() {
		// TODO Auto-generated constructor stub
	}
	
	public void init() {
		/*Dao<CategoriePOJO> dao = null;
		dao = (Dao<CategoriePOJO>) DaoFactory.getInstance().getDao(DaoType.JPA);
		
		List<CategoriePOJO> tmp = null;
		tmp = (List<CategoriePOJO>) dao.selectAll();
		for(CategoriePOJO cp : tmp)
		{
			lesCages.add(new CageManager(cp.getIdAnimal(), dao));
		}*/
	}

}
