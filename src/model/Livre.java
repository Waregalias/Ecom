package model;

import service.LivrePOJO;
import storage.Dao;

public class Livre {
	private String nom;
	private String description;
	private double prix;
	private int qte;
	private String image;
	
	private int cle;
	private Livre modele;
	private LivrePOJO pojo;
	private Dao<LivrePOJO> dao;

	public Livre() {
		// TODO Auto-generated constructor stub
	}
	
	public Livre(int id, Dao<LivrePOJO> d) {
		cle = id;
		dao = d;
		pojo = d.select(id);
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

}
