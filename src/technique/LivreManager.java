package technique;

import model.Categorie;
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
	
	public LivreManager(int rank, int id, Dao<LivrePOJO> d) {
		cle = rank;
		dao = d;
		pojo = d.select(id);
		model = Conversion.pojoToLivre(pojo);
	}

	@Override
	public String toString() {
		return "LivreManager [cle=" + cle + ", model=" + model + "]";
	}
	
	public LivrePOJO reserverLivre() {
		pojo.setQte(pojo.getQte()-1);
		dao.edit(pojo);
		return pojo;
	}
	
	public LivrePOJO lacherLivre() {
		pojo.setQte(pojo.getQte()+1);
		dao.edit(pojo);
		return pojo;
	}

	public int getCle() {
		return cle;
	}

	public void setCle(int cle) {
		this.cle = cle;
	}

	public Livre getLivre() {
		return model;
	}

	public void setModel(Livre model) {
		this.model = model;
	}
}
