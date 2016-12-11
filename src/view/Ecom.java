package view;

import java.util.Arrays;

import controller.Manager;

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
		String[] tmp = null;
		tmp = Manager.getInstance().afficherLivres();
		Arrays.asList(tmp).forEach(System.out::println);
	}
	
}
