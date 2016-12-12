package technique;

import model.Livre;
import service.LivrePOJO;
import storage.Dao;
import utilitaire.Conversion;

public class LivreManager {
	private int cle;
	private Livre model;
	private LivrePOJO pojo;
	private Dao<LivrePOJO> dao;

	public LivreManager() {
		// TODO Auto-generated constructor stub
	}
	
	public LivreManager(int id, Dao<LivrePOJO> d) {
		cle = id;
		dao = d;
		pojo = d.select(id);
		model = Conversion.pojoToLivre(pojo);
	}

	@Override
	public String toString() {
		return "LivreManager [cle=" + cle + ", model=" + model + "]";
	}
}
