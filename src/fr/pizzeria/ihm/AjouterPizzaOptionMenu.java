package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {
	
	public AjouterPizzaOptionMenu(PizzaDaoImpl dao, Scanner scan, String libelle) {
		super(dao, scan, libelle);
	}
	
	public void execute() {
		System.out.println("***** Ajout d'une nouvelle pizza");	
		System.out.println("Veuillez saisir le code:");
		String code = scan.next();
		System.out.println("Veuillez saisir le nom:");
		String nom = scan.next();
		System.out.println("Veuillez saisir le prix:");
		double prix = scan.nextDouble();
		
		//creation de l'objet Pizza
		Pizza newPizza  = new Pizza(code,nom,prix);
		dao.saveNewPizza(newPizza);
	}

}
