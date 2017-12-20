package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {
	
	public ModifierPizzaOptionMenu(PizzaDaoImpl dao, Scanner scan, String libelle) {
		super(dao, scan, libelle);
	}

	public void execute() {
		
		System.out.println("***** Mise à jour d'une pizza");
		System.out.println("Veuillez saisir le code de la pizza à modifier:");
		System.out.println("(99 pour abandonner)");
		String codePizzaUpdate = scan.next();
		
		if(codePizzaUpdate.equals("99")) {
			return;
		}
		else {
			System.out.println("Veuillez saisir le code:");
			String codeUpdate = scan.next();
			System.out.println("Veuillez saisir le nom:");
			String nomUpdate = scan.next();
			System.out.println("Veuillez saisir le prix:");
			double prixUpdate = scan.nextDouble();
			
			Pizza pizza = new Pizza(codeUpdate, nomUpdate, prixUpdate);
			dao.updatePizza(codePizzaUpdate, pizza);
			
		}
		
	}
}
