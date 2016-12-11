package view;

import java.util.Arrays;
import java.util.List;

import controller.Manager;
import model.Livre;

public class Ecom {
	
	public Ecom() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Ecom ecom = null;
		ecom = new Ecom();
		
		ecom.afficher();
	}
	
	public void afficher() {
		List<Livre> tmp = null;
		tmp = Manager.getInstance().afficherLivres();
		Arrays.asList(tmp).forEach(System.out::println);
	}
}
