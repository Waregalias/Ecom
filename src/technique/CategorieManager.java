package technique;

import model.Categorie;
import service.CategoriePOJO;
import storage.Dao;
import utilitaire.Conversion;

public class CategorieManager {
	private Categorie model;
	private CategoriePOJO pojo;
	private Dao<CategoriePOJO> dao;

	public CategorieManager() {
		// TODO Auto-generated constructor stub
	}
	
	public CategorieManager(int id, Dao<CategoriePOJO> d) {	
		dao = d;
		pojo = d.categorie(id);
		model = Conversion.pojoToCategorie(pojo);
	}
	
	@Override
	public String toString() {
		return "CategorieManager [model=" + model + "]";
	}
	
	public Categorie getCategorie() {
		return model;
	}

	public void setModel(Categorie model) {
		this.model = model;
	}

}
