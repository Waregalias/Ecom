package model;

public class Categorie {
	private String nom;
	private String description;
	private String image;

	public Categorie() {
		// TODO Auto-generated constructor stub
	}
	
	public Categorie(String nom, String description, String image) {
		super();
		this.nom = nom;
		this.description = description;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Categorie [nom=" + nom + ", description=" + description + ", image=" + image + "]";
	}
	
}
