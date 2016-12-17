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
	
	public Livre reserverLivre() {
		Livre ret = null;
		pojo.setQte(pojo.getQte()-1);
		dao.edit(pojo);
		return ret;
	}
	
	public void lacherLivre() {
		Livre ret = null;
		pojo.setQte(pojo.getQte()+1);
		dao.edit(pojo);
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
