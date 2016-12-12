package model;

import service.LivrePOJO;
import storage.Dao;
import utilitaire.Conversion;

public class Livre {
	private String nom;
	private String description;
	private double prix;
	private int qte;
	private String image;

	public Livre() {
		// TODO Auto-generated constructor stub
	}
	
	public Livre(String nom, String description, double prix, int qte, String image) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.qte = qte;
		this.image = image;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(short qte) {
		this.qte = qte;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Livre [nom=" + nom + ", description=" + description + ", prix=" + prix + ", qte=" + qte + ", image="
				+ image + "]";
	}

}
